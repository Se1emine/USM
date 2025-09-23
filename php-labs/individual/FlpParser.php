<?php

class FlpParser {
    
    private $flStudioVersions = [
        1 => 'FL Studio 1.0',
        2 => 'FL Studio 2.0',
        3 => 'FL Studio 3.0',
        4 => 'FL Studio 4.0',
        5 => 'FL Studio 5.0',
        6 => 'FL Studio 6.0',
        7 => 'FL Studio 7.0',
        8 => 'FL Studio 8.0',
        9 => 'FL Studio 9.0',
        10 => 'FL Studio 10.0',
        11 => 'FL Studio 11.0',
        12 => 'FL Studio 12.0',
        20 => 'FL Studio 20.0',
        21 => 'FL Studio 21.0',
        22 => 'FL Studio 22.0',
        23 => 'FL Studio 23.0',
        24 => 'FL Studio 24.0',
        25 => 'FL Studio 25.0'
    ];
    
    // Ключевые слова и известные названия, помогающие отличить плагины от названий каналов/клипов
    private $knownPluginKeywords = [
        'vst', 'vst3', 'plugin', 'synth', 'synthesizer', 'fx', 'effect', 'generator',
        'fruity', 'harmor', 'harmless', 'sytrus', 'gms', '3xosc', 'poizone', 'sakura',
        'massive', 'serum', 'omnisphere', 'kontakt', 'nexus', 'sylenth', 'vital',
        'archetype', 'neural dsp', 'plini', 'labs', 'valhalla', 'waves', 'izotope',
    ];
    private $knownPluginNames = [
        'Archetype Plini', 'Archetype Plini X', 'Archetype Gojira', 'Archetype Nolly',
        'Fruity Parametric EQ 2', 'Fruity Reeverb 2', 'Fruity Limiter', 'Fruity Compressor',
        'Gross Beat', 'Sytrus', 'Harmor', 'Harmless', '3xOsc', 'GMS', 'Flex', 'Sakura',
        'Serum', 'Massive', 'Omnisphere', 'Kontakt', 'Nexus', 'Sylenth1', 'Vital',
        'ValhallaRoom', 'ValhallaVintageVerb', 'Ozone', 'Neutron', 'Guitar Rig',
    ];
    
    public function parseFlpFile($filePath) {
        if (!file_exists($filePath)) {
            throw new Exception('Файл не найден');
        }
        
        $fileHandle = fopen($filePath, 'rb');
        if (!$fileHandle) {
            throw new Exception('Не удалось открыть файл для чтения');
        }
        
        $projectInfo = [
            'project_name' => '',
            'fl_version' => 'Неизвестно',
            'fl_version_raw' => 0,
            'fl_version_bytes' => [0,0,0,0],
            'file_size' => filesize($filePath),
            'patterns_count' => 0,
            'channels_count' => 0,
            'plugins' => [],
            'audio_clips' => [],
            'tempo' => 0,
            'time_signature' => '',
            'project_length' => 0,
            'sample_rate' => 0
        ];
        
        try {
            // Проверяем заголовок FLP файла
            $header = fread($fileHandle, 4);
            if ($header !== 'FLhd') {
                throw new Exception('Неверный формат .flp файла');
            }
            
            // Читаем размер заголовка
            $headerSize = $this->readInt32($fileHandle);
            
            // Читаем тип формата (должен быть 0)
            $formatType = $this->readInt16($fileHandle);
            
            // Читаем количество каналов
            $projectInfo['channels_count'] = $this->readInt16($fileHandle);
            
            // Читаем PPQ (Pulses Per Quarter note)
            $ppq = $this->readInt16($fileHandle);
            
            // Пропускаем остальную часть заголовка
            fseek($fileHandle, $headerSize + 8);
            
            // Читаем чанк данных
            $dataHeader = fread($fileHandle, 4);
            if ($dataHeader !== 'FLdt') {
                throw new Exception('Неверная структура .flp файла');
            }
            
            $dataSize = $this->readInt32($fileHandle);
            
            // Парсим события в файле
            $this->parseEvents($fileHandle, $projectInfo, $dataSize);
            
        } catch (Exception $e) {
            fclose($fileHandle);
            throw $e;
        }
        
        fclose($fileHandle);
        return $projectInfo;
    }
    
    private function parseEvents($fileHandle, &$projectInfo, $dataSize) {
        $bytesRead = 0;
        $patternCount = 0;
        $pluginNames = [];
        
        while ($bytesRead < $dataSize && !feof($fileHandle)) {
            // Safely read event id
            $b = fread($fileHandle, 1);
            if ($b === false || $b === '') { break; }
            $eventId = ord($b);
            $bytesRead++;
            
            if ($eventId >= 0 && $eventId <= 63) {
                // Байтовые события
                $value = ord(fread($fileHandle, 1));
                $bytesRead++;
                
                switch ($eventId) {
                    case 159: // Tempo
                        $projectInfo['tempo'] = $value;
                        break;
                }
                
            } elseif ($eventId >= 64 && $eventId <= 127) {
                // Word события (2 байта)
                $value = $this->readInt16($fileHandle);
                $bytesRead += 2;
                
            } elseif ($eventId >= 128 && $eventId <= 191) {
                // DWord события (4 байта)
                $value = $this->readInt32($fileHandle);
                $bytesRead += 4;
                
                switch ($eventId) {
                    case 156: // Версия FL Studio
                        $projectInfo['fl_version_raw'] = $value;
                        // Сохраняем байты LE для отладки
                        $projectInfo['fl_version_bytes'] = [
                            $value & 0xFF,
                            ($value >> 8) & 0xFF,
                            ($value >> 16) & 0xFF,
                            ($value >> 24) & 0xFF,
                        ];
                        $decoded = $this->decodeFlVersion($value);
                        $projectInfo['fl_version'] = $decoded;
                        break;
                        
                    case 28: // Количество паттернов
                        $patternCount++;
                        break;
                }
                
            } elseif ($eventId >= 192 && $eventId <= 255) {
                // Текстовые/бинарные события переменной длины
                $lenByte = fread($fileHandle, 1);
                if ($lenByte === false || $lenByte === '') { break; }
                $length = ord($lenByte);
                $bytesRead++;

                // Обработка возможной длинной длины (минимальная защита)
                if ($length & 0x80) {
                    $next = fread($fileHandle, 1);
                    if ($next === false || $next === '') { break; }
                    $length = ($length & 0x7F) | (ord($next) << 7);
                    $bytesRead++;
                }
                
                // Защита: длина не может быть отрицательной/нулевой, и не должна выходить за пределы чанка
                if ($length <= 0) { continue; }
                $remaining = $dataSize - $bytesRead;
                if ($remaining <= 0) { break; }
                if ($length > $remaining) { $length = $remaining; }

                $data = fread($fileHandle, $length);
                if ($data === false) { break; }
                $actual = strlen($data);
                $bytesRead += $actual;
                if ($actual <= 0) { continue; }
                
                switch ($eventId) {
                    case 194: // Название проекта
                        $projectInfo['project_name'] = $this->cleanString($data);
                        break;
                        
                    case 203: // Название плагина/инструмента или канала/клипа (в некоторых случаях)
                        $pluginName = $this->cleanString($data);
                        if ($this->isLikelyPluginName($pluginName)) {
                            $norm = $this->normalizeName($pluginName);
                            if (!in_array($norm, array_map([$this, 'normalizeName'], $pluginNames))) {
                                $pluginNames[] = $pluginName;
                            }
                        } else {
                            // Распознаем как аудиоклип/стем, если это похоже на медиа-имя
                            if ($this->isLikelyAudioClipName($pluginName)) {
                                if (!in_array($pluginName, $projectInfo['audio_clips'])) {
                                    $projectInfo['audio_clips'][] = $pluginName;
                                }
                            }
                        }
                        break;
                        
                    case 206: // Название канала
                        // Можно использовать для подсчета каналов
                        break;
                }
            }
            
            // Защита от бесконечного цикла
            if ($bytesRead > $dataSize * 2) {
                break;
            }
        }
        
        $projectInfo['patterns_count'] = max($patternCount, 1);
        $projectInfo['plugins'] = $pluginNames;
        
        // Если название проекта не найдено, используем "Без названия"
        if (empty($projectInfo['project_name'])) {
            $projectInfo['project_name'] = 'Без названия';
        }
        
        // Если темп не найден, устанавливаем значение по умолчанию
        if ($projectInfo['tempo'] == 0) {
            $projectInfo['tempo'] = 120; // BPM по умолчанию
        }
    }

    /**
     * Безопасное чтение 1 байта, возвращает int [0..255] или null при EOF/ошибке
     */
    private function readByte($fileHandle) {
        $b = fread($fileHandle, 1);
        if ($b === false || $b === '') { return null; }
        return ord($b);
    }
    
    private function readInt16($fileHandle) {
        $data = fread($fileHandle, 2);
        if (strlen($data) < 2) return 0;
        return unpack('v', $data)[1]; // Little-endian 16-bit
    }
    
    private function readInt32($fileHandle) {
        $data = fread($fileHandle, 4);
        if (strlen($data) < 4) return 0;
        return unpack('V', $data)[1]; // Little-endian 32-bit
    }
    
    /**
     * Декодирует версию FL Studio из 32-битного значения в формате major.minor.patch.
     * Точное кодирование у разных версий может отличаться, поэтому используется эвристика.
     */
    private function decodeFlVersion(int $dword): string {
        // Разбиваем на байты (LE)
        $b0 = $dword & 0xFF;           // младший
        $b1 = ($dword >> 8) & 0xFF;
        $b2 = ($dword >> 16) & 0xFF;
        $b3 = ($dword >> 24) & 0xFF;   // старший
        
        // Наиболее часто встречающийся вариант в FLP:
        // major = b1, minor = b0, patch = b2
        $maj = $b1; $min = $b0; $pat = $b2;
        if ($maj >= 1 && $maj <= 60 && $min <= 50 && $pat <= 50) {
            // Если minor и patch нули — вернём читабельное имя
            if ($min === 0 && $pat === 0) {
                return isset($this->flStudioVersions[$maj])
                    ? $this->flStudioVersions[$maj]
                    : ('FL Studio ' . $maj . '.x');
            }
            return 'FL Studio ' . $maj . '.' . $min . ($pat > 0 ? ('.' . $pat) : '');
        }

        // Альтернативная схема, встречающаяся в некоторых FLP:
        // major = b1 - 32, minor = floor(b0/64), patch = b2 + 1
        // Пример: b1=56,b0=128,b2=1 -> 24.2.2
        $majAlt = $b1 - 32;
        $minAlt = intdiv($b0, 64);
        $patAlt = $b2 + 1;
        if ($majAlt >= 1 && $majAlt <= 40 && $minAlt >= 0 && $minAlt <= 20 && $patAlt >= 1 && $patAlt <= 30) {
            return 'FL Studio ' . $majAlt . '.' . $minAlt . '.' . $patAlt;
        }

        // Все разумные перестановки (major, minor, patch)
        $perms = [
            [$b1, $b0, $b2],
            [$b2, $b1, $b0],
            [$b3, $b2, $b1],
            [$b1, $b2, $b0],
            [$b0, $b1, $b2],
            [$b0, $b2, $b1],
        ];

        $best = null;
        $bestScore = -INF;

        foreach ($perms as [$maj, $min, $pat]) {
            // Базовые проверки
            if ($maj <= 0 || $maj > 127) continue;

            // Считаем очки по эвристике
            $score = 0;

            // 1) Major в нормальном диапазоне версий FL (1..30) — сильный плюс
            if ($maj >= 1 && $maj <= 30) $score += 100;

            // 2) Известные мажоры — ещё плюс
            if (isset($this->flStudioVersions[$maj])) $score += 30;

            // 3) Чем меньше minor/patch, тем правдоподобнее (обычно до 20)
            $score += max(0, 20 - min($min, 99));
            $score += max(0, 20 - min($pat, 99));

            // 4) Предпочтение раскладкам, где minor/patch < 16 (часто соответствуют сборкам)
            if ($min < 16) $score += 10;
            if ($pat < 16) $score += 5;

            if ($score > $bestScore) {
                $bestScore = $score;
                $best = [$maj, $min, $pat];
            }
        }

        if ($best) {
            [$maj, $min, $pat] = $best;
            // Если minor и patch равны 0 — вернём человекочитаемое имя по мажору
            if ($min === 0 && $pat === 0) {
                return isset($this->flStudioVersions[$maj])
                    ? $this->flStudioVersions[$maj]
                    : ('FL Studio ' . $maj . '.x');
            }
            return 'FL Studio ' . $maj . '.' . $min . ($pat > 0 ? ('.' . $pat) : '');
        }

        // Фолбэк: использовать логіку с byte1 как major
        $maj = $b1;
        if (isset($this->flStudioVersions[$maj])) {
            return $this->flStudioVersions[$maj];
        }
        if ($maj > 0) {
            return 'FL Studio ' . $maj . '.x';
        }
        return 'Неизвестно';
    }
    
    private function cleanString($data) {
        // Удаляем нулевые байты и лишние пробелы
        $cleaned = trim(str_replace("\0", "", $data));
        
        // Проверяем на UTF-8 и конвертируем если нужно
        if (!mb_check_encoding($cleaned, 'UTF-8')) {
            $cleaned = mb_convert_encoding($cleaned, 'UTF-8', 'Windows-1252');
        }
        
        return $cleaned;
    }
    
    // Эвристика: похоже ли имя на название плагина, а не на аудиоклип/канал/стем
    private function isLikelyPluginName(string $name): bool {
        $norm = $this->normalizeName($name);
        if ($norm === '') return false;

        // Явные известные названия — оставить
        foreach ($this->knownPluginNames as $known) {
            if ($this->normalizeName($known) === $norm) return true;
        }

        // Если присутствуют ключевые слова плагинов — оставить
        foreach ($this->knownPluginKeywords as $kw) {
            if (mb_strpos($norm, $kw) !== false) return true;
        }

        // Отсечения (медиа/клипы): если похоже — исключить
        $audioExt = ['.wav','.aif','.aiff','.mp3','.flac','.ogg','.m4a'];
        foreach ($audioExt as $ext) {
            if (str_ends_with($norm, $ext)) return false;
        }

        // Слова, характерные для названий стемов/трека
        $stemWords = ['vocals','drums','bass','guitar','piano','other','mix','instrumental','acapella','stem'];
        $mediaWords = ['official','lyrics','audio','vevo'];
        $hyphenCount = substr_count($norm, '-');
        $containsStemWord = false;
        foreach (array_merge($stemWords, $mediaWords) as $w) {
            if (mb_strpos($norm, $w) !== false) { $containsStemWord = true; break; }
        }
        // Если много дефисов и есть слова, характерные для стемов — исключаем
        if ($hyphenCount >= 1 && $containsStemWord && !preg_match('/vst|plugin|synth|fx/u', $norm)) {
            return false;
        }

        // Если строка очень длинная как у медиазаголовков и содержит много разделителей — исключаем
        if (mb_strlen($norm) > 80 && ($hyphenCount + substr_count($norm, ' ')) >= 5) return false;

        // По умолчанию — считаем, что это плагин (чтобы не пропускать неизвестные плагины)
        return true;
    }

    private function normalizeName(string $s): string {
        $s = trim(preg_replace('/\s+/u', ' ', $s));
        $s = mb_strtolower($s);
        return $s;
    }

    // Эвристика: похоже ли имя на аудиоклип/стем/медиа-элемент
    private function isLikelyAudioClipName(string $name): bool {
        $norm = $this->normalizeName($name);
        if ($norm === '') return false;

        // Явные аудио-расширения
        $audioExt = ['.wav','.aif','.aiff','.mp3','.flac','.ogg','.m4a','.aac','.wma'];
        foreach ($audioExt as $ext) {
            if (str_ends_with($norm, $ext)) return true;
        }

        // Слова, характерные для медиа- и стем-названий
        $stemWords = ['vocals','drums','bass','guitar','piano','other','mix','instrumental','acapella','stem'];
        $mediaWords = ['official','lyrics','audio','vevo','remaster','live','cover'];
        foreach (array_merge($stemWords, $mediaWords) as $w) {
            if (mb_strpos($norm, $w) !== false) return true;
        }

        // Много составных частей — чаще заголовок клипа/стема
        $sepCount = substr_count($norm, '-') + substr_count($norm, '_') + substr_count($norm, ' ');
        if (mb_strlen($norm) > 40 && $sepCount >= 5) return true;

        // Если встречаются признаки плагина — не считаем аудиоклипом
        if (preg_match('/vst|plugin|synth|fx|fruity|neural|archetype/u', $norm)) return false;

        return false;
    }

    public function formatFileSize($bytes) {
        $units = ['B', 'KB', 'MB', 'GB'];
        $bytes = max($bytes, 0);
        $pow = floor(($bytes ? log($bytes) : 0) / log(1024));
        $pow = min($pow, count($units) - 1);
        
        $bytes /= pow(1024, $pow);
        
        return round($bytes, 2) . ' ' . $units[$pow];
    }
}
?>

<?php
// Простой тест для проверки работы парсера
// Этот файл можно удалить после тестирования

require_once 'FlpParser.php';

echo "<h2>Тест FL Studio Project Analyzer</h2>";

// Тестируем создание экземпляра парсера
try {
    $parser = new FlpParser();
    echo "<p style='color: green;'>✅ Парсер успешно создан</p>";
    
    // Тестируем метод форматирования размера файла
    echo "<p><strong>Тест форматирования размера файла:</strong></p>";
    echo "<ul>";
    echo "<li>1024 байт = " . $parser->formatFileSize(1024) . "</li>";
    echo "<li>1048576 байт = " . $parser->formatFileSize(1048576) . "</li>";
    echo "<li>52428800 байт = " . $parser->formatFileSize(52428800) . "</li>";
    echo "</ul>";
    
    // Проверяем существование необходимых файлов
    $requiredFiles = ['index.php', 'upload.php', 'results.php', 'FlpParser.php'];
    echo "<p><strong>Проверка файлов:</strong></p>";
    echo "<ul>";
    foreach ($requiredFiles as $file) {
        if (file_exists($file)) {
            echo "<li style='color: green;'>✅ $file найден</li>";
        } else {
            echo "<li style='color: red;'>❌ $file не найден</li>";
        }
    }
    echo "</ul>";
    
    // Проверяем директорию uploads
    if (is_dir('uploads')) {
        echo "<p style='color: green;'>✅ Директория uploads создана</p>";
        if (is_writable('uploads')) {
            echo "<p style='color: green;'>✅ Директория uploads доступна для записи</p>";
        } else {
            echo "<p style='color: orange;'>⚠️ Директория uploads может быть недоступна для записи</p>";
        }
    } else {
        echo "<p style='color: red;'>❌ Директория uploads не найдена</p>";
    }
    
    // Проверяем настройки PHP
    echo "<p><strong>Настройки PHP:</strong></p>";
    echo "<ul>";
    echo "<li>Максимальный размер загружаемого файла: " . ini_get('upload_max_filesize') . "</li>";
    echo "<li>Максимальный размер POST: " . ini_get('post_max_size') . "</li>";
    echo "<li>Максимальное время выполнения: " . ini_get('max_execution_time') . " сек</li>";
    echo "<li>Лимит памяти: " . ini_get('memory_limit') . "</li>";
    echo "</ul>";
    
    echo "<hr>";
    echo "<p><strong>Сервис готов к использованию!</strong></p>";
    echo "<p><a href='index.php' style='background: linear-gradient(45deg, #667eea, #764ba2); color: white; padding: 10px 20px; text-decoration: none; border-radius: 25px;'>Перейти к главной странице</a></p>";
    
} catch (Exception $e) {
    echo "<p style='color: red;'>❌ Ошибка: " . $e->getMessage() . "</p>";
}
?>

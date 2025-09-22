<?php

/** @var string $dir Путь к директории для хранения изображений. */
$dir = 'image/';

if (!is_dir($dir)) {
    /**
     * Проверяет, существует ли директория по пути $dir.
     * Если директория отсутствует, создаёт её рекурсивно с правами 0755.
     *
     * @param string  $dir       Путь к создаваемой директории.
     * @param int     $mode      Права доступа к создаваемой директории (octal).
     * @param bool    $recursive Флаг рекурсивного создания вложенных директорий.
     * @return bool  Возвращает true при успешном создании, false при ошибке.
     */
    mkdir($dir, 0755, true);
}

/**
 * Сканирует указанную директорию и получает список файлов и папок.
 *
 * @param string $dir Путь к директории для сканирования.
 * @return array|false Массив имён файлов и папок либо false в случае ошибки.
 */
$files = scandir($dir);

/** @var string[] $imageFiles Массив для хранения имён файлов изображений. */
$imageFiles = [];

if ($files !== false) {
    /**
     * Перебирает все элементы, возвращённые функцией scandir.
     * Фильтрует только файлы с расширениями изображений.
     *
     * @param string $file Имя файла или папки в директории.
     */
    foreach ($files as $file) {
        if ($file != "." && $file != "..") {
            /** @var string $extension Расширение файла в нижнем регистре. */
            $extension = strtolower(pathinfo($file, PATHINFO_EXTENSION));
            if (in_array($extension, ['jpg', 'jpeg', 'png', 'gif', 'webp'])) {
                $imageFiles[] = $file;
            }
        }
    }
}
?>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>#dogs - Галерея гавгавычей</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <header>
            <nav>
                <ul>
                    <li><a href="#home">About Dogs</a></li>
                    <li><a href="#news">News</a></li>
                    <li><a href="#contacts">Contacts</a></li>
                </ul>
            </nav>
        </header>

        <main>
            <h1 class="page-title">#dogs</h1>
            <p class="page-subtitle">Explore a world of dogs</p>
            <div class="gallery">
                <?php
                if (!empty($imageFiles)) {
                    /**
                     * Выводит блоки галереи для каждого найденного изображения.
                     *
                     * @param int    $index Индекс текущего изображения (начиная с 0).
                     * @param string $file  Имя файла изображения.
                     */
                    foreach ($imageFiles as $index => $file) {
                        $path = $dir . $file;
                        $fileName = pathinfo($file, PATHINFO_FILENAME);
                        ?>
                        <div class="gallery-item">
                            <img src="<?php echo htmlspecialchars($path); ?>"
                                 alt="<?php echo htmlspecialchars($fileName); ?>"
                                 loading="lazy">
                            <div class="image-overlay">
                                <h3><?php echo htmlspecialchars($fileName); ?></h3>
                                <p>Прекрасный гав №<?php echo $index + 1; ?></p>
                            </div>
                        </div>
                        <?php
                    }
                } else {
                    ?>
                    <div class="no-images">
                        <h2>📸 Галерея пуста</h2>
                        <p>Добавьте изображения в папку "image/" чтобы увидеть галерею гав!</p>
                        <p><small>Поддерживаемые форматы: JPG, JPEG, PNG, GIF, WebP</small></p>
                    </div>
                    <?php
                }
                ?>
            </div>
        </main>

        <footer>
            <p class="footer-text">
                USM.FMI © <?php echo date('Y'); ?> |
                Найдено изображений: <?php echo count($imageFiles); ?> |
                Галерея гавгавычей
            </p>
        </footer>
    </div>

</body>
</html>

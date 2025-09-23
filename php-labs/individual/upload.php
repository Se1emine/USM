<?php
session_start();

// Проверяем, был ли отправлен файл
if (!isset($_FILES['flp_file']) || $_FILES['flp_file']['error'] !== UPLOAD_ERR_OK) {
    $_SESSION['error'] = 'Ошибка при загрузке файла. Пожалуйста, попробуйте снова.';
    header('Location: index.php');
    exit;
}

$uploadedFile = $_FILES['flp_file'];

// Проверяем размер файла (максимум 50MB)
$maxFileSize = 50 * 1024 * 1024; // 50MB в байтах
if ($uploadedFile['size'] > $maxFileSize) {
    $_SESSION['error'] = 'Файл слишком большой. Максимальный размер: 50MB.';
    header('Location: index.php');
    exit;
}

// Проверяем расширение файла
$fileExtension = strtolower(pathinfo($uploadedFile['name'], PATHINFO_EXTENSION));
if ($fileExtension !== 'flp') {
    $_SESSION['error'] = 'Неверный тип файла. Поддерживаются только .flp файлы.';
    header('Location: index.php');
    exit;
}

// Создаем директорию для временных файлов, если она не существует
$uploadDir = 'uploads/';
if (!file_exists($uploadDir)) {
    mkdir($uploadDir, 0777, true);
}

// Генерируем уникальное имя файла
$fileName = uniqid() . '_' . basename($uploadedFile['name']);
$filePath = $uploadDir . $fileName;

// Перемещаем загруженный файл
if (!move_uploaded_file($uploadedFile['tmp_name'], $filePath)) {
    $_SESSION['error'] = 'Не удалось сохранить файл. Попробуйте снова.';
    header('Location: index.php');
    exit;
}

// Подключаем парсер FLP файлов
require_once 'FlpParser.php';

try {
    $parser = new FlpParser();
    $projectInfo = $parser->parseFlpFile($filePath);
    
    // Удаляем временный файл
    unlink($filePath);
    
    // Сохраняем результаты в сессии для отображения
    $_SESSION['project_info'] = $projectInfo;
    $_SESSION['original_filename'] = $uploadedFile['name'];
    
    header('Location: results.php');
    exit;
    
} catch (Exception $e) {
    // Удаляем временный файл в случае ошибки
    if (file_exists($filePath)) {
        unlink($filePath);
    }
    
    $_SESSION['error'] = 'Ошибка при анализе файла: ' . $e->getMessage();
    header('Location: index.php');
    exit;
}
?>

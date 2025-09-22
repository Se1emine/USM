<?php
session_start();
require_once __DIR__ . '/../../helpers.php';

$id = $_GET['id'] ?? '';
if (!$id) {
    http_response_code(400);
    echo 'Missing id';
    exit;
}

$ok = deleteRecipe($id);
if ($ok) {
    header('Location: index.php?route=index');
} else {
    $_SESSION['errors'] = ['Не удалось удалить рецепт'];
    header('Location: index.php?route=recipe/show&id=' . urlencode($id));
}
exit;

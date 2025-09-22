<?php
session_start();
require_once __DIR__ . '/../../helpers.php';

$id = isset($_GET['id']) ? (int)$_GET['id'] : 0;
if ($id <= 0) {
    http_response_code(400);
    echo 'Missing id';
    exit;
}

if (($_SERVER['REQUEST_METHOD'] ?? 'GET') === 'POST' && isset($_POST['submit'])) {
    $title = filterInput($_POST['title'] ?? '');
    $category = (int)($_POST['category'] ?? 0);
    $ingredients = filterInput($_POST['ingredients'] ?? '');
    $description = filterInput($_POST['description'] ?? '');
    $tags = array_values(array_filter(array_map('trim', (array)($_POST['tags'] ?? [])), fn($t) => $t !== ''));
    $steps = array_values(array_filter(array_map('trim', (array)($_POST['steps'] ?? [])), fn($s) => $s !== ''));

    $errors = validateRecipeData($title, (string)$category, $ingredients, $description, $steps);

    // Доп. валидация существования рецепта и категории
    if (!getRecipeById($id)) {
        $errors[] = 'Рецепт не найден';
    }
    try {
        $pdo = db();
        $stmt = $pdo->prepare('SELECT COUNT(*) FROM categories WHERE id = :id');
        $stmt->execute([':id' => $category]);
        if ((int)$stmt->fetchColumn() === 0) {
            $errors[] = 'Выбранная категория не существует';
        }
    } catch (Throwable $e) {
        $errors[] = 'Ошибка проверки категории';
    }

    if (empty($errors)) {
        $ok = updateRecipe($id, [
            'title' => $title,
            'category' => $category,
            'ingredients' => $ingredients,
            'description' => $description,
            'tags' => $tags,
            'steps' => $steps,
        ]);
        if ($ok) {
            header('Location: index.php?route=recipe/show&id=' . urlencode($id));
            exit;
        }
        $errors[] = 'Не удалось обновить рецепт';
    }

    $_SESSION['errors'] = $errors;
    header('Location: index.php?route=recipe/edit&id=' . urlencode($id));
    exit;
}
http_response_code(405);

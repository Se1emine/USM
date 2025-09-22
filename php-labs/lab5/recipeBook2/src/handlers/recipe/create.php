<?php
session_start();
require_once __DIR__ . '/../../helpers.php';

if (($_SERVER['REQUEST_METHOD'] ?? 'GET') === 'POST' && isset($_POST['submit'])) {
    $title = filterInput($_POST['title'] ?? '');
    $category = (int)($_POST['category'] ?? 0);
    $ingredients = filterInput($_POST['ingredients'] ?? '');
    $description = filterInput($_POST['description'] ?? '');
    $tags = array_values(array_filter(array_map('trim', (array)($_POST['tags'] ?? [])), fn($t) => $t !== ''));
    $steps = array_values(array_filter(array_map('trim', (array)($_POST['steps'] ?? [])), fn($s) => $s !== ''));

    // Базовая валидция полей
    $errors = validateRecipeData($title, (string)$category, $ingredients, $description, $steps);

    // Доп. валидация категории: должна существовать в БД
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
        $recipeData = [
            'title' => $title,
            'category' => $category,
            'ingredients' => $ingredients,
            'description' => $description,
            'tags' => $tags,
            'steps' => $steps,
            'created_at' => date('Y-m-d H:i:s')
        ];
        if (saveRecipe($recipeData)) {
            header('Location: index.php?route=index');
            exit;
        }
        $errors[] = 'Ошибка при сохранении рецепта';
    }

    $_SESSION['errors'] = $errors;
    header('Location: index.php?route=recipe/create');
    exit;
}
http_response_code(405);

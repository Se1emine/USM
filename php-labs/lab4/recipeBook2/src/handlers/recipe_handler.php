<?php
session_start();
require_once '../helpers.php';

/**
 * Обработка POST-запроса с данными формы добавления рецепта
 *
 * Выполняет фильтрацию, валидацию, сохранение рецепта и редирект.
 * В случае ошибок сохраняет сообщения об ошибках в сессии и возвращает пользователя на форму.
 */
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['submit'])) {
    // Получение и фильтрация данных из формы
    $title = filterInput($_POST['title'] ?? '');
    $category = filterInput($_POST['category'] ?? '');
    $ingredients = filterInput($_POST['ingredients'] ?? '');
    $description = filterInput($_POST['description'] ?? '');
    $tags = $_POST['tags'] ?? [];
    $steps = array_filter($_POST['steps'] ?? [], 'trim');

    // Валидация данных рецепта
    $errors = validateRecipeData($title, $category, $ingredients, $description, $steps);

    if (empty($errors)) {
        // Формирование массива данных рецепта для сохранения
        $recipeData = [
            'id' => uniqid(),
            'title' => $title,
            'category' => $category,
            'ingredients' => $ingredients,
            'description' => $description,
            'tags' => $tags,
            'steps' => array_values($steps),
            'created_at' => date('Y-m-d H:i:s')
        ];

        // Сохранение рецепта в файл
        if (saveRecipe($recipeData)) {
            // Перенаправление на главную страницу после успешного сохранения
            header('Location: ../../public/index.php');
            exit;
        } else {
            $errors[] = 'Ошибка при сохранении рецепта';
        }
    }

    // Сохранение ошибок в сессии для отображения на форме
    $_SESSION['errors'] = $errors;
    header('Location: ../../public/recipe/create.php');
    exit;
}
?>

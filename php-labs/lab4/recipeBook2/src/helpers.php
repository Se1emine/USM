<?php

/**
 * Фильтрация входных данных для предотвращения XSS и удаления лишних пробелов
 *
 * @param string $input Входная строка для фильтрации
 * @return string Отфильтрованная и безопасная для вывода строка
 */
function filterInput($input) {
    return trim(htmlspecialchars($input, ENT_QUOTES, 'UTF-8'));
}

/**
 * Валидация данных рецепта
 *
 * Проверяет обязательные поля и минимальные требования к ним.
 *
 * @param string $title Название рецепта
 * @param string $category Категория рецепта
 * @param string $ingredients Ингредиенты рецепта
 * @param string $description Описание рецепта
 * @param array $steps Массив шагов приготовления
 * @return array Массив сообщений об ошибках. Пустой, если ошибок нет.
 */
function validateRecipeData($title, $category, $ingredients, $description, $steps) {
    $errors = [];

    if (empty($title)) {
        $errors[] = 'Название рецепта обязательно для заполнения';
    } elseif (strlen($title) < 3) {
        $errors[] = 'Название рецепта должно содержать минимум 3 символа';
    }

    if (empty($category)) {
        $errors[] = 'Выберите категорию рецепта';
    }

    if (empty($ingredients)) {
        $errors[] = 'Укажите ингредиенты';
    }

    if (empty($description)) {
        $errors[] = 'Добавьте описание рецепта';
    }

    if (empty($steps) || count($steps) < 1) {
        $errors[] = 'Добавьте хотя бы один шаг приготовления';
    }

    return $errors;
}

/**
 * Сохраняет данные рецепта в файл в формате JSON, добавляя новую строку
 *
 * @param array $recipeData Ассоциативный массив с данными рецепта
 * @return bool Возвращает true при успешном сохранении, false при ошибке
 */
function saveRecipe($recipeData) {
    $filename = __DIR__ . '/../storage/recipes.txt';
    
    // Создание директории, если она не существует
    if (!file_exists(dirname($filename))) {
        mkdir(dirname($filename), 0755, true);
    }

    // Записываем JSON-строку с блокировкой файла для предотвращения конфликтов
    return file_put_contents($filename, json_encode($recipeData, JSON_UNESCAPED_UNICODE) . PHP_EOL, FILE_APPEND | LOCK_EX) !== false;
}

/**
 * Получает все рецепты из файла storage/recipes.txt
 *
 * @return array Массив рецептов, каждый элемент — ассоциативный массив с данными рецепта
 */
function getAllRecipes() {
    $filename = __DIR__ . '/../storage/recipes.txt';
    
    if (!file_exists($filename)) {
        return [];
    }

    $recipes = file($filename, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
    $decoded = array_map(function($recipe) {
        return json_decode($recipe, true);
    }, $recipes);
    // Возвращаем в обратном порядке: сначала новые рецепты
    return array_reverse($decoded);
}

/**
 * Получает последние N рецептов из файла
 *
 * @param int $count Количество последних рецептов для получения (по умолчанию 2)
 * @return array Массив последних рецептов
 */
function getLatestRecipes($count = 2) {
    $recipes = getAllRecipes();
    // Так как getAllRecipes уже отдаёт новые первыми, берём первые N
    return array_slice($recipes, 0, $count);
}

/**
 * Получает рецепты с пагинацией
 *
 * @param int $page Номер текущей страницы (начинается с 1)
 * @param int $perPage Количество рецептов на страницу (по умолчанию 5)
 * @return array Ассоциативный массив с ключами:
 *               - 'recipes' => массив рецептов для текущей страницы,
 *               - 'totalPages' => общее количество страниц,
 *               - 'currentPage' => текущая страница,
 *               - 'total' => общее количество рецептов
 */
function getPaginatedRecipes($page = 1, $perPage = 5) {
    $recipes = getAllRecipes();
    $total = count($recipes);
    $totalPages = ceil($total / $perPage);
    $offset = ($page - 1) * $perPage;
    
    return [
        'recipes' => array_slice($recipes, $offset, $perPage),
        'totalPages' => $totalPages,
        'currentPage' => $page,
        'total' => $total
    ];
}
?>

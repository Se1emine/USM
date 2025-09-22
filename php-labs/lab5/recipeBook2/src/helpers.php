<?php
require_once __DIR__ . '/db.php';

/**
 * Фильтрация пользовательского ввода (обрезка и экранирование для безопасного вывода).
 *
 * ВАЖНО: функция предназначена для подготовки строк к выводу в HTML, а не для SQL.
 * Для SQL используются подготовленные выражения (PDO prepared statements).
 *
 * @param string $input Входная строка для фильтрации.
 * @return string Отфильтрованная и безопасная для вывода строка.
 */
function filterInput($input) {
    return trim(htmlspecialchars($input, ENT_QUOTES, 'UTF-8'));
}

/**
 * Валидация данных рецепта (базовая проверка полей формы).
 *
 * @param string $title Название рецепта.
 * @param string $category Идентификатор категории (строкой, приводится к int в обработчиках).
 * @param string $ingredients Ингредиенты.
 * @param string $description Описание рецепта.
 * @param array<int,string> $steps Массив шагов приготовления.
 * @return array<int,string> Массив сообщений об ошибках. Пустой, если ошибок нет.
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
 * Сохраняет рецепт в БД.
 *
 * @param array{
 *   title:string,
 *   category:int,
 *   ingredients:?string,
 *   description:?string,
 *   tags:array<int,string>,
 *   steps:array<int,string>,
 *   created_at?:string
 * } $recipeData Данные рецепта.
 * @return bool Успех выполнения операции.
 */
function saveRecipe($recipeData) {
    $pdo = db();
    $stmt = $pdo->prepare('INSERT INTO recipes (title, category, ingredients, description, tags, steps, created_at)
                           VALUES (:title, :category, :ingredients, :description, :tags, :steps, :created_at)');
    $tags = json_encode($recipeData['tags'] ?? [], JSON_UNESCAPED_UNICODE);
    $steps = json_encode($recipeData['steps'] ?? [], JSON_UNESCAPED_UNICODE);
    return $stmt->execute([
        ':title' => $recipeData['title'],
        ':category' => (int)$recipeData['category'],
        ':ingredients' => $recipeData['ingredients'] ?? null,
        ':description' => $recipeData['description'] ?? null,
        ':tags' => $tags,
        ':steps' => $steps,
        ':created_at' => $recipeData['created_at'] ?? date('Y-m-d H:i:s'),
    ]);
}

/**
 * Возвращает все рецепты (без пагинации).
 *
 * @return array<int,array<string,mixed>> Список рецептов.
 */
function getAllRecipes() {
    $pdo = db();
    $sql = 'SELECT r.*, c.name AS category_name FROM recipes r
            LEFT JOIN categories c ON c.id = r.category
            ORDER BY r.created_at DESC, r.id DESC';
    $rows = $pdo->query($sql)->fetchAll();
    foreach ($rows as &$r) {
        $r['tags'] = $r['tags'] ? (json_decode($r['tags'], true) ?: []) : [];
        $r['steps'] = $r['steps'] ? (json_decode($r['steps'], true) ?: []) : [];
    }
    return $rows;
}

/**
 * Получает последние N рецептов.
 *
 * @param int $count Количество последних рецептов для получения (по умолчанию 2).
 * @return array<int,array<string,mixed>> Массив последних рецептов.
 */
function getLatestRecipes($count = 2) {
    $pdo = db();
    $stmt = $pdo->prepare('SELECT r.*, c.name AS category_name FROM recipes r LEFT JOIN categories c ON c.id = r.category ORDER BY r.created_at DESC, r.id DESC LIMIT :lim');
    $stmt->bindValue(':lim', (int)$count, PDO::PARAM_INT);
    $stmt->execute();
    $rows = $stmt->fetchAll();
    foreach ($rows as &$r) {
        $r['tags'] = $r['tags'] ? (json_decode($r['tags'], true) ?: []) : [];
        $r['steps'] = $r['steps'] ? (json_decode($r['steps'], true) ?: []) : [];
    }
    return $rows;
}

/**
 * Получает рецепты с пагинацией.
 *
 * @param int $page Номер текущей страницы (>=1).
 * @param int $perPage Количество рецептов на страницу (по умолчанию 5).
 * @return array{
 *   recipes:array<int,array<string,mixed>>,
 *   totalPages:int,
 *   currentPage:int,
 *   total:int
 * }
 */
function getPaginatedRecipes($page = 1, $perPage = 5) {
    $pdo = db();
    $page = max(1, (int)$page);
    $perPage = max(1, (int)$perPage);
    $offset = ($page - 1) * $perPage;
    $total = (int)$pdo->query('SELECT COUNT(*) FROM recipes')->fetchColumn();
    $stmt = $pdo->prepare('SELECT r.*, c.name AS category_name FROM recipes r LEFT JOIN categories c ON c.id = r.category ORDER BY r.created_at DESC, r.id DESC LIMIT :lim OFFSET :off');
    $stmt->bindValue(':lim', $perPage, PDO::PARAM_INT);
    $stmt->bindValue(':off', $offset, PDO::PARAM_INT);
    $stmt->execute();
    $rows = $stmt->fetchAll();
    foreach ($rows as &$r) {
        $r['tags'] = $r['tags'] ? (json_decode($r['tags'], true) ?: []) : [];
        $r['steps'] = $r['steps'] ? (json_decode($r['steps'], true) ?: []) : [];
    }
    $totalPages = (int)ceil($total / $perPage);
    return [
        'recipes' => $rows,
        'totalPages' => $totalPages,
        'currentPage' => $page,
        'total' => $total
    ];
}

/**
 * Генерирует уникальный ID рецепта (для файлового хранилища; при БД с AUTO_INCREMENT не используется).
 *
 * @return string Сгенерированный идентификатор.
 */
function generateRecipeId() {
    // Для БД (AUTO_INCREMENT) не используется, оставлено для совместимости
    return uniqid();
}

/**
 * Возвращает рецепт по ID.
 *
 * @param int|string $id Идентификатор рецепта.
 * @return array<string,mixed>|null Данные рецепта или null, если не найден.
 */
function getRecipeById($id) {
    $pdo = db();
    $stmt = $pdo->prepare('SELECT r.*, c.name AS category_name FROM recipes r LEFT JOIN categories c ON c.id = r.category WHERE r.id = :id');
    $stmt->execute([':id' => (int)$id]);
    $r = $stmt->fetch();
    if (!$r) { return null; }
    $r['tags'] = $r['tags'] ? (json_decode($r['tags'], true) ?: []) : [];
    $r['steps'] = $r['steps'] ? (json_decode($r['steps'], true) ?: []) : [];
    return $r;
}

/**
 * Обновляет рецепт по ID.
 *
 * @param int|string $id Идентификатор рецепта.
 * @param array{
 *   title:string,
 *   category:int,
 *   ingredients:?string,
 *   description:?string,
 *   tags:array<int,string>,
 *   steps:array<int,string>
 * } $newData Новые значения полей рецепта.
 * @return bool Успех выполнения операции.
 */
function updateRecipe($id, $newData) {
    $pdo = db();
    $stmt = $pdo->prepare('UPDATE recipes SET title = :title, category = :category, ingredients = :ingredients, description = :description, tags = :tags, steps = :steps WHERE id = :id');
    $tags = json_encode($newData['tags'] ?? [], JSON_UNESCAPED_UNICODE);
    $steps = json_encode($newData['steps'] ?? [], JSON_UNESCAPED_UNICODE);
    return $stmt->execute([
        ':title' => $newData['title'],
        ':category' => (int)$newData['category'],
        ':ingredients' => $newData['ingredients'] ?? null,
        ':description' => $newData['description'] ?? null,
        ':tags' => $tags,
        ':steps' => $steps,
        ':id' => (int)$id,
    ]);
}

/**
 * Удаляет рецепт по ID.
 *
 * @param int|string $id Идентификатор рецепта.
 * @return bool Успех выполнения операции.
 */
function deleteRecipe($id) {
    $pdo = db();
    $stmt = $pdo->prepare('DELETE FROM recipes WHERE id = :id');
    return $stmt->execute([':id' => (int)$id]);
}

/**
 * Возвращает список категорий (id, name) упорядоченный по имени.
 *
 * @return array<int,array{id:int,name:string}> Список категорий.
 */
function getCategories(): array {
    $pdo = db();
    $rows = $pdo->query('SELECT id, name FROM categories ORDER BY name')->fetchAll();
    return $rows ?: [];
}
?>

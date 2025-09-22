<?php
// Точка входа приложения с простой маршрутизацией
session_start();

require_once __DIR__ . '/../src/helpers.php';

/**
 * Рендерит шаблон и оборачивает его в базовый макет.
 *
 * @param string $template Имя шаблона относительно каталога templates (без .php), например 'index' или 'recipe/create'.
 * @param array $params Ассоциативный массив параметров, доступных в шаблоне как переменные.
 * @return void
 */
function render($template, $params = []) {
    extract($params);
    $templateFile = __DIR__ . '/../templates/' . $template . '.php';
    $layoutFile = __DIR__ . '/../templates/layout.php';
    ob_start();
    require $templateFile;
    $content = ob_get_clean();
    require $layoutFile;
}

// Определяем маршрут
$route = isset($_GET['route']) ? trim($_GET['route']) : 'index';
$method = $_SERVER['REQUEST_METHOD'] ?? 'GET';

// Маршруты
switch ($route) {
    case 'index':
        // Главная страница: список рецептов (последние N)
        $page = isset($_GET['page']) ? max(1, intval($_GET['page'])) : 1;
        $recipesData = getPaginatedRecipes($page, 5);
        render('index', ['recipesData' => $recipesData]);
        break;

    case 'recipe/create':
        if ($method === 'POST') {
            require __DIR__ . '/../src/handlers/recipe/create.php';
            exit;
        }
        // GET: отрисовываем форму
        $categories = getCategories();
        render('recipe/create', ['categories' => $categories]);
        break;

    case 'recipe/show':
        $id = $_GET['id'] ?? '';
        $recipe = $id ? getRecipeById($id) : null;
        render('recipe/show', ['recipe' => $recipe]);
        break;

    case 'recipe/edit':
        if ($method === 'POST') {
            require __DIR__ . '/../src/handlers/recipe/edit.php';
            exit;
        }
        $id = $_GET['id'] ?? '';
        $recipe = $id ? getRecipeById($id) : null;
        $categories = getCategories();
        render('recipe/edit', ['recipe' => $recipe, 'categories' => $categories]);
        break;

    case 'recipe/delete':
        require __DIR__ . '/../src/handlers/recipe/delete.php';
        exit;

    default:
        http_response_code(404);
        render('index', ['recipesData' => ['recipes' => [], 'totalPages' => 0, 'currentPage' => 1, 'total' => 0]]);
}
?>

<?php
/**
 * Страница списка всех рецептов с поддержкой пагинации.
 *
 * Этот файл отвечает за отображение всех рецептов, разделённых на страницы.
 * Использует функцию getPaginatedRecipes для получения данных рецептов.
 *
 * @package RecipeCatalog
 */
require_once '../../src/helpers.php';

/**
 * Текущий номер страницы из GET-параметра 'page'.
 * Если параметр отсутствует или некорректен, используется 1.
 *
 * @var int $page Номер текущей страницы (>=1).
 */
$page = isset($_GET['page']) ? max(1, intval($_GET['page'])) : 1;

/**
 * Данные рецептов с пагинацией: список рецептов и метаданные.
 * Получаем 5 рецептов на страницу.
 *
 * @var array $recipesData Массив с ключами:
 *      - recipes (array): Массив рецептов, где каждый рецепт содержит:
 *          - title (string): Название рецепта.
 *          - category (string): Категория рецепта.
 *          - ingredients (string): Строка с ингредиентами (с разделителями).
 *          - description (string): Описание рецепта.
 *          - steps (array): Массив шагов приготовления.
 *          - tags (array): Массив тегов.
 *          - created_at (string): Дата создания в формате 'Y-m-d H:i:s'.
 *      - currentPage (int): Текущая страница.
 *      - totalPages (int): Общее количество страниц.
 *      - total (int): Общее число рецептов.
 */
$recipesData = getPaginatedRecipes($page, 5);
?>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Все рецепты</title>
    <link rel="stylesheet" href="../assets/styles.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>Все рецепты</h1>
            <nav>
                <a href="../index.php">Главная</a>
                <a href="create.php">Добавить рецепт</a>
            </nav>
        </header>

        <main>
            <?php if (empty($recipesData['recipes'])): ?>
                <p>Рецепты не найдены. <a href="create.php">Добавить первый рецепт</a></p>
            <?php else: ?>
                <div class="recipes-list">
                    <?php foreach ($recipesData['recipes'] as $recipe): ?>
                        <article class="recipe-item">
                            <h2><?php echo htmlspecialchars($recipe['title'], ENT_QUOTES, 'UTF-8'); ?></h2>
                            <p class="category">Категория: <?php echo htmlspecialchars($recipe['category'], ENT_QUOTES, 'UTF-8'); ?></p>
                            
                            <div class="ingredients">
                                <h4>Ингредиенты:</h4>
                                <p><?php echo nl2br(htmlspecialchars($recipe['ingredients'], ENT_QUOTES, 'UTF-8')); ?></p>
                            </div>
                            
                            <div class="description">
                                <h4>Описание:</h4>
                                <p><?php echo nl2br(htmlspecialchars($recipe['description'], ENT_QUOTES, 'UTF-8')); ?></p>
                            </div>
                            
                            <div class="steps">
                                <h4>Шаги приготовления:</h4>
                                <ol>
                                    <?php foreach ($recipe['steps'] as $step): ?>
                                        <li><?php echo htmlspecialchars($step, ENT_QUOTES, 'UTF-8'); ?></li>
                                    <?php endforeach; ?>
                                </ol>
                            </div>
                            
                            <div class="tags">
                                <?php foreach ($recipe['tags'] as $tag): ?>
                                    <span class="tag"><?php echo htmlspecialchars($tag, ENT_QUOTES, 'UTF-8'); ?></span>
                                <?php endforeach; ?>
                            </div>
                            
                            <time datetime="<?php echo date('c', strtotime($recipe['created_at'])); ?>"><?php echo date('d.m.Y H:i', strtotime($recipe['created_at'])); ?></time>
                        </article>
                    <?php endforeach; ?>
                </div>

                <!-- Пагинация -->
                <?php if ($recipesData['totalPages'] > 1): ?>
                    <div class="pagination">
                        <div class="page-info">
                            Страница <?php echo $recipesData['currentPage']; ?> из <?php echo $recipesData['totalPages']; ?>
                            (<?php echo $recipesData['total']; ?> рецептов)
                        </div>
                        
                        <div class="page-links">
                            <?php if ($recipesData['currentPage'] > 1): ?>
                                <a href="?page=1">Первая</a>
                                <a href="?page=<?php echo $recipesData['currentPage'] - 1; ?>">Предыдущая</a>
                            <?php endif; ?>

                            <?php for ($i = max(1, $recipesData['currentPage'] - 2); $i <= min($recipesData['totalPages'], $recipesData['currentPage'] + 2); $i++): ?>
                                <?php if ($i == $recipesData['currentPage']): ?>
                                    <span class="current-page"><?php echo $i; ?></span>
                                <?php else: ?>
                                    <a href="?page=<?php echo $i; ?>"><?php echo $i; ?></a>
                                <?php endif; ?>
                            <?php endfor; ?>

                            <?php if ($recipesData['currentPage'] < $recipesData['totalPages']): ?>
                                <a href="?page=<?php echo $recipesData['currentPage'] + 1; ?>">Следующая</a>
                                <a href="?page=<?php echo $recipesData['totalPages']; ?>">Последняя</a>
                            <?php endif; ?>
                        </div>
                    </div>
                <?php endif; ?>
            <?php endif; ?>
        </main>
    </div>
</body>
</html>

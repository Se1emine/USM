<?php
/**
 * Главная страница каталога рецептов.
 *
 * Этот файл выводит последние рецепты на главной странице каталога.
 * Использует функцию getLatestRecipes для получения данных из базы.
 *
 * @package RecipeCatalog
 */
require_once '../src/helpers.php';

/**
 * Получение последних рецептов для отображения на главной странице.
 *
 * @param int $limit Количество рецептов для получения.
 * @return array Массив рецептов, где каждый рецепт содержит:
 *               - title (string): Заголовок рецепта.
 *               - category (string): Категория рецепта.
 *               - description (string): Описание рецепта.
 *               - tags (array): Массив тегов рецепта.
 *               - created_at (string): Дата создания в формате 'Y-m-d H:i:s'.
 */
$latestRecipes = getLatestRecipes(2);
?>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Каталог рецептов</title>
    <link rel="stylesheet" href="assets/styles.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>Каталог рецептов</h1>
            <nav>
                <a href="recipe/create.php">Добавить рецепт</a>
                <a href="recipe/index.php">Все рецепты</a>
            </nav>
        </header>

        <main>
            <section class="latest-recipes">
                <h2>Последние рецепты</h2>
                <?php if (empty($latestRecipes)): ?>
                    <p>Рецепты пока не добавлены. <a href="recipe/create.php">Добавить первый рецепт</a></p>
                <?php else: ?>
                    <div class="recipes-grid">
                        <?php foreach ($latestRecipes as $recipe): ?>
                            <article class="recipe-card">
                                <h3><?php echo htmlspecialchars($recipe['title'], ENT_QUOTES, 'UTF-8'); ?></h3>
                                <p class="category">Категория: <?php echo htmlspecialchars($recipe['category'], ENT_QUOTES, 'UTF-8'); ?></p>
                                <p class="description"><?php echo htmlspecialchars(mb_substr($recipe['description'], 0, 150), ENT_QUOTES, 'UTF-8') . '...'; ?></p>
                                <div class="tags">
                                    <?php foreach ($recipe['tags'] as $tag): ?>
                                        <span class="tag"><?php echo htmlspecialchars($tag, ENT_QUOTES, 'UTF-8'); ?></span>
                                    <?php endforeach; ?>
                                </div>
                                <time datetime="<?php echo date('c', strtotime($recipe['created_at'])); ?>"><?php echo date('d.m.Y', strtotime($recipe['created_at'])); ?></time>
                            </article>
                        <?php endforeach; ?>
                    </div>
                <?php endif; ?>
            </section>
        </main>
    </div>
</body>
</html>

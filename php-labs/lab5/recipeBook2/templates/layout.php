<?php
// Базовый шаблон макета
?>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Книга рецептов</title>
    <link rel="stylesheet" href="assets/styles.css">
</head>
<body>
    <div class="container">
        <header>
            <h1><a href="index.php?route=index">Книга рецептов</a></h1>
            <nav>
                <a href="index.php?route=index">Все рецепты</a>
                <a href="index.php?route=recipe/create">Добавить рецепт</a>
            </nav>
        </header>
        <main>
            <?php echo $content ?? ''; ?>
        </main>
    </div>
</body>
</html>

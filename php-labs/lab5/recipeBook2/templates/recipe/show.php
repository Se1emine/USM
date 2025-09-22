<?php /** @var array|null $recipe */ ?>
<?php if (!$recipe): ?>
    <p>Рецепт не найден.</p>
<?php else: ?>
    <article class="recipe-full">
        <h2><?php echo htmlspecialchars($recipe['title'], ENT_QUOTES, 'UTF-8'); ?></h2>
        <p class="category">Категория: <?php echo htmlspecialchars($recipe['category_name'] ?? ($recipe['category'] ?? ''), ENT_QUOTES, 'UTF-8'); ?></p>
        <div class="ingredients">
            <h4>Ингредиенты</h4>
            <p><?php echo nl2br(htmlspecialchars($recipe['ingredients'], ENT_QUOTES, 'UTF-8')); ?></p>
        </div>
        <div class="description">
            <h4>Описание</h4>
            <p><?php echo nl2br(htmlspecialchars($recipe['description'], ENT_QUOTES, 'UTF-8')); ?></p>
        </div>
        <div class="steps">
            <h4>Шаги</h4>
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
        <p>
            <a href="index.php?route=recipe/edit&id=<?php echo urlencode($recipe['id']); ?>">Редактировать</a>
            <a class="danger" href="index.php?route=recipe/delete&id=<?php echo urlencode($recipe['id']); ?>" onclick="return confirm('Удалить рецепт?');">Удалить</a>
        </p>
    </article>
<?php endif; ?>

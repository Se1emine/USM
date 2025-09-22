<?php /** @var array $recipesData */ ?>
<section class="recipes-listing">
    <?php if (empty($recipesData['recipes'])): ?>
        <p>Рецепты не найдены. <a href="index.php?route=recipe/create">Добавить первый рецепт</a></p>
    <?php else: ?>
        <div class="recipes-list">
            <?php foreach ($recipesData['recipes'] as $recipe): ?>
                <article class="recipe-item">
                    <h2>
                        <a href="index.php?route=recipe/show&id=<?php echo urlencode($recipe['id']); ?>">
                            <?php echo htmlspecialchars($recipe['title'], ENT_QUOTES, 'UTF-8'); ?>
                        </a>
                    </h2>
                    <p class="category">Категория: <?php echo htmlspecialchars($recipe['category_name'] ?? ($recipe['category'] ?? ''), ENT_QUOTES, 'UTF-8'); ?></p>
                    <p class="description"><?php echo nl2br(htmlspecialchars($recipe['description'], ENT_QUOTES, 'UTF-8')); ?></p>
                    <div class="tags">
                        <?php foreach ($recipe['tags'] as $tag): ?>
                            <span class="tag"><?php echo htmlspecialchars($tag, ENT_QUOTES, 'UTF-8'); ?></span>
                        <?php endforeach; ?>
                    </div>
                    <time datetime="<?php echo date('c', strtotime($recipe['created_at'])); ?>"><?php echo date('d.m.Y H:i', strtotime($recipe['created_at'])); ?></time>
                </article>
            <?php endforeach; ?>
        </div>

        <?php if (($recipesData['totalPages'] ?? 0) > 1): ?>
            <div class="pagination">
                <div class="page-info">
                    Страница <?php echo $recipesData['currentPage']; ?> из <?php echo $recipesData['totalPages']; ?>
                    (<?php echo $recipesData['total']; ?> рецептов)
                </div>
                <div class="page-links">
                    <?php if ($recipesData['currentPage'] > 1): ?>
                        <a href="index.php?route=index&page=1">Первая</a>
                        <a href="index.php?route=index&page=<?php echo $recipesData['currentPage'] - 1; ?>">Предыдущая</a>
                    <?php endif; ?>

                    <?php for ($i = max(1, $recipesData['currentPage'] - 2); $i <= min($recipesData['totalPages'], $recipesData['currentPage'] + 2); $i++): ?>
                        <?php if ($i == $recipesData['currentPage']): ?>
                            <span class="current-page"><?php echo $i; ?></span>
                        <?php else: ?>
                            <a href="index.php?route=index&page=<?php echo $i; ?>"><?php echo $i; ?></a>
                        <?php endif; ?>
                    <?php endfor; ?>

                    <?php if ($recipesData['currentPage'] < $recipesData['totalPages']): ?>
                        <a href="index.php?route=index&page=<?php echo $recipesData['currentPage'] + 1; ?>">Следующая</a>
                        <a href="index.php?route=index&page=<?php echo $recipesData['totalPages']; ?>">Последняя</a>
                    <?php endif; ?>
                </div>
            </div>
        <?php endif; ?>
    <?php endif; ?>
</section>

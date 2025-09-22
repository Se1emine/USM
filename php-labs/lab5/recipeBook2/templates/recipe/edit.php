<?php /** @var array|null $recipe */ ?>
<h1>Редактировать рецепт</h1>
<?php if (!$recipe): ?>
    <p>Рецепт не найден.</p>
<?php else: ?>
    <?php if (!empty($_SESSION['errors'])): ?>
        <div class="errors">
            <?php foreach ($_SESSION['errors'] as $error): ?>
                <p class="error"><?php echo htmlspecialchars($error, ENT_QUOTES, 'UTF-8'); ?></p>
            <?php endforeach; unset($_SESSION['errors']); ?>
        </div>
    <?php endif; ?>
    <form action="index.php?route=recipe/edit&id=<?php echo urlencode($recipe['id']); ?>" method="POST" class="recipe-form">
        <div class="form-group">
            <label for="title">Название рецепта:</label>
            <input type="text" id="title" name="title" required value="<?php echo htmlspecialchars($recipe['title'], ENT_QUOTES, 'UTF-8'); ?>">
        </div>
        <div class="form-group">
            <label for="category">Категория:</label>
            <select id="category" name="category" required>
                <?php foreach (($categories ?? []) as $cat): ?>
                    <option value="<?php echo (int)$cat['id']; ?>" <?php echo ((int)$recipe['category'] === (int)$cat['id'] ? 'selected' : ''); ?>>
                        <?php echo htmlspecialchars($cat['name'], ENT_QUOTES, 'UTF-8'); ?>
                    </option>
                <?php endforeach; ?>
            </select>
        </div>
        <div class="form-group">
            <label for="ingredients">Ингредиенты:</label>
            <textarea id="ingredients" name="ingredients" rows="5" required><?php echo htmlspecialchars($recipe['ingredients'], ENT_QUOTES, 'UTF-8'); ?></textarea>
        </div>
        <div class="form-group">
            <label for="description">Описание рецепта:</label>
            <textarea id="description" name="description" rows="4" required><?php echo htmlspecialchars($recipe['description'], ENT_QUOTES, 'UTF-8'); ?></textarea>
        </div>
        <div class="form-group">
            <label for="tags">Теги:</label>
            <?php $allTags = ['quick','healthy','vegetarian','budget']; ?>
            <select id="tags" name="tags[]" multiple>
                <?php foreach ($allTags as $t): ?>
                    <option value="<?php echo $t; ?>" <?php echo (in_array($t, $recipe['tags']) ? 'selected' : ''); ?>><?php echo $t; ?></option>
                <?php endforeach; ?>
            </select>
        </div>
        <div class="form-group">
            <label>Шаги приготовления:</label>
            <div id="steps-container">
                <?php foreach ($recipe['steps'] as $i => $step): ?>
                    <div class="step-input">
                        <input type="text" name="steps[]" value="<?php echo htmlspecialchars($step, ENT_QUOTES, 'UTF-8'); ?>" placeholder="Шаг <?php echo $i+1; ?>">
                        <button type="button" class="remove-step" onclick="removeStep(this)">Удалить</button>
                    </div>
                <?php endforeach; ?>
            </div>
            <button type="button" id="add-step" onclick="addStep()">Добавить шаг</button>
        </div>
        <button type="submit" name="submit">Сохранить изменения</button>
        <a class="danger" href="index.php?route=recipe/delete&id=<?php echo urlencode($recipe['id']); ?>" onclick="return confirm('Удалить рецепт?');">Удалить</a>
    </form>
    <script>
    function addStep() {
      const container = document.getElementById('steps-container');
      const stepCount = container.children.length + 1;
      const stepDiv = document.createElement('div');
      stepDiv.className = 'step-input';
      stepDiv.innerHTML = `
        <input type="text" name="steps[]" placeholder="Шаг ${stepCount}">
        <button type="button" class="remove-step" onclick="removeStep(this)">Удалить</button>
      `;
      container.appendChild(stepDiv);
    }
    function removeStep(btn) {
      const container = document.getElementById('steps-container');
      if (container.children.length > 1) {
        btn.parentElement.remove();
      }
    }
    </script>
<?php endif; ?>

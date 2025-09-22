<?php
// Форма создания рецепта
?>
<h1>Добавить новый рецепт</h1>
<?php if (!empty($_SESSION['errors'])): ?>
    <div class="errors">
        <?php foreach ($_SESSION['errors'] as $error): ?>
            <p class="error"><?php echo htmlspecialchars($error, ENT_QUOTES, 'UTF-8'); ?></p>
        <?php endforeach; unset($_SESSION['errors']); ?>
    </div>
<?php endif; ?>
<form action="index.php?route=recipe/create" method="POST" class="recipe-form">
    <div class="form-group">
        <label for="title">Название рецепта:</label>
        <input type="text" id="title" name="title" required>
    </div>
    <div class="form-group">
        <label for="category">Категория:</label>
        <select id="category" name="category" required>
            <option value="">Выберите категорию</option>
            <?php foreach (($categories ?? []) as $cat): ?>
                <option value="<?php echo (int)$cat['id']; ?>"><?php echo htmlspecialchars($cat['name'], ENT_QUOTES, 'UTF-8'); ?></option>
            <?php endforeach; ?>
        </select>
    </div>
    <div class="form-group">
        <label for="ingredients">Ингредиенты:</label>
        <textarea id="ingredients" name="ingredients" rows="5" required></textarea>
    </div>
    <div class="form-group">
        <label for="description">Описание рецепта:</label>
        <textarea id="description" name="description" rows="4" required></textarea>
    </div>
    <div class="form-group">
        <label for="tags">Теги:</label>
        <select id="tags" name="tags[]" multiple>
            <option value="quick">Быстро</option>
            <option value="healthy">Полезно</option>
            <option value="vegetarian">Вегетарианское</option>
            <option value="budget">Бюджетно</option>
        </select>
    </div>
    <div class="form-group">
        <label>Шаги приготовления:</label>
        <div id="steps-container">
            <div class="step-input">
                <input type="text" name="steps[]" placeholder="Шаг 1">
                <button type="button" class="remove-step" onclick="removeStep(this)">Удалить</button>
            </div>
        </div>
        <button type="button" id="add-step" onclick="addStep()">Добавить шаг</button>
    </div>
    <button type="submit" name="submit">Сохранить</button>
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

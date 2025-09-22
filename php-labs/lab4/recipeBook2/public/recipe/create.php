<?php
/**
 * Форма для добавления нового рецепта.
 *
 * Этот файл выводит страницу с формой для создания нового рецепта,
 * включая обработку ошибок из сессии и отправку данных к обработчику.
 *
 * @package RecipeCatalog
 */
session_start();
?>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Добавить рецепт</title>
    <link rel="stylesheet" href="../assets/styles.css">
</head>
<body>
    <div class="container">
        <h1>Добавить новый рецепт</h1>
                
        <?php if (isset($_SESSION['errors'])): ?>
            <div class="errors">
                <?php foreach ($_SESSION['errors'] as $error): ?>
                    <p class="error"><?php echo htmlspecialchars($error, ENT_QUOTES, 'UTF-8'); ?></p>
                <?php endforeach; ?>
                <?php unset($_SESSION['errors']); ?>
            </div>
        <?php endif; ?>

        <form action="../../src/handlers/recipe_handler.php" method="POST" class="recipe-form">
            <div class="form-group">
                <label for="title">Название рецепта:</label>
                <input type="text" id="title" name="title" required>
            </div>

            <div class="form-group">
                <label for="category">Категория:</label>
                <select id="category" name="category" required>
                    <option value="">Выберите категорию</option>
                    <option value="appetizer">Закуски</option>
                    <option value="main">Основные блюда</option>
                    <option value="dessert">Десерты</option>
                    <option value="drink">Напитки</option>
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
    </div>

    <script>
        /**
         * Добавляет новое поле для шага приготовления.
         *
         * Находит контейнер шагов, создаёт новый элемент ввода
         * и вставляет его в DOM.
         *
         * @return {void}
         */
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

        /**
         * Удаляет поле шага приготовления, если их больше одного.
         *
         * @param {HTMLElement} button Кнопка "Удалить" для конкретного шага.
         * @return {void}
         */
        function removeStep(button) {
            const container = document.getElementById('steps-container');
            if (container.children.length > 1) {
                button.parentElement.remove();
            }
        }
    </script>
</body>
</html>

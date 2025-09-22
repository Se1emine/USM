# Каталог рецептов (Recipe Book)

Небольшое PHP‑приложение для хранения рецептов с добавлением через форму, выводом последних рецептов на главной странице и списком всех рецептов с пагинацией. Данные хранятся в файле `storage/recipes.txt` в формате «один JSON‑объект на строку».

Основные директории:
- `public/` — веб‑корень (точка входа для встраиваемого веб‑сервера PHP).
  - `index.php` — главная с витриной «Последние рецепты».
  - `recipe/create.php` — форма добавления рецепта (POST → обработчик).
  - `recipe/index.php` — список всех рецептов с пагинацией.
  - `assets/styles.css` — стили оформления.
- `src/` — вспомогательные функции и обработчики форм.
  - `helpers.php` — фильтрация, валидация, сохранение и выборка рецептов.
  - `handlers/recipe_handler.php` — обработка POST‑отправки формы.
- `storage/recipes.txt` — файл‑хранилище рецептов.


## 1) Инструкции по запуску проекта

Требования:
- PHP 7.4+ (рекомендуется PHP 8.x)
- Операционная система: Windows (проект кроссплатформенный, подойдёт и macOS/Linux)
- База данных не требуется — используется файловое хранилище

Шаги запуска (Windows):
1. Откройте терминал в корне проекта `recipeBook2/`.
2. Запустите встроенный сервер PHP, указав веб‑корень `public/`:
   ```bash
   php -S localhost:8000 -t public
   ```
3. Откройте в браузере:
   - Главная: http://localhost:8000/
   - Все рецепты: http://localhost:8000/recipe/
   - Добавить рецепт: http://localhost:8000/recipe/create.php

Примечания:
- Папка `storage/` создаётся автоматически при сохранении первого рецепта (если её нет).
- Права на запись для `storage/` должны позволять PHP сохранять файл `recipes.txt`.


## 2) Описание лабораторной работы

В рамках лабораторной работы реализуется мини‑каталог рецептов на чистом PHP без фреймворков:
- Форма добавления рецепта с клиентским добавлением полей «Шаги приготовления».
- Серверная фильтрация и валидация входных данных.
- Сохранение рецепта в текстовый файл построчно в формате JSON.
- Главная страница с отображением последних N рецептов.
- Страница списка всех рецептов с пагинацией и минимальной навигацией.

Цели работы:
- Закрепить навыки работы с HTML‑формами и отправкой данных методом POST.
- Отработать базовые приёмы фильтрации и валидации данных на PHP.
- Освоить файловое хранилище (JSON‑на‑строку) как простой способ персистентности.
- Понять отличие представления данных (витрина последних) и полного списка с пагинацией.


## 3) Краткая документация к проекту

Ключевые компоненты:
- `public/index.php`
  - Подключает `src/helpers.php` и выводит блок «Последние рецепты»: `getLatestRecipes(2)`.
- `public/recipe/create.php`
  - Форма отправляет данные методом POST на `src/handlers/recipe_handler.php`.
  - Отображает ошибки из `$_SESSION['errors']` после редиректа при невалидных данных.
  - JS позволяет динамически добавлять/удалять поля шагов.
- `public/recipe/index.php`
  - Показывает список рецептов с пагинацией через `getPaginatedRecipes($page, 5)`.
- `src/helpers.php`
  - `filterInput($input)` — `trim` + `htmlspecialchars` для предотвращения XSS и лишних пробелов.
  - `validateRecipeData($title, $category, $ingredients, $description, $steps)` — проверяет обязательные поля и простые ограничения (минимальная длина названия, наличие хотя бы одного шага и т.п.).
  - `saveRecipe($recipeData)` — построчная запись JSON в `storage/recipes.txt` с блокировкой `LOCK_EX`.
  - `getAllRecipes()` — читает файл, декодирует строки JSON и возвращает массив (новые первыми).
  - `getLatestRecipes($count = 2)` — первые N из результата `getAllRecipes()`.
  - `getPaginatedRecipes($page = 1, $perPage = 5)` — возвращает данные текущей страницы + метаданные пагинации.
- `src/handlers/recipe_handler.php`
  - Принимает POST, фильтрует/валидирует, сохраняет рецепт и делает редирект на `/public/index.php`.
  - В случае ошибок пишет их в `$_SESSION['errors']` и редиректит обратно на форму.

Структура данных рецепта (пример):
```json
{
  "id": "684ad9b815db8",
  "title": "Суп",
  "category": "appetizer",
  "ingredients": "морковь, вода, соль",
  "description": "Вкусный суп",
  "tags": ["budget"],
  "steps": ["Налить воду", "Довести до кипения"],
  "created_at": "2025-06-12 15:44:24"
}
```


## 4) Примеры использования проекта

- Добавление рецепта (фрагмент формы `public/recipe/create.php`):
```html
<form action="../../src/handlers/recipe_handler.php" method="POST" class="recipe-form">
  <input type="text" id="title" name="title" required>
  <select id="category" name="category" required>
    <option value="">Выберите категорию</option>
    <option value="appetizer">Закуски</option>
    <option value="main">Основные блюда</option>
    <option value="dessert">Десерты</option>
    <option value="drink">Напитки</option>
  </select>
  <textarea id="ingredients" name="ingredients" rows="5" required></textarea>
  <textarea id="description" name="description" rows="4" required></textarea>
  <select id="tags" name="tags[]" multiple>
    <option value="quick">Быстро</option>
    <option value="healthy">Полезно</option>
    <option value="vegetarian">Вегетарианское</option>
    <option value="budget">Бюджетно</option>
  </select>
  <div id="steps-container">
    <div class="step-input">
      <input type="text" name="steps[]" placeholder="Шаг 1">
      <button type="button" class="remove-step" onclick="removeStep(this)">Удалить</button>
    </div>
  </div>
  <button type="button" id="add-step" onclick="addStep()">Добавить шаг</button>
  <button type="submit" name="submit">Сохранить</button>
</form>
```

- Серверная обработка (фрагмент `src/handlers/recipe_handler.php`):
```php
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['submit'])) {
    $title = filterInput($_POST['title'] ?? '');
    $category = filterInput($_POST['category'] ?? '');
    $ingredients = filterInput($_POST['ingredients'] ?? '');
    $description = filterInput($_POST['description'] ?? '');
    $tags = $_POST['tags'] ?? [];
    $steps = array_filter($_POST['steps'] ?? [], 'trim');

    $errors = validateRecipeData($title, $category, $ingredients, $description, $steps);

    if (empty($errors)) {
        $recipeData = [
            'id' => uniqid(),
            'title' => $title,
            'category' => $category,
            'ingredients' => $ingredients,
            'description' => $description,
            'tags' => $tags,
            'steps' => array_values($steps),
            'created_at' => date('Y-m-d H:i:s')
        ];

        if (saveRecipe($recipeData)) {
            header('Location: ../../public/index.php');
            exit;
        } else {
            $errors[] = 'Ошибка при сохранении рецепта';
        }
    }

    $_SESSION['errors'] = $errors;
    header('Location: ../../public/recipe/create.php');
    exit;
}
```

- Просмотр всех рецептов с пагинацией (фрагмент `public/recipe/index.php`):
```php
$page = isset($_GET['page']) ? max(1, intval($_GET['page'])) : 1;
$recipesData = getPaginatedRecipes($page, 5);
```

Скриншоты (опционально):
- Сделайте скриншоты страниц и добавьте их в `public/assets/`, затем вставьте в README, например:
  ```markdown
  ![Главная](public/assets/screenshot-home.png)
  ![Список рецептов](public/assets/screenshot-list.png)
  ![Форма добавления](public/assets/screenshot-create.png)
  ```


## 5) Ответы на контрольные вопросы

- Какие методы HTTP применяются для отправки данных формы?
  - Базово HTML‑формы используют методы `GET` и `POST`.
  - В данном проекте отправка выполняется методом `POST` (`method="POST"`) на `src/handlers/recipe_handler.php`.
  - Методы `PUT`, `PATCH`, `DELETE` напрямую формами не поддерживаются, их применяют через JS/AJAX или REST‑клиенты.

- Что такое валидация данных, и чем она отличается от фильтрации?
  - Валидация — проверка того, что данные соответствуют требованиям (обязательные поля, формат, длина, диапазоны и т.д.). Если условие не выполняется — формируется ошибка, данные отклоняются.
  - Фильтрация (санитизация) — преобразование данных к безопасному/нормализованному виду (обрезка пробелов, экранирование спецсимволов для HTML, удаление тегов и т.п.). Фильтрация не определяет «верны ли» данные по бизнес‑правилам, а делает их безопаснее.
  - В проекте: `filterInput()` выполняет фильтрацию (`trim` + `htmlspecialchars`), а `validateRecipeData()` — валидацию.

- Какие функции PHP используются для фильтрации данных?
  - Встроенные фильтры PHP: `filter_input()`, `filter_var()`, `filter_input_array()` и константы валидаторов/санитайзеров (`FILTER_VALIDATE_EMAIL`, `FILTER_SANITIZE_NUMBER_INT`, и др.).
  - Для XSS‑безопасного вывода: `htmlspecialchars()` (и при необходимости `htmlentities()`), а для удаления тегов — `strip_tags()`.
  - Для нормализации строк: `trim()`.
  - В данном проекте для фильтрации непосредственно используется комбинация `trim()` + `htmlspecialchars()` в `filterInput()`.


## 6) Список использованных источников

- Документация PHP: `htmlspecialchars()` — https://www.php.net/manual/ru/function.htmlspecialchars.php
- Документация PHP: `filter_input()` / `filter_var()` — https://www.php.net/manual/ru/book.filter.php
- Документация PHP: работа с файлами — https://www.php.net/manual/ru/ref.filesystem.php
- Документация PHP: `session_start()` — https://www.php.net/manual/ru/function.session-start.php


## 7) Дополнительные важные аспекты

- Безопасность:
  - Вывод всех пользовательских данных экранируется через `htmlspecialchars()` (см. `filterInput()` и вывод в шаблонах), что снижает риск XSS.
  - CSRF‑защита для формы не реализована. Для продакшн‑системы следует добавить CSRF‑токены.
  - Файл‑хранилище не шифруется и не разделяется по пользователям. Для реального приложения лучше использовать БД и контроль доступа.

- Хранение данных:
  - Используется формат JSON‑в‑строку (по одной записи на строку). Это упрощает добавление, но усложняет правки/удаление конкретной записи.
  - Для больших объёмов данных и сложных операций рекомендуется перейти на СУБД (MySQL/PostgreSQL/SQLite).

- Локализация и кодировка:
  - Все шаблоны используют UTF‑8. Время форматируется на основе `date()`.

- Пагинация:
  - Реализована простая пагинация по количеству записей с расчётом общего числа страниц и ссылками «Предыдущая/Следующая».

- Стиль кода:
  - В файлах присутствуют краткие PHPDoc‑комментарии к функциям и страницам.

Если потребуется, можно расширить проект поиском по рецептам, редактированием/удалением, загрузкой изображений блюд и полноценной CSRF‑защитой.

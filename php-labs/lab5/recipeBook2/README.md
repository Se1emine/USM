# Recipe Book — отчёт по проекту

Мини‑приложение на PHP (без фреймворков) с единой точкой входа, простой маршрутизацией, шаблонами и хранением данных в MySQL через PDO.

## Структура
```
recipe-book/
├── public/
│   └── index.php
├── src/
│   ├── handlers/
│   │   ├── recipe/
│   │   │   ├── create.php
│   │   │   ├── edit.php
│   │   │   └── delete.php
│   ├── db.php
│   ├── helpers.php
├── config/
│   └── db.php
├── templates/
│   ├── layout.php
│   ├── index.php
│   └── recipe/
│       ├── create.php
│       ├── edit.php
│       └── show.php
├── .env (опционально)
└── README.md
```

## 1) Инструкции по запуску проекта

- Установите XAMPP (Apache + MySQL + phpMyAdmin).
- Скопируйте проект в каталог веб‑сервера, например: `c:/xampp/htdocs/recipeBook2/`.
- Создайте базу данных MySQL `recipe_book` (через phpMyAdmin).
- Создайте таблицы (если у вас их ещё нет):
  ```sql
  CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  );

  CREATE TABLE recipes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    category INT NOT NULL,
    ingredients TEXT,
    description TEXT,
    tags TEXT,
    steps TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category) REFERENCES categories(id) ON DELETE CASCADE
  );
  ```
- Заполните базовые категории (можно выполнить в phpMyAdmin → SQL):
  ```sql
  USE `recipe_book`;
  SET NAMES utf8mb4;
  INSERT IGNORE INTO categories (name) VALUES
    ('Закуски'),
    ('Основные блюда'),
    ('Десерты'),
    ('Напитки');
  ```
- Настройте `.env` под вашу БД:
  ```dotenv
  DB_DRIVER=mysql
  DB_HOST=127.0.0.1
  DB_PORT=3306
  DB_NAME=recipe_book
  DB_CHARSET=utf8mb4
  DB_USER=root
  DB_PASS=
  ```
- Запустите Apache и MySQL в XAMPP.
- Откройте в браузере: http://localhost/recipeBook2/public/index.php

## 2) Описание лабораторной работы

- Реализована архитектура с единой точкой входа `public/index.php` и простой маршрутизацией через `?route=...`.
- Добавлена система шаблонов в каталоге `templates/` с базовым макетом `templates/layout.php`.
- Переведено хранение данных рецептов на MySQL (PDO).
- Реализована CRUD‑функциональность (создание, просмотр, редактирование, удаление).
- Выполнена серверная валидация входных данных.
- Настроена защита от SQL‑инъекций с использованием подготовленных выражений.
- Реализована пагинация с `LIMIT`/`OFFSET` на 5 записей на странице.

## 3) Краткая документация к проекту

- **Точка входа**: `public/index.php`
  - `render(string $template, array $params = [])` — рендер контента + базовый макет `templates/layout.php`.
  - Маршруты:
    - `route=index` — список рецептов, `page` — номер страницы;
    - `route=recipe/create` — форма (GET), обработка (POST);
    - `route=recipe/show&id=ID` — просмотр рецепта;
    - `route=recipe/edit&id=ID` — форма (GET), обработка (POST);
    - `route=recipe/delete&id=ID` — удаление.
- **Шаблоны**: `templates/`
  - `layout.php`, `index.php`, `recipe/create.php`, `recipe/edit.php`, `recipe/show.php`.
- **Утилиты/логика**: `src/`
  - `db.php` — `load_env()`, `db_config()`, `db()` (PDO singleton).
  - `helpers.php` — CRUD рецептов и выборки, валидация, категории.
- **Обработчики**: `src/handlers/recipe/` — `create.php`, `edit.php`, `delete.php`.

Подробные PHPDoc‑комментарии — в `src/db.php`, `src/helpers.php`, `public/index.php`.

## 4) Примеры использования проекта

- Добавление рецепта (фрагмент обработчика):
```php
$title = filterInput($_POST['title'] ?? '');
$category = (int)($_POST['category'] ?? 0);
$tags = array_values(array_filter(array_map('trim', (array)($_POST['tags'] ?? []))));
$steps = array_values(array_filter(array_map('trim', (array)($_POST['steps'] ?? []))));

$errors = validateRecipeData($title, (string)$category, $ingredients, $description, $steps);
$stmt = db()->prepare('SELECT COUNT(*) FROM categories WHERE id = :id');
$stmt->execute([':id' => $category]);

saveRecipe([
  'title' => $title,
  'category' => $category,
  'ingredients' => $ingredients,
  'description' => $description,
  'tags' => $tags,
  'steps' => $steps,
]);
```

- Пагинация (фрагмент):
```php
$total = (int)db()->query('SELECT COUNT(*) FROM recipes')->fetchColumn();
$stmt = db()->prepare('SELECT r.*, c.name AS category_name FROM recipes r LEFT JOIN categories c ON c.id = r.category ORDER BY r.created_at DESC, r.id DESC LIMIT :lim OFFSET :off');
$stmt->bindValue(':lim', 5, PDO::PARAM_INT);
$stmt->bindValue(':off', ($page - 1) * 5, PDO::PARAM_INT);
$stmt->execute();
```

Скриншоты рекомендуется приложить: главная страница (список), создание, просмотр, редактирование/удаление.

## 5) Ответы на контрольные вопросы

- Какие преимущества даёт использование единой точки входа в веб‑приложении?
 - Централизация маршрутов, middleware, обработок ошибок и логирования; повышение безопасности (нет прямого доступа к служебным файлам).
- Какие преимущества даёт использование шаблонов?
 - Разделение логики и представления, переиспользование макета, единый UI, меньше дублирования.
- Какие преимущества даёт хранение данных в базе по сравнению с хранением в файлах?
 - Транзакционность, целостность, индексы, эффективные выборки и масштабируемость.
- Что такое SQL‑инъекция? Пример и предотвращение.
 - Внедрение вредоносного SQL через пользовательский ввод (например, `Новый рецепт'); DROP TABLE recipes; --`).
 - Предотвращение: подготовленные выражения (prepared), приведение типов, отключение эмуляции prepared (`PDO::ATTR_EMULATE_PREPARES=false`).

## 6) Список использованных источников

- PHP Manual — https://www.php.net/manual/
- PDO — https://www.php.net/manual/en/book.pdo.php
- OWASP. SQL Injection — https://owasp.org/www-community/attacks/SQL_Injection

## 7) Дополнительные важные аспекты

- Безопасность
 - `htmlspecialchars(..., ENT_QUOTES, 'UTF-8')` в шаблонах, проверка существования категории, серверная валидация, редиректы и сообщения об ошибках в сессии.
- Производительность
 - Рекомендуемые индексы:
   ```sql
   CREATE INDEX idx_recipes_created_at_id ON recipes (created_at DESC, id DESC);
   CREATE INDEX idx_recipes_category ON recipes (category);
   ```
- Расширения (идеи)
 - Фильтр по категории, поиск, теги, загрузка изображений, роли пользователей.

## Хранилище
- По умолчанию рецепты хранятся в `storage/recipes.txt` (по одной JSON строке на рецепт).
- Путь можно переопределить переменной окружения `RECIPE_STORAGE` или в `config/db.php` (ключ `storage_file`).

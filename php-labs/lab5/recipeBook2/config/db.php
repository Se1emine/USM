<?php
return [
    // Можно изменить путь на абсолютный
    'storage_file' => __DIR__ . '/../storage/recipes.txt',

    // Параметры подключения к базе данных по умолчанию (можно переопределить через .env)
    'db' => [
        // 'dsn' => 'mysql:host=127.0.0.1;port=3306;dbname=recipe_book;charset=utf8mb4',
        'driver' => 'mysql',
        'host' => '127.0.0.1',
        'port' => 3306,
        'name' => 'recipe_book',
        'charset' => 'utf8mb4',
        'user' => 'root',
        'pass' => '',
    ],
];

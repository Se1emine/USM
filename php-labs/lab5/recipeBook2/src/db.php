<?php
/**
 * Простая конфигурация "БД" (файл-хранилище)
 */

/**
 * Загружает переменные окружения из файла .env (простая реализация без внешних библиотек).
 *
 * @param string|null $path Полный путь к .env. Если не указан, используется корневой .env проекта.
 * @return void
 */
function load_env(string $path = null): void {
    static $loaded = false;
    if ($loaded) { return; }
    $loaded = true;
    $path = $path ?? (__DIR__ . '/../.env');
    if (!file_exists($path)) { return; }
    $lines = file($path, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
    foreach ($lines as $line) {
        $line = trim($line);
        if ($line === '' || strpos($line, '#') === 0) { continue; }
        $pos = strpos($line, '=');
        if ($pos === false) { continue; }
        $key = trim(substr($line, 0, $pos));
        $val = trim(substr($line, $pos + 1));
        $val = trim($val, "\"' ");
        if ($key !== '') {
            putenv($key . '=' . $val);
            $_ENV[$key] = $val;
        }
    }
}

/**
 * Возвращает путь к файлу хранения рецептов.
 * Источники (по приоритету):
 * 1) переменная окружения RECIPE_STORAGE
 * 2) config/db.php -> ['storage_file']
 * 3) путь по умолчанию: __DIR__ . '/../storage/recipes.txt'
 *
 * @return string Абсолютный путь к файлу хранилища рецептов
 */
function recipe_storage_path(): string {
    // .env переменная окружения
    load_env();
    $env = getenv('RECIPE_STORAGE');
    if ($env && is_string($env)) {
        return $env;
    }

    // конфиг
    $configFile = __DIR__ . '/../config/db.php';
    if (file_exists($configFile)) {
        $cfg = include $configFile;
        if (is_array($cfg) && isset($cfg['storage_file']) && is_string($cfg['storage_file']) && $cfg['storage_file'] !== '') {
            return $cfg['storage_file'];
        }
    }

    // по умолчанию
    return __DIR__ . '/../storage/recipes.txt';
}

/**
 * Считывает конфигурацию подключения к БД из .env и/или config/db.php,
 * подставляя разумные значения по умолчанию для XAMPP.
 *
 * @return array{dsn:string,user:?string,pass:?string,options:array} Ассоц. массив параметров PDO
 */
function db_config(): array {
    load_env();

    // ENV приоритетнее всего
    $dsn = getenv('DB_DSN') ?: '';
    $user = getenv('DB_USER') !== false ? getenv('DB_USER') : null;
    $pass = getenv('DB_PASS') !== false ? getenv('DB_PASS') : null;
    $charset = getenv('DB_CHARSET') ?: 'utf8mb4';
    $driver = getenv('DB_DRIVER') ?: 'mysql';
    $host = getenv('DB_HOST') ?: '127.0.0.1';
    $port = getenv('DB_PORT') ?: '';
    $name = getenv('DB_NAME') ?: '';

    if ($dsn === '' && $driver === 'mysql' && $name !== '') {
        $dsn = "mysql:host={$host}" . ($port !== '' ? ";port={$port}" : '') . ";dbname={$name};charset={$charset}";
    }

    // Если DSN не собран из ENV — попробуем конфиг файл
    if ($dsn === '') {
        $configFile = __DIR__ . '/../config/db.php';
        if (file_exists($configFile)) {
            $cfg = include $configFile;
            if (is_array($cfg) && isset($cfg['db']) && is_array($cfg['db'])) {
                $dbc = $cfg['db'];
                $driver = $dbc['driver'] ?? $driver;
                $host = $dbc['host'] ?? $host;
                $port = $dbc['port'] ?? $port;
                $name = $dbc['name'] ?? $name;
                $charset = $dbc['charset'] ?? $charset;
                $user = $dbc['user'] ?? $user;
                $pass = $dbc['pass'] ?? $pass;
                $dsn = $dbc['dsn'] ?? '';
                if ($dsn === '' && $driver === 'mysql' && $name !== '') {
                    $dsn = "mysql:host={$host}" . ($port !== '' ? ";port={$port}" : '') . ";dbname={$name};charset={$charset}";
                }
            }
        }
    }

    // Значения по умолчанию (XAMPP MySQL) если всё ещё пусто
    if ($dsn === '') {
        $name = $name !== '' ? $name : 'recipe_book';
        $dsn = "mysql:host=127.0.0.1;dbname={$name};charset={$charset}";
        $user = $user ?? 'root';
        $pass = $pass ?? '';
    }

    $options = [
        PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES => false,
    ];

    return compact('dsn', 'user', 'pass', 'options');
}

/**
 * Возвращает singleton экземпляр PDO, настроенный на выбрасывание исключений.
 *
 * Пример использования:
 * $pdo = db();
 *
 * @return PDO Экземпляр PDO c заданными опциями
 */
function db(): PDO {
    static $pdo = null;
    if ($pdo instanceof PDO) { return $pdo; }
    $cfg = db_config();
    $pdo = new PDO($cfg['dsn'], $cfg['user'], $cfg['pass'], $cfg['options']);
    return $pdo;
}

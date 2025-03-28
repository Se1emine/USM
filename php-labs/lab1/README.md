# Отчет по лабораторной работе №1

## Инструкции по запуску проекта

**1. Склонируйте данный репозиторий или скачайте архив.**

**2. Перейдите в каталог проекта через командную строку.**

**3. Убедитесь, что у вас установлен PHP:**

Откройте терминал/командную строку и выполните:
```bash
php -v
```
Если вывод содержит информацию о версии PHP, значит PHP установлен. Если команда не распознана, необходимо установить PHP или воспользоваться XAMPP (см. ниже).

**4. Если PHP не установлен:**

- Установка PHP вручную:

  - Перейдите на официальный сайт PHP: https://www.php.net/downloads.

  - Загрузите актуальную версию PHP для вашей операционной системы.

  - Распакуйте архив в удобное место, например: C:\Program Files\php.

  - Добавьте путь к PHP в переменные среды (Path):
    - Откройте Параметры системы (`Win + R` → `sysdm.cpl`).
     - Перейдите в `Дополнительно` → `Переменные среды`.
    - В разделе Системные переменные выберите `Path` и добавьте путь `C:\Program Files\php`.
    - Сохраните изменения.

- Альтернативный вариант – установка XAMPP:

  - Перейдите на сайт: https://www.apachefriends.org.

  - Скачайте и установите XAMPP, выбрав компоненты:
    - Apache
    - PHP
    - phpMyAdmin

  - Запустите XAMPP Control Panel и включите Apache.
  - Проверьте работу сервера, открыв `http://localhost` в браузере.

**5. Запуск проекта:**

- С использованием встроенного веб-сервера PHP:
  - Находясь в корневой папке проекта, выполните команду: 
  ```bash
  php -S localhost:8000
  ```
  - Откройте браузер и перейдите по адресу `http://localhost:8000` для просмотра работы проекта.

- С использованием XAMPP:
  - Если вы установили XAMPP, переместите клонированную папку проекта в директорию htdocs (обычно `C:\xampp\htdocs\`).
  - Запустите Apache через панель управления XAMPP.
  - Откройте браузер и перейдите по адресу `http://localhost/YourProject`.

## Описание лабораторной работы

Целью лабораторной работы является установка и настройка среды разработки для работы с языком программирования PHP, а также создание первой программы на PHP, которая выводит данные на экран.

## Краткая документация к проекту

__В рамках лабораторной работы выполняются следующие шаги:__

- Установка PHP или XAMPP.
- Создание простого PHP-скрипта для вывода текста на экран.
- Описание базовых операций с переменными в PHP.

__Структура проекта:__
- `index.php`: Основной PHP файл, в котором осуществляется исполнение всего кода.
- `README.md`: Файл с описанием структуры проекта, его функциональности и инструкциями по использованию.

## Примеры использования проекта с приложением скриншотов или фрагментов кода

В данном случае не требуется предоставление скриншотов. Достаточно запустить проект и ознакомиться с результатом. 

**Пример кода из файла index.php:**

  ```php
  <?php
echo "Привет, мир!";

echo "<br>";
echo "Hello, World with echo!";

print "<br>";
print "Hello, World with print!";

$days = 288;
$message = "Все возвращаются на работу!";

echo "Количество дней: " . $days . "<br>";
echo "Сообщение: " . $message . "<br>";

echo "Количество дней: $days <br>";
echo "Сообщение: $message <br>";
?>
  ```

## Ответы на контрольные вопросы

1. **Какие способы установки PHP существуют?**  
   - **Ручная установка**: Загрузка с [официального сайта](https://www.php.net), настройка переменных среды.  
   - **Сборки**: XAMPP, WAMP, OpenServer (включают PHP, сервер и СУБД).  
   - **Пакетные менеджеры**: Chocolatey (Windows), Homebrew (macOS), apt (Linux).

2. **Как проверить, что PHP установлен и работает**  
   - В командной строке: `php -v` (покажет версию).  
   - Через веб-сервер: создайте файл `test.php` с кодом `<?php phpinfo(); ?>` и откройте его в браузере.  
   - В XAMPP: файлы проекта разместите в папке `htdocs` и проверьте по адресу `http://localhost`.

3. **Чем отличается оператор `echo` от `print`**  
   - **`echo`**: Выводит несколько значений, не возвращает результат, работает быстрее.  
   - **`print`**: Выводит только одно значение, возвращает `1`, можно использовать в выражениях.  
   Пример: `<?php $result = print "Hello"; ?>` — корректно, с `echo` так не работает.


## Список использованных источников

1. Официальный сайт [PHP](https://www.php.net).

2. Официальный сайт [XAMPP](https://www.apachefriends.org).

3. [Документация](https://www.php.net/manual/ru/) по PHP на русском. 

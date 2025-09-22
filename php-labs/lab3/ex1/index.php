<?php

declare(strict_types=1);

/**
 * id – уникальный идентификатор транзакции;
 * date – дата совершения транзакции (YYYY-MM-DD);
 * amount – сумма транзакции;
 * description – описание назначения платежа;
 * merchant – название организации, получившей платеж.
**/

$transactions = [
    [
        "id" => 1,
        "date" => "2019-01-01",
        "amount" => 100.00,
        "description" => "Payment for groceries",
        "merchant" => "SuperMart",
    ],
    [
        "id" => 2,
        "date" => "2020-02-15",
        "amount" => 75.50,
        "description" => "Dinner with friends",
        "merchant" => "Local Restaurant",
    ],
    [
        "id" => 3,
        "date" => "2023-03-10",
        "amount" => 250.00,
        "description" => "Online shopping electronics",
        "merchant" => "TechStore",
    ],
    [
        "id" => 4,
        "date" => "2024-01-20",
        "amount" => 45.30,
        "description" => "Coffee and breakfast",
        "merchant" => "Coffee House",
    ],
    [
        "id" => 5,
        "date" => "2024-12-05",
        "amount" => 120.75,
        "description" => "Utility bills payment",
        "merchant" => "City Services",
    ],
    [
        "id" => 6,
        "date" => "2024-03-22",
        "amount" => 89.99,
        "description" => "Monthly gym membership",
        "merchant" => "FitLife Gym",
    ],
    [
        "id" => 7,
        "date" => "2024-04-05",
        "amount" => 12.50,
        "description" => "Public transport card top-up",
        "merchant" => "Metro Services",
    ],
    [
        "id" => 8,
        "date" => "2024-05-18",
        "amount" => 299.99,
        "description" => "New smartphone purchase",
        "merchant" => "MobileTech",
    ],
    [
        "id" => 9,
        "date" => "2023-11-30",
        "amount" => 67.20,
        "description" => "Online course subscription",
        "merchant" => "EduPlatform",
    ],
    [
        "id" => 10,
        "date" => "2024-06-08",
        "amount" => 34.75,
        "description" => "Pizza delivery order",
        "merchant" => "Mario's Pizza",
    ],
    [
        "id" => 11,
        "date" => "2024-02-14",
        "amount" => 156.80,
        "description" => "Valentine's day flowers and gifts",
        "merchant" => "Flower Boutique",
    ],
    [
        "id" => 12,
        "date" => "2023-12-25",
        "amount" => 89.00,
        "description" => "Christmas dinner ingredients",
        "merchant" => "Gourmet Market",
    ],
    [
        "id" => 13,
        "date" => "2024-04-15",
        "amount" => 15.99,
        "description" => "Monthly streaming service",
        "merchant" => "StreamFlix",
    ],
    [
        "id" => 14,
        "date" => "2024-05-03",
        "amount" => 78.40,
        "description" => "Car fuel payment",
        "merchant" => "Gas Station Plus",
    ],
    [
        "id" => 15,
        "date" => "2024-03-28",
        "amount" => 125.00,
        "description" => "Hair salon appointment",
        "merchant" => "Style Studio",
    ],
    [
        "id" => 16,
        "date" => "2024-01-10",
        "amount" => 42.60,
        "description" => "Office supplies shopping",
        "merchant" => "OfficeMax",
    ],
    [
        "id" => 17,
        "date" => "2023-09-15",
        "amount" => 199.99,
        "description" => "Winter jacket purchase",
        "merchant" => "Fashion Store",
    ],
    [
        "id" => 18,
        "date" => "2024-05-20",
        "amount" => 28.30,
        "description" => "Pharmacy prescription medication",
        "merchant" => "City Pharmacy",
    ],
    [
        "id" => 19,
        "date" => "2024-04-12",
        "amount" => 95.75,
        "description" => "Weekend grocery shopping",
        "merchant" => "Fresh Market",
    ],
    [
        "id" => 20,
        "date" => "2024-06-01",
        "amount" => 18.99,
        "description" => "Book purchase online",
        "merchant" => "BookWorld",
    ]
];

/**
 * Вычисляет общую сумму переданных транзакций.
 *
 * @param array $transactions Массив транзакций, где каждая транзакция содержит ключ 'amount'.
 * @return float Общая сумма всех транзакций.
 */
function calculateTotalAmount(array $transactions): float
{
    $total = 0.0;
    foreach ($transactions as $transaction) {
        $total += $transaction['amount'];
    }
    return $total;
}

/**
 * Ищет транзакции по части описания (поиск без учета регистра).
 *
 * @param string $descriptionPart Подстрока для поиска в описании транзакции.
 * @return array Массив найденных транзакций, соответствующих условию.
 */
function findTransactionByDescription(string $descriptionPart): array
{
    global $transactions;
    $result = [];
    
    foreach ($transactions as $transaction) {
        if (stripos($transaction['description'], $descriptionPart) !== false) {
            $result[] = $transaction;
        }
    }
    
    return $result;
}

/**
 * Ищет транзакцию по ее уникальному идентификатору.
 *
 * @param int $id Идентификатор транзакции для поиска.
 * @return array|null Массив транзакции при успешном поиске, или null, если не найдена.
 */
function findTransactionById(int $id): ?array
{
    global $transactions;
    
    foreach ($transactions as $transaction) {
        if ($transaction['id'] === $id) {
            return $transaction;
        }
    }
    
    return null;
}

/**
 * Ищет транзакцию по ID, используя array_filter для демонстрации альтернативного подхода.
 *
 * @param int $id Идентификатор транзакции для поиска.
 * @return array|null Массив транзакции или null, если не найдено.
 */
function findTransactionByIdFilter(int $id): ?array
{
    global $transactions;
    
    $filtered = array_filter($transactions, function($transaction) use ($id) {
        return $transaction['id'] === $id;
    });
    
    return empty($filtered) ? null : array_values($filtered)[0];
}

/**
 * Вычисляет количество дней, прошедших с даты транзакции до текущей даты.
 *
 * @param string $date Дата транзакции в формате YYYY-MM-DD.
 * @return int Количество дней между переданной датой и текущей.
 */
function daysSinceTransaction(string $date): int
{
    $transactionDate = new DateTime($date);
    $currentDate = new DateTime();
    $diff = $currentDate->diff($transactionDate);
    
    return $diff->days;
}

/**
 * Добавляет новую транзакцию в глобальный массив транзакций.
 *
 * @param int $id Уникальный идентификатор новой транзакции.
 * @param string $date Дата транзакции (формат YYYY-MM-DD).
 * @param float $amount Сумма транзакции.
 * @param string $description Описание транзакции.
 * @param string $merchant Название продавца или сервиса.
 * @return void
 */
function addTransaction(int $id, string $date, float $amount, string $description, string $merchant): void
{
    global $transactions;
    
    $newTransaction = [
        "id" => $id,
        "date" => $date,
        "amount" => $amount,
        "description" => $description,
        "merchant" => $merchant
    ];
    
    $transactions[] = $newTransaction;
}

/**
 * Сортирует массив транзакций по дате (от старых к новым) по ссылке.
 *
 * @param array &$transactions Массив транзакций для сортировки.
 * @return void
 */
function sortTransactionsByDate(array &$transactions): void
{
    usort($transactions, function($a, $b) {
        return strtotime($a['date']) <=> strtotime($b['date']);
    });
}

/**
 * Сортирует массив транзакций по сумме (от большей к меньшей) по ссылке.
 *
 * @param array &$transactions Массив транзакций для сортировки.
 * @return void
 */
function sortTransactionsByAmount(array &$transactions): void
{
    usort($transactions, function($a, $b) {
        return $b['amount'] <=> $a['amount'];
    });
}

/**
 * Выводит HTML-таблицу с данными транзакций и количеством дней с момента каждой транзакции.
 *
 * @param array $transactions Массив транзакций для отображения.
 * @return void
 */
function displayTransactions(array $transactions): void
{
    echo "<table border='1' style='border-collapse: collapse; width: 100%;'>";
    echo "<thead>";
    echo "<tr style='background-color: #f2f2f2;'>";
    echo "<th>ID</th>";
    echo "<th>Дата</th>";
    echo "<th>Сумма</th>";
    echo "<th>Описание</th>";
    echo "<th>Продавец</th>";
    echo "<th>Дней назад</th>";
    echo "</tr>";
    echo "</thead>";
    echo "<tbody>";
    
    foreach ($transactions as $transaction) {
        echo "<tr>";
        echo "<td>" . htmlspecialchars((string)$transaction['id']) . "</td>";
        echo "<td>" . htmlspecialchars($transaction['date']) . "</td>";
        echo "<td>$" . number_format($transaction['amount'], 2) . "</td>";
        echo "<td>" . htmlspecialchars($transaction['description']) . "</td>";
        echo "<td>" . htmlspecialchars($transaction['merchant']) . "</td>";
        echo "<td>" . daysSinceTransaction($transaction['date']) . "</td>";
        echo "</tr>";
    }
    
    echo "</tbody>";
    echo "</table>";
}

?>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Система управления банковскими транзакциями</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Система управления банковскими транзакциями</h1>
    
    <div class="section">
        <h2>Все транзакции</h2>
        <?php displayTransactions($transactions); ?>
        <p class="total">Общая сумма всех транзакций: $<?php echo number_format(calculateTotalAmount($transactions), 2); ?></p>
    </div>
    
    <div class="section">
        <h2>Добавление новой транзакции</h2>
        <?php 
        addTransaction(21, "2025-06-11", 85.99, "Book purchase", "BookStore");
        echo "<p>Добавлена новая транзакция (ID: 21)</p>";
        ?>
        <?php displayTransactions($transactions); ?>
        <p class="total">Общая сумма после добавления: $<?php echo number_format(calculateTotalAmount($transactions), 2); ?></p>
    </div>

    <div class="section">
        <h2>Поиск транзакций по описанию</h2>
        <?php 
        $searchResults = findTransactionByDescription("payment");
        echo "<p>Найдено транзакций с 'payment' в описании: " . count($searchResults) . "</p>";
        if (!empty($searchResults)) {
            displayTransactions($searchResults);
        }
        ?>
    </div>

    <div class="section">
        <h2>Поиск транзакции по ID</h2>
        <?php 
        $foundTransaction = findTransactionById(3);
        if ($foundTransaction) {
            echo "<p>Найдена транзакция с ID 3:</p>";
            displayTransactions([$foundTransaction]);
        } else {
            echo "<p>Транзакция с ID 3 не найдена</p>";
        }
        
        $foundTransactionFilter = findTransactionByIdFilter(3);
        echo "<p>Поиск через array_filter дал тот же результат: " . 
             ($foundTransactionFilter ? "Да" : "Нет") . "</p>";
        ?>
    </div>

    <div class="section">
        <h2>Сортировка по дате</h2>
        <?php 
        $transactionsCopy = $transactions;
        sortTransactionsByDate($transactionsCopy);
        echo "<p>Транзакции отсортированы по дате (от старых к новым):</p>";
        displayTransactions($transactionsCopy);
        ?>
    </div>

    <div class="section">
        <h2>Сортировка по сумме (убывание)</h2>
        <?php 
        $transactionsCopy = $transactions;
        sortTransactionsByAmount($transactionsCopy);
        echo "<p>Транзакции отсортированы по сумме (от больших к меньшим):</p>";
        displayTransactions($transactionsCopy);
        ?>
    </div>

    <div class="section">
        <h2>Демонстрация функций</h2>
        <ul>
            <li>Общая сумма транзакций: $<?php echo number_format(calculateTotalAmount($transactions), 2); ?></li>
            <li>Количество дней с последней транзакции: <?php echo daysSinceTransaction("2025-06-11"); ?></li>
            <li>Транзакций с "coffee" в описании: <?php echo count(findTransactionByDescription("coffee")); ?></li>
        </ul>
    </div>
</body>
</html>

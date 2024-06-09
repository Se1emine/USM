// Импортируем класс TransactionAnalyzer
const TransactionAnalyzer = require("./transactionAnalyzer");

// Импортируем транзакции из JSON файла
const transactions = require("./transaction.json");

/**
 * Основной файл для использования класса TransactionAnalyzer.
 * @module main
 */

/**
 * Создает экземпляр класса TransactionAnalyzer и выполняет основные операции.
 */
function main() {
  // Создаем экземпляр класса TransactionAnalyzer
  const analyzer = new TransactionAnalyzer(transactions);

  /**
   * Пример использования методов класса TransactionAnalyzer.
   * Выводит информацию о транзакциях в консоль.
   */
  console.log("Все транзакции:", analyzer.getAllTransactions());
  console.log(
    "Уникальные типы транзакций:",
    analyzer.getUniqueTransactionTypes()
  );
  console.log("Общая сумма всех транзакций:", analyzer.calculateTotalAmount());
  console.log(
    "Средняя сумма транзакции:",
    analyzer.calculateAverageTransactionAmount()
  );
  console.log(
    "Транзакции по типу 'debit':",
    analyzer.getTransactionByType("debit")
  );

  // Добавление новой транзакции
  const newTransaction = {
    transaction_id: "5",
    transaction_date: "2024-06-07",
    transaction_type: "credit",
    transaction_amount: 150,
    merchant_name: "New Merchant",
    transaction_description: "New Transaction Description",
  };

  /**
   * Добавляет новую транзакцию и выводит обновленный список всех транзакций.
   */
  analyzer.addTransaction(newTransaction);

  console.log(
    "Все транзакции после добавления новой:",
    analyzer.getAllTransactions()
  );
}

// Выполнение основной функции
main();

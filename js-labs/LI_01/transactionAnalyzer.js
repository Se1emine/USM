/**
 * Класс для анализа транзакций.
 */
class TransactionAnalyzer {
  /**
   * Создает экземпляр класса TransactionAnalyzer.
   * @param {Array} transactions Массив транзакций для анализа.
   */
  constructor(transactions) {
    /**
     * Массив транзакций для анализа.
     * @type {Array}
     */
    this.transactions = transactions.map((t) => {
      t.string = () => JSON.stringify(t);
      return t;
    });
  }

  /**
   * Добавляет новую транзакцию в массив.
   * @param {Object} transaction Новая транзакция для добавления.
   */
  addTransaction(transaction) {
    transaction.string = () => JSON.stringify(transaction);
    this.transactions.push(transaction);
  }

  /**
   * Возвращает список всех транзакций.
   * @returns {Array} Массив всех транзакций.
   */
  getAllTransactions() {
    return this.transactions;
  }

  /**
   * Возвращает уникальные типы транзакций.
   * @returns {Set} Множество уникальных типов транзакций.
   */
  getUniqueTransactionTypes() {
    return new Set(this.transactions.map((t) => t.transaction_type));
  }

  /**
   * Рассчитывает общую сумму всех транзакций.
   * @returns {number} Общая сумма всех транзакций.
   */
  calculateTotalAmount() {
    return this.transactions.reduce((acc, t) => acc + t.transaction_amount, 0);
  }

  /**
   * Рассчитывает общую сумму транзакций по указанной дате.
   * @param {number} [year] Год.
   * @param {number} [month] Месяц (1-12).
   * @param {number} [day] День.
   * @returns {number} Общая сумма транзакций по указанной дате.
   */
  calculateTotalAmountByDate(year, month, day) {
    const filteredTransactions = this.transactions.filter((t) => {
      const transactionDate = new Date(t.transaction_date);
      return (
        (year === undefined || transactionDate.getFullYear() === year) &&
        (month === undefined || transactionDate.getMonth() === month - 1) &&
        (day === undefined || transactionDate.getDate() === day)
      );
    });
    return filteredTransactions.reduce(
      (acc, t) => acc + t.transaction_amount,
      0
    );
  }

  /**
   * Возвращает транзакции по указанному типу.
   * @param {string} type Тип транзакции.
   * @returns {Array} Массив транзакций указанного типа.
   */
  getTransactionByType(type) {
    return this.transactions.filter((t) => t.transaction_type === type);
  }

  /**
   * Возвращает транзакции в заданном диапазоне дат.
   * @param {Date} startDate Начальная дата диапазона.
   * @param {Date} endDate Конечная дата диапазона.
   * @returns {Array} Массив транзакций в заданном диапазоне дат.
   */
  getTransactionsInDateRange(startDate, endDate) {
    const start = new Date(startDate);
    const end = new Date(endDate);
    return this.transactions.filter((t) => {
      const transactionDate = new Date(t.transaction_date);
      return transactionDate >= start && transactionDate <= end;
    });
  }

  /**
   * Возвращает транзакции по имени магазина.
   * @param {string} merchantName Название магазина.
   * @returns {Array} Массив транзакций с указанным именем магазина.
   */
  getTransactionsByMerchant(merchantName) {
    return this.transactions.filter((t) => t.merchant_name === merchantName);
  }

  /**
   * Рассчитывает среднее значение транзакций.
   * @returns {number} Среднее значение транзакций.
   */
  calculateAverageTransactionAmount() {
    if (this.transactions.length === 0) return 0;
    return this.calculateTotalAmount() / this.transactions.length;
  }

  /**
   * Возвращает транзакции в заданном диапазоне сумм.
   * @param {number} minAmount Минимальная сумма транзакции.
   * @param {number} maxAmount Максимальная сумма транзакции.
   * @returns {Array} Массив транзакций в заданном диапазоне сумм.
   */
  getTransactionsByAmountRange(minAmount, maxAmount) {
    return this.transactions.filter(
      (t) =>
        t.transaction_amount >= minAmount && t.transaction_amount <= maxAmount
    );
  }

  /**
   * Рассчитывает общую сумму дебетовых транзакций.
   * @returns {number} Общая сумма дебетовых транзакций.
   */
  calculateTotalDebitAmount() {
    return this.transactions
      .filter((t) => t.transaction_type === "debit")
      .reduce((acc, t) => acc + t.transaction_amount, 0);
  }

  /**
   * Находит месяц с наибольшим числом транзакций.
   * @param {string} [type] Тип транзакции (debit, credit).
   * @returns {number} Номер месяца с наибольшим числом транзакций (1-12).
   */
  findMostTransactionsMonth(type) {
    const months = Array(12).fill(0);
    this.transactions.forEach((t) => {
      if (!type || t.transaction_type === type) {
        const transactionDate = new Date(t.transaction_date);
        months[transactionDate.getMonth()]++;
      }
    });
    return months.indexOf(Math.max(...months)) + 1;
  }

  /**
   * Определяет преобладающий тип транзакций (дебет/кредит/равное количество).
   * @returns {string} Преобладающий тип транзакций ("debit", "credit" или "equal").
   */
  mostTransactionTypes() {
    const debitCount = this.transactions.filter(
      (t) => t.transaction_type === "debit"
    ).length;
    const creditCount = this.transactions.filter(
      (t) => t.transaction_type === "credit"
    ).length;
    if (debitCount > creditCount) return "debit";
    if (creditCount > debitCount) return "credit";
    return "equal";
  }

  /**
   * Возвращает транзакции, совершенные до указанной даты.
   * @param {Date} date Дата.
   * @returns {Array} Массив транзакций, совершенных до указанной даты.
   */
  getTransactionsBeforeDate(date) {
    const endDate = new Date(date);
    return this.transactions.filter((t) => {
      const transactionDate = new Date(t.transaction_date);
      return transactionDate <= endDate;
    });
  }

  /**
   * Находит транзакцию по ее уникальному идентификатору.
   * @param {string} id Уникальный идентификатор транзакции.
   * @returns {Object} Транзакция с указанным идентификатором или undefined, если не найдена.
   */
  findTransactionById(id) {
    return this.transactions.find((t) => t.transaction_id === id);
  }

  /**
   * Возвращает новый массив, содержащий только описания транзакций.
   * @returns {Array} Массив описаний транзакций.
   */
  mapTransactionDescriptions() {
    return this.transactions.map((t) => t.transaction_description);
  }
}
module.exports = TransactionAnalyzer;

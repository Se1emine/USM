/**
 * Отображает индикатор загрузки.
 */
function showLoading() {
  document.getElementById("loading").textContent = "Загрузка...";
}

/**
 * Скрывает индикатор загрузки.
 */
function hideLoading() {
  document.getElementById("loading").textContent = "";
}

/** Массив транзакций */
let transactions = [];

/** ID последней транзакции */
let lastTransactionId = 0;

/**
 * Создает объект транзакции.
 * @param {string} date - Дата транзакции.
 * @param {number} amount - Сумма транзакции.
 * @param {string} category - Категория транзакции.
 * @param {string} description - Описание транзакции.
 * @param {string} currency - Валюта транзакции.
 * @returns {Object} - Созданный объект транзакции.
 */
function createTransaction(date, amount, category, description, currency) {
  lastTransactionId++;
  return {
    id: lastTransactionId,
    date: date,
    amount: amount,
    category: category,
    description: description,
    currency: currency,
  };
}

/**
 * Добавляет транзакцию.
 */
function addTransaction() {
  const dateInput = document.querySelector("#date");
  const amountInput = document.querySelector("#amount");
  const categoryInput = document.querySelector("#category");
  const descriptionInput = document.querySelector("#description");
  const currencyInput = document.querySelector("#currency");

  const date = dateInput.value;
  const amount = parseFloat(amountInput.value);
  const category = categoryInput.value;
  const description = descriptionInput.value;
  const currency = currencyInput.value;

  console.log("Date:", date);
  console.log("Amount:", amount);
  console.log("Category:", category);
  console.log("Description:", description);
  console.log("Currency:", currency);

  if (!date || !amount || !category || !description || !currency) {
    showError("Заполните все поля!");
    return;
  }

  if (isNaN(amount)) {
    showError("Некорректная сумма!");
    return;
  }

  showLoading();

  const transaction = createTransaction(
    date,
    amount,
    category,
    description,
    currency
  );
  transactions.push(transaction);
  renderTransactionsTable();
  calculateTotal();
  hideLoading();
  hideError();

  // Очистка полей формы после добавления транзакции
  dateInput.value = "";
  amountInput.value = "";
  categoryInput.value = "";
  descriptionInput.value = "";
  currencyInput.value = "";
}

/**
 * Удаляет транзакцию по ID.
 * @param {number} id - ID транзакции для удаления.
 */
function deleteTransaction(id) {
  transactions = transactions.filter((transaction) => transaction.id !== id);
  renderTransactionsTable();
  calculateTotal();
}

/**
 * Рендерит таблицу транзакций.
 */
function renderTransactionsTable() {
  const tableBody = document.getElementById("transactions-table-body");
  tableBody.innerHTML = ""; // Очистка таблицы

  transactions.forEach((transaction) => {
    const row = tableBody.insertRow();

    const idCell = row.insertCell();
    idCell.textContent = transaction.id;

    const dateCell = row.insertCell();
    dateCell.textContent = transaction.date;

    const categoryCell = row.insertCell();
    categoryCell.textContent = transaction.category;

    const descriptionCell = row.insertCell();
    descriptionCell.textContent = transaction.description.substring(0, 4); // Отображение первых 4 слов

    const actionCell = row.insertCell();
    const deleteButton = document.createElement("button");
    deleteButton.textContent = "Удалить";
    deleteButton.addEventListener("click", () =>
      deleteTransaction(transaction.id)
    );
    actionCell.appendChild(deleteButton);

    row.classList.add(transaction.amount > 0 ? "green-row" : "red-row"); // Цвет строки
  });
}

/**
 * Вычисляет общую сумму транзакций.
 */
function calculateTotal() {
  let total = 0;
  transactions.forEach((transaction) => {
    total += transaction.amount;
  });

  document.getElementById("total-amount").textContent = total.toFixed(2);
}

/**
 * Отображает полное описание транзакции.
 * @param {Object} transaction - Объект транзакции.
 */
function showTransactionDetails(transaction) {
  document.getElementById("transaction-description").textContent =
    transaction.description;
  // ... (добавьте отображение других данных транзакции)
}

/**
 * Обработчик события клика на строку таблицы.
 * @param {Event} event - Событие клика.
 */
document
  .getElementById("transactions-table")
  .addEventListener("click", function (event) {
    if (event.target.tagName === "TR") {
      // Клик на строку
      const id = event.target.children[0].textContent; // Получение ID транзакции
      const transaction = transactions.find(
        (transaction) => transaction.id === parseInt(id)
      );

      if (transaction) {
        showTransactionDetails(transaction);
      }
    }
  });

/**
 * Добавляет обработчик события для формы добавления транзакции.
 */
document
  .getElementById("add-transaction-form")
  .addEventListener("submit", function (event) {
    event.preventDefault();
    addTransaction();
  });

// Рендеринг таблицы при загрузке страницы
renderTransactionsTable();

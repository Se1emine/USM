import datetime
import os


# Функция проверки валидности даты
def validate_date(date_str):
    try:
        datetime.datetime.strptime(date_str, "%d.%m.%Y")
        date = datetime.datetime.strptime(date_str, "%d.%m.%Y")
        if date < datetime.datetime(2024, 1, 1) or date > datetime.datetime.now():
            return False
        else:
            return True
    except ValueError:
        return False


# Функция проверки валидности времени
def validate_time(time_str):
    try:
        datetime.datetime.strptime(time_str, "%H:%M")
        return True
    except ValueError:
        return False


# Функция проверки валидности типа операции
def validate_operation_type(operation_type):
    return operation_type.lower() in ["доход", "расход"]


# Функция записи транзакции в файл
def write_transaction(transaction_data):
    with open("transactions.txt", "a") as file:
        file.write(
            f"{transaction_data['date']} {transaction_data['time']} {transaction_data['amount']} {transaction_data['operation_type']}\n"
        )


# Функция чтения транзакций из файла
def read_transactions():
    transactions = []
    with open("transactions.txt", "r") as file:
        for line in file:
            transaction_data = line.strip().split()
            if len(transaction_data) != 4:
                continue
            date, time, amount, operation_type = transaction_data
            if not (
                validate_date(date)
                and validate_time(time)
                and validate_operation_type(operation_type)
            ):
                continue
            transactions.append(
                {
                    "date": date,
                    "time": time,
                    "amount": float(amount),
                    "operation_type": operation_type,
                }
            )
    return transactions


# Функция расчета баланса
def calculate_balance():
    transactions = read_transactions()
    balance = 0
    for transaction in transactions:
        if transaction["operation_type"] == "доход":
            balance += transaction["amount"]
        else:
            balance -= transaction["amount"]
    return balance


# Функция поиска самой прибыльной транзакции
def find_most_profitable_transaction():
    transactions = read_transactions()
    most_profitable_transaction = None
    for transaction in transactions:
        if transaction["operation_type"] == "доход" and (
            most_profitable_transaction is None
            or transaction["amount"] > most_profitable_transaction["amount"]
        ):
            most_profitable_transaction = transaction
    return most_profitable_transaction


# Функция поиска самой убыточной транзакции
def find_most_unprofitable_transaction():
    transactions = read_transactions()
    most_unprofitable_transaction = None
    for transaction in transactions:
        if transaction["operation_type"] == "расход" and (
            most_unprofitable_transaction is None
            or transaction["amount"] > most_unprofitable_transaction["amount"]
        ):
            most_unprofitable_transaction = transaction
    return most_unprofitable_transaction


# Главная функция
def main():
    while True:
        print("\nМеню:")
        print("1. Записать транзакцию")
        print("2. Вывести текущий баланс")
        print("3. Вывести информацию о самой прибыльной транзакции")
        print("4. Вывести информацию о самой убыточной транзакции")
        print("5. Выход")

        choice = input("Введите ваш выбор: ")

        if choice == "1":
            # Запись транзакции
            while True:
                try:
                    date = input("Введите дату транзакции (дд.мм.гггг): ")
                    if validate_date(date):
                        break
                    else:
                        print("Неверный формат даты. Попробуйте снова.")
                except ValueError:
                    print("Неверный формат даты. Попробуйте снова.")

            while True:
                try:
                    time = input("Введите время транзакции (чч:мм): ")
                    if validate_time(time):
                        break
                    else:
                        print("Неверный формат времени. Попробуйте снова.")
                except ValueError:
                    print("Неверный формат времени. Попробуйте снова.")

            while True:
                try:
                    amount = float(input("Введите сумму транзакции: "))
                    if amount > 0:
                        break
                    else:
                        print("Сумма транзакции должна быть больше 0.")
                except ValueError:
                    print("Неверный формат суммы. Попробуйте снова.")

            operation_type = input("Введите тип операции (доход/расход): ").lower()
            if validate_operation_type(operation_type):
                write_transaction(
                    {
                        "date": date,
                        "time": time,
                        "amount": amount,
                        "operation_type": operation_type,
                    }
                )
                print("Транзакция успешно записана.")
            else:
                print("Неверный тип операции.")

        elif choice == "2":
            # Вывод текущего баланса
            balance = calculate_balance()
            print(f"Текущий баланс: {balance:.2f}")

        elif choice == "3":
            # Вывод информации о самой прибыльной транзакции
            transaction = find_most_profitable_transaction()
            if transaction is not None:
                print(f"Самая прибыльная транзакция:")
                print(f"Дата: {transaction['date']}")
                print(f"Время: {transaction['time']}")
                print(f"Сумма: {transaction['amount']:.2f}")
                print(f"Тип операции: {transaction['operation_type']}")
            else:
                print("Прибыльных транзакций не найдено.")

        elif choice == "4":
            # Вывод информации о самой убыточной транзакции
            transaction = find_most_unprofitable_transaction()
            if transaction is not None:
                print(f"Самая убыточная транзакция:")
                print(f"Дата: {transaction['date']}")
                print(f"Время: {transaction['time']}")
                print(f"Сумма: {transaction['amount']:.2f}")
                print(f"Тип операции: {transaction['operation_type']}")
            else:
                print("Убыточных транзакций не найдено.")

        elif choice == "5":
            # Выход
            print("Выход из программы.")
            break

        else:
            print("Неверный выбор. Попробуйте снова.")


if __name__ == "__main__":
    main()

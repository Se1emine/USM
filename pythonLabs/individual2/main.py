import functions as f


def main_menu():
    """
    Отображает главное меню и обрабатывает пользовательский ввод.
    """

    while True:
        print("\nГлавное меню:")
        print("1. Сгенерировать пароль")
        print("2. Просмотр пароля")
        print("3. Выход")

        choice = input("Введите свой выбор: ")

        if choice == "1":
            length = int(input("Введите желаемую длину пароля: "))
            include_lower = input("Включать строчные буквы (да/нет)? ").lower() == "да"
            include_upper = input("Включать прописные буквы (да/нет)? ").lower() == "да"
            include_numbers = input("Включать цифры (да/нет)? ").lower() == "да"
            include_symbols = input("Включать символы (да/нет)? ").lower() == "да"

            password = f.generate_password(
                length, include_lower, include_upper, include_numbers, include_symbols
            )
            purpose = input("Для чего вам нужен этот пароль? ")

            print(f"Ваш сгенерированный пароль: {password}")
            f.save_password(password, purpose)
            print("Пароль сохранен в passwords.txt.")

        elif choice == "2":
            purpose = input("Введите назначение пароля, который хотите посмотреть: ")
            f.view_password(purpose)

        elif choice == "3":
            break

        else:
            print("Неверный выбор. Пожалуйста, введите цифру от 1 до 3.")


main_menu()

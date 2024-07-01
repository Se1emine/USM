import functions as f


def menu():
    while True:
        print("\nМеню:")
        print("1. Ввод данных в файл")
        print("2. Просмотр данных о детях сотрудников")
        print("3. Поиск и вывод списка бездетных сотрудников")
        print("4. Выход из программы")
        choice = input("Выберите опцию (1-4): ")

        if choice == "1":
            f.input_data()
        elif choice == "2":
            f.display_data()
        elif choice == "3":
            f.display_childless_employees()
        elif choice == "4":
            print("Выход из программы.")
            break
        else:
            print("Неверный выбор. Попробуйте снова.")


menu()

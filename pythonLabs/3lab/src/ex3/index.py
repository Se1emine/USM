import functions as f

shopping_list = []

while True:
    print("\n Меню:")
    print("1. Вывести список покупок")
    print("2. Добавить товар")
    print("3. Удалить товар")
    print("4. Выход")

    choice = input("Введите номер опции: ")

    if choice == "1":
        f.show_shopping_list(shopping_list)
    elif choice == "2":
        shopping_list = f.add_product(shopping_list)
    elif choice == "3":
        while True:
            removal_method = input("Удалить по (индексу/названию): ").lower()
            if removal_method in ["индексу", "названию"]:
                break
            else:
                print("Неверный метод удаления. Доступно: индексу, названию")

        if removal_method == "индексу":
            shopping_list = f.remove_product_by_index(shopping_list)
        else:
            shopping_list = f.remove_product_by_name(shopping_list)
    elif choice == "4":
        break
    else:
        print("Неверная опция.")

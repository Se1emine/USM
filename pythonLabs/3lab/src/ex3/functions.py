def add_product(shopping_list):
    """
    Добавляет товар в список покупок.

    Args:
        shopping_list (list): Список покупок.

    Returns:
        list: Обновленный список покупок.
    """
    product = input("Введите название товара: ")
    shopping_list.append(product)
    return shopping_list


def remove_product_by_index(shopping_list):
    """
    Удаляет товар из списка покупок по индексу.

    Args:
        shopping_list (list): Список покупок.

    Returns:
        list: Обновленный список покупок.
    """
    if not shopping_list:
        print("Список пуст!")
        return shopping_list

    while True:
        try:
            index = int(input("Введите индекс товара (с 1): ")) - 1
            if 0 < index < len(shopping_list):
                break
            else:
                print("Неверный индекс. Попробуйте снова.")
        except ValueError:
            print("Введите число!")

    del shopping_list[index]
    print(f"Товар '{shopping_list[index]}' удален.")
    return shopping_list


def remove_product_by_name(shopping_list):
    """
    Удаляет товар из списка покупок по названию.

    Args:
        shopping_list (list): Список покупок.

    Returns:
        list: Обновленный список покупок.
    """
    if not shopping_list:
        print("Список пуст!")
        return shopping_list

    product_name = input("Введите название товара: ")
    if product_name in shopping_list:
        shopping_list.remove(product_name)
        print(f"Товар '{product_name}' удален.")
    else:
        print(f"Товар '{product_name}' не найден.")
    return shopping_list


def show_shopping_list(shopping_list):
    """
    Выводит список покупок.

    Args:
        shopping_list (list): Список покупок.
    """
    if not shopping_list:
        print("Список пуст!")
    else:
        print("Список покупок:")
        for index, product in enumerate(shopping_list):
            print(f"{index + 1}. {product}")

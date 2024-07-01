def user_input_message():
    """Запрашивает ввод пользователя и выводит сообщение."""
    user_value = int(input("Введите число: "))

    if user_value > 0:
        print("Вы ввели положительное число!")
    elif user_value == 0:
        print("Вы ввели ноль.")
    else:
        print("Вы ввели отрицательное число.")


user_input_message()

#
#
#
list_var = [1, 2, 3, 4, 2, 3, 2, 1, 4, 5]
dict_var = {"a": 1, "b": 2, "c": 3, "d": 2, "e": 1}

list_counter = {}
dict_counter = {}

# Проходимся по списку и увеличиваем счетчик для каждого значения
for item in list_var:
    if item in list_counter:
        list_counter[item] += 1
    else:
        list_counter[item] = 1

# Проходимся по словарю и увеличиваем счетчик для каждого значения
for value in dict_var.values():
    if value in dict_counter:
        dict_counter[value] += 1
    else:
        dict_counter[value] = 1


print("Результаты подсчета для списка:")
for key, value in list_counter.items():
    print(f"{key}: {value}")


print("\nРезультаты подсчета для словаря:")
for key, value in dict_counter.items():
    print(f"{key}: {value}")


#
#
#
def square(x):
    """Возводит число в квадрат."""
    return x * x


numbers = [1, 2, 3, 4, 5]
squared_numbers = list(map(lambda x: x * x, numbers))
print(squared_numbers)

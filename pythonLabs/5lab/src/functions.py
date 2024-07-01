import re


def input_data():
    while True:
        last_name = input("Введите фамилию сотрудника: ")
        first_name = input("Введите имя сотрудника: ")
        department = input("Введите отдел: ")
        children_count = input("Введите количество детей младше 18 лет: ")

        if (
            validate_name(last_name)
            and validate_name(first_name)
            and validate_department(department)
            and validate_children_count(children_count)
        ):
            with open("data.txt", "a") as file:
                file.write(
                    f"{last_name}\t{first_name}\t{department}\t{children_count}\n"
                )
            print("Данные успешно сохранены.")
            break
        else:
            print("Ошибка ввода данных. Попробуйте снова.")


def validate_name(name):
    pattern = re.compile(r"^[A-Za-zА-Яа-я-]{2,20}$")
    return bool(pattern.match(name))


def validate_department(department):
    pattern = re.compile(r"^[A-Za-zА-Яа-я0-9 ]+$")
    return bool(pattern.match(department))


def validate_children_count(count):
    pattern = re.compile(r"^([0-9]|1[0-9])$")
    return bool(pattern.match(count))


def display_data():
    try:
        with open("data.txt", "r") as file:
            lines = file.readlines()
            total_children = 0

            print("Данные о детях сотрудников:")
            for line in lines:
                data = line.strip().split("\t")
                last_name, first_name, department, children_count = data
                total_children += int(children_count)
                print(
                    f"{last_name} {first_name}, Отдел: {department}, Дети: {children_count}"
                )

            print(f"\nОбщее количество детей: {total_children}")
    except FileNotFoundError:
        print("Файл с данными не найден. Введите данные сначала.")


def display_childless_employees():
    try:
        with open("data.txt", "r") as file:
            lines = file.readlines()

            print("Сотрудники без детей:")
            for line in lines:
                data = line.strip().split("\t")
                last_name, first_name, department, children_count = data
                if int(children_count) == 0:
                    print(f"{last_name} {first_name}")
    except FileNotFoundError:
        print("Файл с данными не найден. Введите данные сначала.")

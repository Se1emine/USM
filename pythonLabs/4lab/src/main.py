import functions as f


def main():
    while True:
        try:
            age = int(input("Введите ваш возраст (в годах): "))
            height = int(input("Введите ваш рост (в см): "))
            gender = input("Введите ваш пол (М или Ж): ").strip()
            current_weight = float(input("Введите ваш текущий вес (в кг): "))

            if gender.upper() not in ["М", "Ж"]:
                print("Некорректный ввод пола. Пожалуйста, введите 'М' или 'Ж'.")
                continue

            if age < 25 or age > 60:
                print(
                    "Возраст вне диапазона 25-60 лет. Результаты могут быть менее точными."
                )

            ideal_weight_value = f.ideal_weight(age, height, gender)

            if ideal_weight_value is None:
                print("Некорректный ввод пола. Пожалуйста, введите 'М' или 'Ж'.")
                continue

            print(f"Ваш идеальный вес: {ideal_weight_value:.2f} кг")
            recommendation = f.weight_recommendation(current_weight, ideal_weight_value)
            print(recommendation)
            break

        except ValueError:
            print(
                "Ошибка ввода. Пожалуйста, введите числовые значения для возраста, роста и веса."
            )
        except Exception as e:
            print(f"Произошла ошибка: {e}")


main()


# nmbr_list = [1, 5, 7, 7, 8, 2, 3, 5, 6, 43]
# new_list = list(filter(lambda x: (x % 2 == 0), nmbr_list))
# print(new_list)

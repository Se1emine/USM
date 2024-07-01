import datetime
import calendar

while True:
    try:
        birth_date_str = input("Введите дату рождения (ГГГГ-ММ-ДД): ")
        birth_date = datetime.datetime.strptime(birth_date_str, "%Y-%m-%d")
        break
    except ValueError:
        print("Некорректный формат даты. Пожалуйста, используйте формат ГГГГ-ММ-ДД.")

if birth_date > datetime.date.today():
    print("Дата рождения не может быть в будущем.")
    exit()

days_lived = (datetime.date.today() - birth_date).days
print(f"Вам {days_lived} дней.")

import calendar


year = int(input("Введите год: "))
month = int(input("Введите месяц (1-12): "))
day = int(input("Введите день: "))
weekday_number = calendar.weekday(year, month, day)
day_name = {
    0: "Понедельник",
    1: "Вторник",
    2: "Среда",
    3: "Четверг",
    4: "Пятница",
    5: "Суббота",
    6: "Воскресенье",
}

day_of_week = day_name[weekday_number]

print(f"{day}.{month}.{year} - {day_of_week}")

import re

code_pattern = "^MD\d{4}$"
cond = False
while cond == False:
    code = input("Input your postal code... \n")
    if re.match(code_pattern, code):
        print("You have entered a correct code -", code)
        cond = True
    else:
        print("You have entered an incorrect code...")
        cond = False

# Результат выполнения скрипта:
#
# 1. Ввод кода "MD1234":
# Цикл while выполняется один раз.
# Введенный код "MD1234" соответствует шаблону code_pattern.
# Печатается сообщение "Вы ввели правильный код - MD1234".
# Цикл while завершается.
#
# 2. Ввод кода "AB1234":
# Цикл while выполняется несколько раз.
# Введенный код "AB1234" не соответствует шаблону code_pattern.
# Печатается сообщение "Вы ввели неправильный код...".
# Пользователь снова вводит код, пока не введет правильный код.

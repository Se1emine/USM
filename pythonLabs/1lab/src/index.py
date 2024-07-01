# приветствие
name = input("Введите ваше имя: ")
print("Привет,", name + "!")

# определение переменных
integer_value = 10
float_value = 3.14
short_text = "abcdefghsad"
long_text = """
Это многострочный текст.
Он занимает несколько строк.
"""

# вывод типов
print(type(integer_value),end=",") 
print(type(short_text),end=",")    
print(type(long_text))


# подсчет длины
print(len(long_text))

# работа с текстом
upper_case_text = long_text.upper()
print(upper_case_text)

# отрезание подстроки
substring = short_text[0:4]
print(substring)
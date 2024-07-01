my_list = [2, 3, 4, 5, 6, 7]
#
print(my_list[0])
print(my_list[2])
#
my_list[4] = 6
print(my_list)
#
print(my_list[:3])
#
# 3 метода
my_list.append(50)
print(my_list)
#
my_list.remove(50)
print(my_list)
#
my_list.sort(reverse=True)
print(my_list)
#
# 2 функции
list_length = len(my_list)
print(list_length)
#
sorted_list = sorted(my_list, reverse=True)
print(sorted_list)
#
#
#
my_tuple = ("Яблоко", "Банан", "Вишня")
#
print(type(my_tuple))
#
print(my_tuple[0])
print(my_tuple[-1])
#
#
sliced_tuple = my_tuple[1:3]
print(sliced_tuple)
#
len(my_tuple)
my_tuple.count("Яблоко")
print(list(my_tuple))
#
#
#
my_set = {"Яблоко", "Банан", "Вишня", "Яблоко", "Вишня"}
#
print(my_set)
# методы
#
my_set.add("Апельсин")
my_set.remove("Вишня")
print(my_set)
# функция
#
print("Банан" in my_set)
#
#
#
text_dict = {"фрукт": "Яблоко", "овощ": "Морковь"}
#
number_dict = {1: "Один", 2: "Два"}
#
print(text_dict["фрукт"])  # Выведет: "Яблоко"
print(number_dict[2])  # Выведет: "Два"
#
x = text_dict["фрукт"]
print(x)
#
print(text_dict.keys())
print(text_dict.values())
print(text_dict.items())

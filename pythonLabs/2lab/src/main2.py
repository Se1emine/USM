#
prices = [100, 50, 20]

product_names = ["Книга", "Ручка", "Яблоко"]

for i in range(len(prices)):
    product_info = f"{product_names[i]}: {prices[i]} руб."
    print(product_info)
#
#
#
age = input("пж, введите ваш возраст (целое число): ")

age = int(age)

future_age = age + 5

print("через 5 лет вам будет " + str(future_age) + " лет.")
#
#
#
nmbrs = [1, 2, 3, 4, 5]
if 3 in nmbrs:
    print("число 3 находится в списке nmbrs.")
else:
    print("число 3 не находится в списке nmbrs.")

# A
i = sum = 0
while i <= 4:
    sum += i
    i = i + 1
print(sum)
# B
for char in "PYTHON STRING":
    if char == " ":
        break
    print(char, end="")
    if char == "O":
        continue
    print("*", end="")

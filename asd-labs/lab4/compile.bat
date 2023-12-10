REM Компилируем dynamicArray.cpp
g++ -c dynamicArray.cpp -o dynamicArray.o

REM Компилируем main.cpp
g++ -c main.cpp -o main.o

REM Линкуем объектные файлы вместе
g++ dynamicArray.o main.o -o my_program
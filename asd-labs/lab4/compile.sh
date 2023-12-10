#!/bin/bash

# Компилируем dynamicArray.cpp
g++ -c dynamicArray.cpp -o dynamicArray.o

# Компилируем main.cpp
g++ -c main.cpp -o main.o

# Линкуем объектные файлы вместе
g++ dynamicArray.o main.o -o main
#include <iostream>

using namespace std;

int main() {

    int i = 69;
    int number = 72;
    i = i + number;

    int array[3] = {0};
    int* iPointer = &i;
    number = *iPointer;
    *iPointer = 15;

    iPointer = &array[0];
    iPointer = iPointer + 2;

    array[0] = 5;
    *iPointer = 6;

    cout << "i: " << i << endl;
    cout << "number: " << number << endl;
    cout << "Array: " << array[0] << ", " << array[1] << ", " << array[2] << endl;

    return 0;

    /*В этом коде переменные i и number были инициализированы и изменены по заданию. 
    Массив array был использован для работы с указателями и адресацией в памяти. 
    В конце программы выводятся результаты для переменных i, number и элементов массива array.*/
}

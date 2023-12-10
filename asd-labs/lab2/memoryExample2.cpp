#include <stdlib.h>
#include <iostream>
#include <cstring>

using namespace std;

struct TwoInts
{
    int a;
    int b;
};

struct StructWithArray
{
    int arr[4];
    int* someNumber;
};

int main()
{
    TwoInts i2 = {};
    i2.a = 5;
    i2.b = 7;
    cout << i2.a << endl;
    cout << i2.b << endl;

    StructWithArray s = {};
    s.arr[0] = 10;

    StructWithArray s1 = {};
    s1.arr[0] = 15;

    StructWithArray* sPointer = &s;
    sPointer->arr[0] = 20;
    cout << s.arr[0] << endl;

    s.arr[0] = 25;
    cout << s.arr[0] << endl;

    sPointer->arr[0] = 30;
    cout << s.arr[0] << endl;

    sPointer = &s1;
    sPointer->arr[0] = 35;
    cout << sPointer->arr[0] << endl;
    cout << s1.arr[0] << endl;

    StructWithArray structArray[2] = {};
    structArray[0].arr[1] = 77;
    structArray[1].someNumber = &structArray[0].arr[0];

    sPointer = &s;
    int* pointer = &sPointer->arr[1];
    s.arr[1] = 72;
    cout << *pointer;

    StructWithArray memory;
    memset(&memory, 0, sizeof(StructWithArray));

    return 0;
    /* Этот код на C++ создает и манипулирует экземплярами структур, используя указатели и массивы. 
    Сначала определены структуры TwoInts и StructWithArray, представляющие два целых числа и 
    массив с указателем соответственно. В main() создаются экземпляры этих структур, и
    нициализируются и изменяются их значения. Используются указатели для доступа к 
    элементам массивов и передачи адресов в памяти. Кроме того, демонстрируется работа с 
    массивом структур и заполнение экземпляра структуры StructWithArray нулями с помощью memset. 
    Код также выводит результаты операций на консоль, и, наконец, завершается возвращением 0. s*/
}
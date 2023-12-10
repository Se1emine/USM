#include <iostream>
#include <cstdlib>
#include <ctime>
#include <chrono>
#include <algorithm>

// Функция для выделения динамического буфера и заполнения случайными числами
int* generateRandomArray(int size) {
    int* arr = new int[size];
    for (int i = 0; i < size; ++i) {
        arr[i] = rand();
    }
    return arr;
}

// Функция для измерения времени выполнения алгоритма для сортировки
template<typename Func>
int measureExecutionTime(Func func, int* arr, int size) {
    auto start = std::chrono::high_resolution_clock::now();
    func(arr, size);
    auto end = std::chrono::high_resolution_clock::now();
    return std::chrono::duration_cast<std::chrono::microseconds>(end - start).count();
}

// Функция для измерения времени выполнения алгоритма для бинарного поиска
template<typename Func>
int measureExecutionTime(Func func, int* arr, int size, int target) {
    auto start = std::chrono::high_resolution_clock::now();
    func(arr, size, target);
    auto end = std::chrono::high_resolution_clock::now();
    return std::chrono::duration_cast<std::chrono::microseconds>(end - start).count();
}

// Пример алгоритма сортировки: Bubble Sort
void bubbleSort(int* arr, int size) {
    for (int i = 0; i < size - 1; ++i) {
        for (int j = 0; j < size - i - 1; ++j) {
            if (arr[j] > arr[j + 1]) {
                std::swap(arr[j], arr[j + 1]);
            }
        }
    }
}

// Пример алгоритма поиска: Binary Search
int binarySearch(int* arr, int size, int target) {
    int left = 0, right = size - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1; // элемент не найден
}

int main() {
    using namespace std;

    // Устанавливаем seed для генератора случайных чисел
    srand(time(0));

    const int testSizes[] = {1000, 5000, 10000}; // Размеры массивов для тестирования

    for (int size : testSizes) {
        int* sortedArray = generateRandomArray(size);
        sort(sortedArray, sortedArray + size); // Отсортированный массив

        int* reverseSortedArray = generateRandomArray(size);
        sort(reverseSortedArray, reverseSortedArray + size, greater<int>()); // Обратно отсортированный массив

        int* randomArray = generateRandomArray(size); // Случайный порядок элементов

        // Тестирование сортировки
        cout << "Array size: " << size << "\n";
        cout << "Bubble Sort - Random Order: " << measureExecutionTime(bubbleSort, randomArray, size) << " microseconds\n";
        cout << "Bubble Sort - Sorted Order: " << measureExecutionTime(bubbleSort, sortedArray, size) << " microseconds\n";
        cout << "Bubble Sort - Reverse Sorted Order: " << measureExecutionTime(bubbleSort, reverseSortedArray, size) << " microseconds\n";

        // Тестирование бинарного поиска
        int target = randomArray[size / 2]; // Целевой элемент для поиска
        cout << "Binary Search - Random Order: " << measureExecutionTime(binarySearch, randomArray, size, target) << " microseconds\n";
        cout << "Binary Search - Sorted Order: " << measureExecutionTime(binarySearch, sortedArray, size, target) << " microseconds\n";
        cout << "Binary Search - Reverse Sorted Order: " << measureExecutionTime(binarySearch, reverseSortedArray, size, target) << " microseconds\n";

        // Освобождаем выделенную память
        delete[] sortedArray;
        delete[] reverseSortedArray;
        delete[] randomArray;
    }

    return 0;
}

#include <iostream>

using namespace std;

int main() {
    int n;

    // Введите размер матрицы
    cout << "Введите размер матрицы (n): ";
    cin >> n;

    // Инициализация матриц
    int matrix1[n][n], matrix2[n][n], result[n][n];

    // Ввод первой матрицы
    cout << "Введите элементы первой матрицы:" << endl;
    for (int i = 0; i < n; ++i)
        for (int j = 0; j < n; ++j) {
            cout << "Введите элемент matrix1[" << i + 1 << "][" << j + 1 << "]: ";
            cin >> matrix1[i][j];
        }

    // Ввод второй матрицы
    cout << "Введите элементы второй матрицы:" << endl;
    for (int i = 0; i < n; ++i)
        for (int j = 0; j < n; ++j) {
            cout << "Введите элемент matrix2[" << i + 1 << "][" << j + 1 << "]: ";
            cin >> matrix2[i][j];
        }

    // Умножение матриц
    for (int i = 0; i < n; ++i)
        for (int j = 0; j < n; ++j) {
            result[i][j] = 0;
            for (int k = 0; k < n; ++k)
                result[i][j] += matrix1[i][k] * matrix2[k][j];
        }

    // Вывод результата
    cout << "Результат умножения матриц:" << endl;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j)
            cout << result[i][j] << " ";
        cout << endl;
    }

    return 0;
}
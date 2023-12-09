// написать программу на c++ для табулирования функции 
// на заданном промежутке с заданным шагом: 
// y = x^2 - cos^2(πx)  с интервалом [1;3]

#include <iostream>
#include <cmath>

using namespace std;

int main() {

    cout << "x\t|\ty" << endl;
    cout << "----------------" << endl;

    // табулируем функцию и выводим результаты
    for (double x = 1.0; x <= 3.0; x += 0.1) {
        double y = pow(x, 2) - pow(cos(M_PI * x), 2);
        cout << x << "\t|\t" << y << endl;
    }

    return 0;
}


#include <iostream>

class Side {
public:
    double sideLength;
    Side(double length) {
        sideLength = length;
    }
};

class Square : public Side {
public:
    Square(double length) : Side(length) {}

    double calculateArea() {
        return sideLength * sideLength;
    }
};

class Aquarium : public Square {
public:
    double height;

    Aquarium(double length, double h) : Square(length) {
        height = h;
    }

    double calculateVolume() {
        return calculateArea() * height;
    }

    int calculateFishCount() {
        return calculateVolume() / 20;
    }

    void displayCharacteristics() {
        std::cout << "характеристики аквариума:" << std::endl;
        std::cout << "длина стороны: " << sideLength << std::endl;
        std::cout << "высота: " << height << std::endl;
        std::cout << "обьем: " << calculateVolume() << std::endl;
        std::cout << "кол-во рыбок: " << calculateFishCount() << std::endl;
    }
};

int main() {
    double length1, height1, length2, height2;

    std::cout << "введите длину и высоту стороны для первого аквариума: ";
    std::cin >> length1 >> height1;
    Aquarium aquarium1(length1, height1);

    std::cout << "введите длину и высоту стороны для второго аквариума: ";
    std::cin >> length2 >> height2;
    Aquarium aquarium2(length2, height2);

    aquarium1.displayCharacteristics();
    std::cout << std::endl;
    aquarium2.displayCharacteristics();
    std::cout << std::endl;

    if (aquarium1.calculateFishCount() > aquarium2.calculateFishCount()) {
        std::cout << "первый аквариум поместит больше рыб" << std::endl;
    } else if (aquarium1.calculateFishCount() < aquarium2.calculateFishCount()) {
        std::cout << "второй аквариум поместит больше рыб" << std::endl;
    } else {
        std::cout << "оба аквариума поместят равное кол-во рыб" << std::endl;
    }

    return 0;
}

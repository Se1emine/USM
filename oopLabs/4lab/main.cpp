#include <iostream>
#include <vector>
#include <string>

template <typename T>
class List {
private:
    std::vector<T> elements;

public:
    List() {}

    void insert(T element) {
        elements.push_back(element);
    }

    void print() {
        for (int i = 0; i < elements.size(); i++) {
            std::cout << elements[i] << " ";
        }
        std::cout << std::endl;
    }

    bool operator==(List<T>& other) {
        if (elements.size() != other.elements.size()) {
            return false;
        }
        for (int i = 0; i < elements.size(); i++) {
            if (elements[i] != other.elements[i]) {
                return false;
            }
        }
        return true;
    }

    bool operator!=(List<T>& other) {
        return !(*this == other);
    }
};

int main() {
    List<std::string> strList;
    strList.insert("hello");
    strList.insert("world");
    strList.insert("!");

    strList.print();

    List<std::string> anotherList;
    anotherList.insert("hello");
    anotherList.insert("world");
    anotherList.insert("!");

    if (strList == anotherList) {
        std::cout << "списки равны" << std::endl;
    } else {
        std::cout << "списки не равны" << std::endl;
    }

    return 0;
}

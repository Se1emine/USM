#include <iostream>
#include <vector>
#include <string>
#include <set>

class StringArray {
private:
    std::vector<std::string> strings;

public:
    StringArray() {}

    void addString(const char* str) {
        strings.push_back(std::string(str));
    }

    const char* getString(int index) {
        if (index < 0 || index >= strings.size()) {
            std::cerr << "индекс вне диапазона" << std::endl;
            return nullptr;
        }
        return strings[index].c_str();
    }

    static StringArray concatenate(StringArray& arr1, StringArray& arr2) {
        if (arr1.strings.size() != arr2.strings.size()) {
            std::cerr << "массивы должны быть одинаковой длины для по буквенного объединения" << std::endl;
            return StringArray();
        }

        StringArray result;
        for (int i = 0; i < arr1.strings.size(); i++) {
            std::string concatenated = arr1.strings[i] + arr2.strings[i];
            result.addString(concatenated.c_str());
        }
        return result;
    }

    static StringArray merge(StringArray& arr1, StringArray& arr2) {
        StringArray result;
        std::set<std::string> uniqueStrings;

        for (int i = 0; i < arr1.strings.size(); i++) {
            uniqueStrings.insert(arr1.strings[i]);
        }
        for (int i = 0; i < arr2.strings.size(); i++) {
            uniqueStrings.insert(arr2.strings[i]);
        }

        for (auto it = uniqueStrings.begin(); it != uniqueStrings.end(); ++it) {
            result.addString(it->c_str());
        }
        return result;
    }

    void printString(int index) {
        if (index < 0 || index >= strings.size()) {
            std::cerr << "индекс вне диапазона" << std::endl;
            return;
        }
        std::cout << strings[index] << std::endl;
    }

    void printArray() {
        for (int i = 0; i < strings.size(); i++) {
            std::cout << strings[i] << std::endl;
        }
    }
};

int main() {
    StringArray arr1;
    arr1.addString("hello");
    arr1.addString("world");

    StringArray arr2;
    arr2.addString("usm");
    arr2.addString("mern");

    StringArray concatenated = StringArray::concatenate(arr1, arr2);
    concatenated.printArray();

    StringArray merged = StringArray::merge(arr1, arr2);
    merged.printArray();

    return 0;
}

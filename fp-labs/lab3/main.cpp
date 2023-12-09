#include <iostream>
#include <string>

using namespace std;

int main() {
    // Вводим предложение
    cout << "Введите предложение: ";
    string inputSentence;
    getline(cin, inputSentence);

    // Инвертируем предложение
    string invertedSentence;
    for (int i = inputSentence.length() - 1; i >= 0; --i) {
        invertedSentence += inputSentence[i];
    }

    // Выводим инвертированное предложение
    cout << "Инвертированное предложение: " << invertedSentence << endl;

    return 0;
}
#include <iostream>

using namespace std;

int hello(int val) {
    return val + 2;
}

int main() {
    int result = hello(7);
    cout << "Result: " << result << endl;
    return 0;
}

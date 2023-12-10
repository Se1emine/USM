#include <iostream>

using namespace std;

static int hello(int x) {
    return x + 2;
}

int main() {
    int result = hello(7);
    cout << "Result: " << result << endl;
    return 0;
}


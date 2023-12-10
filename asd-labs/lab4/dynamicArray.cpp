#include "dynamicArray.h"
#include <algorithm>

namespace {

void resizeBuffer(DynamicArray* arr, size_t newCapacity) {
    int* newBuffer = new int[newCapacity];
    std::copy(arr->buffer, arr->buffer + arr->length, newBuffer);
    delete[] arr->buffer;
    arr->buffer = newBuffer;
    arr->capacity = newCapacity;
}

} 

DynamicArray createDynamicArrayWithCapacity(size_t capacity) {
    DynamicArray arr;
    arr.buffer = new int[capacity];
    arr.capacity = capacity;
    arr.length = 0;
    return arr;
}

DynamicArray createDynamicArray() {
    return createDynamicArrayWithCapacity(4); 
}

void addElementToArray(DynamicArray* arr, int value) {
    if (arr->length == arr->capacity) {
        size_t newCapacity = arr->capacity * 2;
        resizeBuffer(arr, newCapacity);
    }
    arr->buffer[arr->length++] = value;
}

int getElementAtIndex(const DynamicArray* arr, size_t index) {
    assert(index < arr->length);
    return arr->buffer[index];
}

void getCurrentSpan(const DynamicArray* arr, int*& data, size_t& size) {
    data = arr->buffer;
    size = arr->length;
}

void clearDynamicArray(DynamicArray* arr) {
    delete[] arr->buffer;
    arr->buffer = nullptr;
    arr->capacity = 0;
    arr->length = 0;
}
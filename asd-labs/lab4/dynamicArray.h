// dynamicArray.h

#ifndef DYNAMIC_ARRAY_H
#define DYNAMIC_ARRAY_H

#include <cstddef>
#include <cassert>

struct DynamicArray {
    int* buffer;
    size_t capacity;
    size_t length;
};

DynamicArray createDynamicArrayWithCapacity(size_t capacity);
DynamicArray createDynamicArray();
void addElementToArray(DynamicArray* arr, int value);
int getElementAtIndex(const DynamicArray* arr, size_t index);
void getCurrentSpan(const DynamicArray* arr, int*& data, size_t& size);
void clearDynamicArray(DynamicArray* arr);

#endif // DYNAMIC_ARRAY_H

package com.dominikcebula.data.structures.heap;

import com.dominikcebula.data.structures.stack.Stack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Heap<T extends Comparable<T>> {
    private final Class<T> elementClass;

    private T[] elements;
    private int size;

    public Heap(Class<T> elementClass, int capacity) {
        this.elementClass = elementClass;
        if (capacity <= 0)
            throw new IllegalArgumentException("Heap capacity needs to be greater than zero.");

        elements = (T[]) Array.newInstance(elementClass, capacity);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T element) {
        ensureCapacity();
        elements[size] = element;
        ++size;
        heapifyUp();
    }

    public T peek() {
        if (size > 0)
            return elements[0];
        else
            return null;
    }

    public T pop() {
        return elements[0];
    }

    public T[] toArray() {
        T[] array = (T[]) Array.newInstance(elementClass, size);

        if (isEmpty())
            return array;

        Stack<Integer> heapIndexes = new Stack<>();
        heapIndexes.push(0);
        int currentArrayIndex = 0;

        while (!heapIndexes.isEmpty()) {
            Integer currentHeapIndex = heapIndexes.pop();

            array[currentArrayIndex++] = getValue(currentHeapIndex);

            if (hasLeftChild(currentArrayIndex))
                heapIndexes.push(getLeftChildIndex(currentHeapIndex));
            if (hasRightChild(currentArrayIndex))
                heapIndexes.push(getRightChildIndex(currentHeapIndex));
        }

        return array;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    private void heapifyUp() {
        int currentIndex = size - 1;

        while (hasParent(currentIndex) && getParentValue(currentIndex).compareTo(getValue(currentIndex)) > 0) {
            swap(currentIndex, getParentIndex(currentIndex));

            currentIndex = getParentIndex(currentIndex);
        }
    }

    private void heapifyDown() {

    }

    private void swap(int indexOne, int indexTwo) {
        T value = elements[indexOne];
        elements[indexOne] = elements[indexTwo];
        elements[indexTwo] = value;
    }

    private T getValue(int currentIndex) {
        return elements[currentIndex];
    }

    private T getParentValue(int currentIndex) {
        if (hasParent(currentIndex))
            return elements[getParentIndex(currentIndex)];
        else
            return null;
    }

    private boolean hasParent(int currentIndex) {
        return getParentIndex(currentIndex) >= 0;
    }

    private int getParentIndex(int currentIndex) {
        return (currentIndex - 1) / 2;
    }

    private T getLeftChildValue(int currentIndex) {
        if (hasLeftChild(currentIndex))
            return elements[getLeftChildIndex(currentIndex)];
        else
            return null;
    }

    private boolean hasLeftChild(int currentIndex) {
        return getLeftChildIndex(currentIndex) < size;
    }

    private int getLeftChildIndex(int currentIndex) {
        return (currentIndex * 2) + 1;
    }

    private T getRightChildValue(int currentIndex) {
        if (hasRightChild(currentIndex))
            return elements[getRightChildIndex(currentIndex)];
        else
            return null;
    }

    private boolean hasRightChild(int currentIndex) {
        return getRightChildIndex(currentIndex) < size;
    }

    private int getRightChildIndex(int currentIndex) {
        return (currentIndex * 2) + 2;
    }
}

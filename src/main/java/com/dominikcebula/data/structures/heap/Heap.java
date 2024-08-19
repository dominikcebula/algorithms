package com.dominikcebula.data.structures.heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Heap<T> {
    private T[] elements;
    private int size;

    public Heap(Class<T> elementClass, int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Heap capacity needs to be greater than zero.");

        elements = (T[]) Array.newInstance(elementClass, capacity);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T element) {
        elements[size] = element;
        ++size;
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

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    private void heapifyUp() {

    }

    private void heapifyDown() {

    }

    private void swap(int indexOne, int indexTwo) {
        T value = elements[indexOne];
        elements[indexOne] = elements[indexTwo];
        elements[indexTwo] = value;
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

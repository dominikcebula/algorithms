package com.dominikcebula.data.structures.heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Heap<T> {
    private T[] elements;
    private int size;

    public Heap(Class<T> elementClass, int capacity) {
        elements = (T[]) Array.newInstance(elementClass, capacity);
    }

    public T peek() {
        return null;
    }

    public T pop() {
        return null;
    }

    public void add(T element) {

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

    private void swap() {

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

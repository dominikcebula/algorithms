package com.dominikcebula.data.structures.tree;

import java.lang.reflect.Array;

public class BinarySearchTree<T extends Comparable<T>> {
    private final Class<T> elementClass;

    private Node<T> root;
    private int size;

    public BinarySearchTree(Class<T> elementClass) {
        this.elementClass = elementClass;
    }

    public void add(T value) {
        if (root == null)
            root = new Node<>(value);

        ++size;
    }

    public T[] toArray() {
        T[] array = (T[]) Array.newInstance(elementClass, size);

        array[0] = root.getValue();

        return array;
    }

    private static class Node<T> {
        private final T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }
}

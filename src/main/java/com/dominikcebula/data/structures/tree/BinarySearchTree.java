package com.dominikcebula.data.structures.tree;

import com.dominikcebula.data.structures.list.LinkedList;

import java.lang.reflect.Array;

public class BinarySearchTree<T extends Comparable<T>> {
    private final Class<T> elementClass;

    private Node<T> root;
    private int size;

    public BinarySearchTree(Class<T> elementClass) {
        this.elementClass = elementClass;
    }

    public void add(T value) {
        if (root == null) {
            root = new Node<>(value);
        } else {
            Node<T> parentNodeToInsertValue = findParentNodeToInsertValue(value);

            if (value.compareTo(parentNodeToInsertValue.getValue()) < 0)
                parentNodeToInsertValue.setLeft(new Node<>(value));
            else
                parentNodeToInsertValue.setRight(new Node<>(value));
        }

        ++size;
    }

    public T[] toArray() {
        T[] array = (T[]) Array.newInstance(elementClass, size);

        if (size == 0)
            return array;

        int arrayIndex = 0;

        LinkedList<Node<T>> nodesStack = new LinkedList<>((Class<Node<T>>) root.getClass());
        nodesStack.addLast(root);

        while (!nodesStack.isEmpty()) {
            Node<T> currentNode = nodesStack.getFirst();
            nodesStack.removeFirst();

            array[arrayIndex++] = currentNode.getValue();

            if (currentNode.hasLeft())
                nodesStack.addLast(currentNode.getLeft());
            if (currentNode.hasRight())
                nodesStack.addLast(currentNode.getRight());
        }

        return array;
    }

    private Node<T> findParentNodeToInsertValue(T value) {
        Node<T> currentNode = root;
        Node<T> parentNode = currentNode;

        while (currentNode != null) {
            parentNode = currentNode;
            if (value.compareTo(currentNode.getValue()) < 0)
                currentNode = currentNode.getLeft();
            else
                currentNode = currentNode.getRight();
        }

        return parentNode;
    }

    private static class Node<T extends Comparable<T>> {
        private final T value;
        private Node<T> left;
        private Node<T> right;

        Node(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }

        boolean hasLeft() {
            return left != null;
        }

        Node<T> getLeft() {
            return left;
        }

        void setLeft(Node<T> left) {
            this.left = left;
        }

        boolean hasRight() {
            return right != null;
        }

        Node<T> getRight() {
            return right;
        }

        void setRight(Node<T> right) {
            this.right = right;
        }
    }
}

package com.dominikcebula.data.structures.list;

import java.lang.reflect.Array;

public class LinkedList<T> {

    private final Class<T> elementClass;
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList(Class<T> elementClass) {
        this.elementClass = elementClass;
    }

    public void addFirst(T element) {
        if (head == null) {
            head = tail = new Node<>(element);
        } else {
            Node<T> newNode = new Node<>(element);
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }

        ++size;
    }

    public void addLast(T element) {
        if (tail == null) {
            head = tail = new Node<>(element);
        } else {
            Node<T> newNode = new Node<>(element);
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }

        ++size;
    }

    public void removeFirst() {
        if (!isEmpty()) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null;
            }

            --size;
        }
    }

    public void removeLast() {
        if (!isEmpty()) {
            tail = tail.getPrev();
            if (tail != null) {
                tail.setNext(null);
            } else {
                head = null;
            }

            --size;
        }
    }

    public T getFirst() {
        if (isEmpty())
            return null;
        else
            return head.getElement();
    }

    public T getLast() {
        if (isEmpty())
            return null;
        else
            return tail.getElement();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T[] toArray() {
        T[] array = (T[]) Array.newInstance(elementClass, size);

        Node<T> currentNode = head;
        int currentIndex = 0;

        while (currentNode != null) {
            array[currentIndex++] = currentNode.getElement();
            currentNode = currentNode.getNext();
        }

        return array;
    }

    private static class Node<T> {
        private final T element;
        private Node<T> prev;
        private Node<T> next;

        private Node(T element) {
            this.element = element;
        }

        private T getElement() {
            return element;
        }

        private Node<T> getPrev() {
            return prev;
        }

        private void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        private Node<T> getNext() {
            return next;
        }

        private void setNext(Node<T> next) {
            this.next = next;
        }
    }
}

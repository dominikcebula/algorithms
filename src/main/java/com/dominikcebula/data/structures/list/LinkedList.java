package com.dominikcebula.data.structures.list;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public void addFirst(T element) {

    }

    public void addLast(T element) {

    }

    public void removeFirst() {

    }

    public void removeLast() {

    }

    public T getFirst() {
        return null;
    }

    public T getLast() {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    public T[] toArray() {
        return null;
    }

    private record Node<T>(T element, Node<T> prev, Node<T> next) {
    }
}

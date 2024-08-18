package com.dominikcebula.data.structures.stack;

public class Stack<T> {
    private Node<T> topNode;

    public T peek() {
        if (topNode != null)
            return topNode.getElement();
        else
            return null;
    }

    public T pop() {
        if (topNode != null) {
            T topElement = topNode.getElement();
            topNode = topNode.getNext();
            return topElement;
        } else
            return null;
    }

    public void push(T element) {
        if (topNode == null)
            topNode = new Node<>(element);
        else {
            Node<T> newNode = new Node<>(element);
            newNode.setNext(topNode);
            topNode = newNode;
        }
    }

    public boolean isEmpty() {
        return topNode != null;
    }

    private static final class Node<T> {
        private final T element;
        private Node<T> next;

        Node(T element) {
            this.element = element;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}

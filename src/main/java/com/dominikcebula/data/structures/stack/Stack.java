package com.dominikcebula.data.structures.stack;

public class Stack<T> {
    private StackElement<T> topStackElement;

    public T peek() {
        if (topStackElement != null)
            return topStackElement.getValue();
        else
            return null;
    }

    public T pop() {
        if (topStackElement != null) {
            T topElement = topStackElement.getValue();
            topStackElement = topStackElement.getNext();
            return topElement;
        } else
            return null;
    }

    public void push(T element) {
        if (topStackElement == null)
            topStackElement = new StackElement<>(element);
        else {
            StackElement<T> newStackElement = new StackElement<>(element);
            newStackElement.setNext(topStackElement);
            topStackElement = newStackElement;
        }
    }

    public boolean isEmpty() {
        return topStackElement == null;
    }

    private static class StackElement<T> {
        private final T value;
        private StackElement<T> next;

        private StackElement(T value) {
            this.value = value;
        }

        private T getValue() {
            return value;
        }

        private StackElement<T> getNext() {
            return next;
        }

        private void setNext(StackElement<T> next) {
            this.next = next;
        }
    }
}

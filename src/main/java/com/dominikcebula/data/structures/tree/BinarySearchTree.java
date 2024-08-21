package com.dominikcebula.data.structures.tree;

import com.dominikcebula.data.structures.list.LinkedList;

import java.lang.reflect.Array;

import static com.dominikcebula.data.structures.tree.BinarySearchTree.NodeSearchResult.NodeSearchResultState.FOUND;
import static com.dominikcebula.data.structures.tree.BinarySearchTree.NodeSearchResult.NodeSearchResultState.NOT_FOUND;
import static com.dominikcebula.data.structures.tree.BinarySearchTree.NodeSearchResult.nodeFound;
import static com.dominikcebula.data.structures.tree.BinarySearchTree.NodeSearchResult.nodeNotFound;
import static com.dominikcebula.data.structures.tree.BinarySearchTree.ParentNodeSearchResult.nodeWithValueAlreadyExists;
import static com.dominikcebula.data.structures.tree.BinarySearchTree.ParentNodeSearchResult.parentNodeToInsertChild;

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
            ++size;
        } else {
            ParentNodeSearchResult<T> parentNodeSearchResult = findParentNodeAddChild(value);

            if (parentNodeSearchResult.doesNodeWithValueAlreadyExists())
                return;

            Node<T> parentNodeToInsertValue = parentNodeSearchResult.getParentNode();
            if (value.compareTo(parentNodeToInsertValue.getValue()) < 0)
                parentNodeToInsertValue.setLeft(new Node<>(value));
            else
                parentNodeToInsertValue.setRight(new Node<>(value));

            ++size;
        }
    }

    public boolean exists(T value) {
        NodeSearchResult<T> nodeSearchResult = findNode(value);

        return nodeSearchResult.getSearchResultState() == FOUND;
    }

    public void remove(T elementToRemove) {

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

    private NodeSearchResult<T> findNode(T value) {
        Node<T> currentNode = root;
        Node<T> parentNode = currentNode;

        while (currentNode != null) {
            if (currentNode.getValue().compareTo(value) == 0)
                return nodeFound(currentNode, parentNode);

            parentNode = currentNode;
            if (value.compareTo(currentNode.getValue()) < 0)
                currentNode = currentNode.getLeft();
            else
                currentNode = currentNode.getRight();
        }

        return nodeNotFound();
    }

    private ParentNodeSearchResult<T> findParentNodeAddChild(T value) {
        Node<T> currentNode = root;
        Node<T> parentNode = currentNode;

        while (currentNode != null) {
            if (currentNode.getValue().compareTo(value) == 0)
                return nodeWithValueAlreadyExists();

            parentNode = currentNode;
            if (value.compareTo(currentNode.getValue()) < 0)
                currentNode = currentNode.getLeft();
            else
                currentNode = currentNode.getRight();
        }

        return parentNodeToInsertChild(parentNode);
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

    static class NodeSearchResult<T extends Comparable<T>> {
        private final NodeSearchResultState nodeSearchResultState;
        private final Node<T> node;
        private final Node<T> parentNode;

        private NodeSearchResult(NodeSearchResultState nodeSearchResultState, Node<T> node, Node<T> parentNode) {
            this.nodeSearchResultState = nodeSearchResultState;
            this.node = node;
            this.parentNode = parentNode;
        }

        static <T extends Comparable<T>> NodeSearchResult<T> nodeFound(Node<T> node, Node<T> parentNode) {
            return new NodeSearchResult<>(FOUND, node, parentNode);
        }

        static <T extends Comparable<T>> NodeSearchResult<T> nodeNotFound() {
            return new NodeSearchResult<>(NOT_FOUND, null, null);
        }

        public NodeSearchResultState getSearchResultState() {
            return nodeSearchResultState;
        }

        Node<T> getNode() {
            return node;
        }

        Node<T> getParentNode() {
            return parentNode;
        }

        enum NodeSearchResultState {
            FOUND,
            NOT_FOUND
        }
    }

    static class ParentNodeSearchResult<T extends Comparable<T>> {
        private final Node<T> parentNode;
        private final boolean nodeWithValueAlreadyExists;

        private ParentNodeSearchResult(Node<T> parentNode, boolean nodeWithValueAlreadyExists) {
            this.parentNode = parentNode;
            this.nodeWithValueAlreadyExists = nodeWithValueAlreadyExists;
        }

        static <T extends Comparable<T>> ParentNodeSearchResult<T> parentNodeToInsertChild(Node<T> parentNode) {
            return new ParentNodeSearchResult<>(parentNode, false);
        }

        static <T extends Comparable<T>> ParentNodeSearchResult<T> nodeWithValueAlreadyExists() {
            return new ParentNodeSearchResult<>(null, true);
        }

        private Node<T> getParentNode() {
            return parentNode;
        }

        private boolean doesNodeWithValueAlreadyExists() {
            return nodeWithValueAlreadyExists;
        }
    }
}

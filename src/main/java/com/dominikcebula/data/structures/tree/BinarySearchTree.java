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
        Node<T> nodeToAdd = new Node<>(value);

        if (root == null) {
            root = nodeToAdd;
            ++size;
        } else {
            ParentNodeSearchResult<T> parentNodeSearchResult = findParentNodeForChild(value);

            if (parentNodeSearchResult.doesNodeWithValueAlreadyExists())
                return;

            Node<T> parentNodeForChild = parentNodeSearchResult.getParentNode();
            addNodeToParent(nodeToAdd, parentNodeForChild);

            ++size;
        }
    }

    public boolean exists(T value) {
        NodeSearchResult<T> nodeSearchResult = findNode(value);

        return nodeSearchResult.getSearchResultState() == FOUND;
    }

    public void remove(T elementToRemove) {
        NodeSearchResult<T> nodeSearchResult = findNode(elementToRemove);

        if (nodeSearchResult.getSearchResultState() == NOT_FOUND)
            return;

        Node<T> parentNode = nodeSearchResult.getParentNode();
        Node<T> nodeToRemove = nodeSearchResult.getNode();

        if (root == nodeToRemove && size == 1) {
            root = null;
        } else if (!nodeToRemove.hasAnyChild()) {
            removeByUpdatingParentToNotPointToNodeToRemove(nodeToRemove, parentNode);
        } else if (nodeToRemove.hasOnlyLeftChild()) {
            removeByUpdatingParentToPointToLeftChildOfNodeToRemove(nodeToRemove, parentNode);
        } else if (nodeToRemove.hasOnlyRightChild()) {
            removeByUpdatingParentToPointToRightChildOfNodeToRemove(nodeToRemove, parentNode);
        } else {
            removeByReplacingWithMinNode(nodeToRemove);
        }

        --size;
    }

    public T[] toArray() {
        T[] array = (T[]) Array.newInstance(elementClass, size);

        if (size == 0)
            return array;

        int arrayIndex = 0;

        LinkedList<Node<T>> nodesQueue = new LinkedList<>((Class<Node<T>>) root.getClass());
        nodesQueue.addLast(root);

        while (!nodesQueue.isEmpty()) {
            Node<T> currentNode = nodesQueue.getFirst();
            nodesQueue.removeFirst();

            array[arrayIndex++] = currentNode.getValue();

            if (currentNode.hasLeft())
                nodesQueue.addLast(currentNode.getLeft());
            if (currentNode.hasRight())
                nodesQueue.addLast(currentNode.getRight());
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
            currentNode = currentNode.navigateToChildNodeByValue(value);
        }

        return nodeNotFound();
    }

    private MinNodeSearchResult<T> findMinNode(Node<T> currentNode, Node<T> parentNode) {
        while (currentNode.hasLeft()) {
            parentNode = currentNode;
            currentNode = currentNode.getLeft();
        }

        return new MinNodeSearchResult<>(currentNode, parentNode);
    }

    private ParentNodeSearchResult<T> findParentNodeForChild(T value) {
        Node<T> currentNode = root;
        Node<T> parentNode = currentNode;

        while (currentNode != null) {
            if (currentNode.getValue().compareTo(value) == 0)
                return nodeWithValueAlreadyExists();

            parentNode = currentNode;
            currentNode = currentNode.navigateToChildNodeByValue(value);
        }

        return parentNodeToInsertChild(parentNode);
    }

    private void addNodeToParent(Node<T> nodeToAdd, Node<T> parentNode) {
        updateParentToChildEdge(nodeToAdd.getValue(), nodeToAdd, parentNode);
    }

    private void removeByUpdatingParentToNotPointToNodeToRemove(Node<T> nodeToRemove, Node<T> parentNode) {
        removeParentToChildEdge(nodeToRemove, parentNode);
    }

    private void removeParentToChildEdge(Node<T> nodeToRemove, Node<T> parentNode) {
        updateParentToChildEdge(nodeToRemove.getValue(), null, parentNode);
    }

    private void removeByUpdatingParentToPointToLeftChildOfNodeToRemove(Node<T> nodeToRemove, Node<T> parentNode) {
        updateParentToChildEdge(nodeToRemove.getValue(), nodeToRemove.getLeft(), parentNode);
    }

    private void removeByUpdatingParentToPointToRightChildOfNodeToRemove(Node<T> nodeToRemove, Node<T> parentNode) {
        updateParentToChildEdge(nodeToRemove.getValue(), nodeToRemove.getRight(), parentNode);
    }

    private void removeByReplacingWithMinNode(Node<T> nodeToRemove) {
        MinNodeSearchResult<T> minNodeSearchResult = findMinNode(nodeToRemove.getRight(), nodeToRemove);

        removeParentToChildEdge(minNodeSearchResult.minNode(), minNodeSearchResult.minNodeParent());
        nodeToRemove.setValue(minNodeSearchResult.minNode().getValue());
    }

    private void updateParentToChildEdge(T nodeValue, Node<T> childNode, Node<T> parentNode) {
        if (nodeValue.compareTo(parentNode.getValue()) < 0)
            parentNode.setLeft(childNode);
        else
            parentNode.setRight(childNode);
    }

    private static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        Node(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }

        void setValue(T value) {
            this.value = value;
        }

        Node<T> navigateToChildNodeByValue(T value) {
            if (value.compareTo(getValue()) < 0)
                return getLeft();
            else
                return getRight();
        }

        boolean hasAnyChild() {
            return hasLeft() || hasRight();
        }

        boolean hasOnlyLeftChild() {
            return hasLeft() && !hasRight();
        }

        boolean hasOnlyRightChild() {
            return !hasLeft() && hasRight();
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

    private record MinNodeSearchResult<T extends Comparable<T>>(Node<T> minNode, Node<T> minNodeParent) {
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

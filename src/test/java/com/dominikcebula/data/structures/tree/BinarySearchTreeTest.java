package com.dominikcebula.data.structures.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeTest {
    @Test
    void shouldAddOneElement() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(Integer.class);

        tree.add(50);

        assertThat(tree.toArray())
                .isEqualTo(new Integer[]{50});
    }

    @Test
    void shouldAddThreeElement() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(Integer.class);

        tree.add(2);
        tree.add(1);
        tree.add(3);

        assertThat(tree.toArray())
                .isEqualTo(new Integer[]{2, 1, 3});
    }

    @Test
    void shouldAddThreeElementAllToRightChild() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(Integer.class);

        tree.add(1);
        tree.add(2);
        tree.add(3);

        assertThat(tree.toArray())
                .isEqualTo(new Integer[]{1, 2, 3});
    }

    @Test
    void shouldAddThreeElementAllToLeftChild() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(Integer.class);

        tree.add(3);
        tree.add(2);
        tree.add(1);

        assertThat(tree.toArray())
                .isEqualTo(new Integer[]{3, 2, 1});
    }

    @Test
    void shouldNotAddTheSameValueMultipleTimes() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(Integer.class);

        tree.add(2);
        tree.add(1);
        tree.add(3);

        tree.add(1);
        tree.add(1);
        tree.add(1);

        tree.add(3);
        tree.add(3);
        tree.add(3);

        assertThat(tree.toArray())
                .isEqualTo(new Integer[]{2, 1, 3});
    }

    @Test
    void shouldAddMultipleElements() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(Integer.class);

        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        assertThat(tree.toArray())
                .isEqualTo(new Integer[]{50, 30, 70, 20, 40, 60, 80});
    }
}
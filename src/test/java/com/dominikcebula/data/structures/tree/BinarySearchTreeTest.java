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
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
}
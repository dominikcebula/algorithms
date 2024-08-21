package com.dominikcebula.data.structures.tree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeTest {
    private static Stream<Arguments> treeConstructionCases() {
        return Stream.of(
                Arguments.of(new int[]{1}, new Integer[]{1}),
                Arguments.of(new int[]{1, 2, 3}, new Integer[]{1, 2, 3}),
                Arguments.of(new int[]{2, 1, 3}, new Integer[]{2, 1, 3}),
                Arguments.of(new int[]{3, 2, 1}, new Integer[]{3, 2, 1}),
                Arguments.of(new int[]{50, 30, 70, 20, 40, 60, 80}, new Integer[]{50, 30, 70, 20, 40, 60, 80}),
                Arguments.of(new int[]{100, 20, 500, 10, 30}, new Integer[]{100, 20, 500, 10, 30}),
                Arguments.of(new int[]{100, 20, 500, 10, 30, 40}, new Integer[]{100, 20, 500, 10, 30, 40})
        );
    }

    @ParameterizedTest
    @MethodSource("treeConstructionCases")
    void shouldConstructTreeCorrectly(int[] elements, Integer[] expectedTree) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(Integer.class);

        stream(elements).forEach(tree::add);

        assertThat(tree.toArray())
                .isEqualTo(expectedTree);
    }

    private static Stream<Arguments> treeValueExistenceCases() {
        return Stream.of(
                Arguments.of(new int[]{}, 1, false),
                Arguments.of(new int[]{1}, 1, true),
                Arguments.of(new int[]{1}, 2, false),
                Arguments.of(new int[]{1, 2, 3}, 1, true),
                Arguments.of(new int[]{1, 2, 3}, 2, true),
                Arguments.of(new int[]{1, 2, 3}, 3, true),
                Arguments.of(new int[]{1, 2, 3}, 0, false),
                Arguments.of(new int[]{1, 2, 3}, 4, false),
                Arguments.of(new int[]{2, 1, 3}, 1, true),
                Arguments.of(new int[]{2, 1, 3}, 2, true),
                Arguments.of(new int[]{2, 1, 3}, 3, true),
                Arguments.of(new int[]{2, 1, 3}, 0, false),
                Arguments.of(new int[]{2, 1, 3}, 4, false),
                Arguments.of(new int[]{3, 2, 1}, 1, true),
                Arguments.of(new int[]{3, 2, 1}, 2, true),
                Arguments.of(new int[]{3, 2, 1}, 3, true),
                Arguments.of(new int[]{3, 2, 1}, 0, false),
                Arguments.of(new int[]{3, 2, 1}, 4, false),
                Arguments.of(new int[]{50, 30, 70, 20, 40, 60, 80}, 70, true),
                Arguments.of(new int[]{50, 30, 70, 20, 40, 60, 80}, 50, true),
                Arguments.of(new int[]{50, 30, 70, 20, 40, 60, 80}, 80, true),
                Arguments.of(new int[]{50, 30, 70, 20, 40, 60, 80}, 60, true),
                Arguments.of(new int[]{50, 30, 70, 20, 40, 60, 80}, 100, false),
                Arguments.of(new int[]{50, 30, 70, 20, 40, 60, 80}, 10, false),
                Arguments.of(new int[]{100, 20, 500, 10, 30, 40}, 500, true),
                Arguments.of(new int[]{100, 20, 500, 10, 30, 40}, 40, true),
                Arguments.of(new int[]{100, 20, 500, 10, 30, 40}, 20, true),
                Arguments.of(new int[]{100, 20, 500, 10, 30, 40}, 80, false)
        );
    }

    @ParameterizedTest
    @MethodSource("treeValueExistenceCases")
    void shouldReportValueExistence(int[] elements, int elementToFind, boolean expectedValueExistsResult) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(Integer.class);

        stream(elements).forEach(tree::add);

        assertThat(tree.exists(elementToFind))
                .isEqualTo(expectedValueExistsResult);
    }

    private static Stream<Arguments> elementRemovalCases() {
        return Stream.of(
                Arguments.of(new int[]{}, 1, new Integer[]{}),
                Arguments.of(new int[]{1, 2, 3}, 2, new Integer[]{1, 3}),
                Arguments.of(new int[]{1, 2, 3}, 3, new Integer[]{1, 2}),
                Arguments.of(new int[]{1, 2, 3}, 1, new Integer[]{3, 1}),
                Arguments.of(new int[]{50, 30, 70, 20, 40, 60, 80}, 20, new Integer[]{50, 30, 70, 40, 60, 80}),
                Arguments.of(new int[]{50, 30, 70, 20, 40, 60, 80}, 40, new Integer[]{50, 30, 70, 20, 60, 80}),
                Arguments.of(new int[]{50, 30, 70, 20, 40, 60, 80}, 60, new Integer[]{50, 30, 70, 20, 40, 80}),
                Arguments.of(new int[]{50, 30, 70, 20, 40, 60, 80}, 80, new Integer[]{50, 30, 70, 20, 40, 60}),
                Arguments.of(new int[]{50, 30, 70, 20, 40, 60}, 70, new Integer[]{50, 30, 60, 20, 40}),
                Arguments.of(new int[]{50, 30, 70, 20, 40, 80}, 70, new Integer[]{50, 30, 80, 20, 40}),
                Arguments.of(new int[]{50, 30, 70, 20, 40, 60, 80}, 70, new Integer[]{50, 30, 60, 20, 40, 80}),
                Arguments.of(new int[]{50, 30, 70, 40, 60, 80}, 30, new Integer[]{50, 40, 70, 60, 80}),
                Arguments.of(new int[]{50, 30, 70, 20, 60, 80}, 30, new Integer[]{50, 20, 70, 60, 80}),
                Arguments.of(new int[]{50, 30, 70, 20, 40, 60, 80}, 30, new Integer[]{50, 40, 70, 20, 60, 80})

        );
    }

    @ParameterizedTest
    @MethodSource("elementRemovalCases")
    void shouldRemoveElementCorrectly(int[] elements, int elementToRemove, Integer[] expectedTreeAfterRemoval) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(Integer.class);

        stream(elements).forEach(tree::add);

        tree.remove(elementToRemove);

        assertThat(tree.toArray())
                .isEqualTo(expectedTreeAfterRemoval);
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
    void shouldCorrectlyConstructArrayForEmptyTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(Integer.class);

        assertThat(tree.toArray())
                .isEqualTo(new Integer[]{});
    }
}
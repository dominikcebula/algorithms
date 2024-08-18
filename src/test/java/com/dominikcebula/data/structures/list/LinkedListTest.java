package com.dominikcebula.data.structures.list;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListTest {
    @Test
    void shouldBeEmptyByDefault() {
        LinkedList<Integer> list = new LinkedList<>(Integer.class);

        assertThat(list.isEmpty())
                .isTrue();
        assertThat(list.toArray())
                .isEmpty();
    }

    @Test
    void shouldAddOneElementToHead() {
        LinkedList<Integer> list = new LinkedList<>(Integer.class);

        list.addFirst(1);

        assertThat(list.toArray())
                .isEqualTo(new Integer[]{1});
    }

    @Test
    void shouldAddThreeElementsToHead() {
        LinkedList<Integer> list = new LinkedList<>(Integer.class);

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        assertThat(list.toArray())
                .isEqualTo(new Integer[]{3, 2, 1});
    }

    @Test
    void shouldAddOneElementToTail() {
        LinkedList<Integer> list = new LinkedList<>(Integer.class);

        list.addLast(1);

        assertThat(list.toArray())
                .isEqualTo(new Integer[]{1});
    }

    @Test
    void shouldAddThreeElementsToTail() {
        LinkedList<Integer> list = new LinkedList<>(Integer.class);

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertThat(list.toArray())
                .isEqualTo(new Integer[]{1, 2, 3});
    }

    @Test
    void shouldAddElementsToHeadAndTail() {
        LinkedList<Integer> list = new LinkedList<>(Integer.class);

        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addLast(4);

        assertThat(list.toArray())
                .isEqualTo(new Integer[]{2, 1, 3, 4});
    }

    @Test
    void shouldNotBeEmptyAfterAddingAtLeastOneElementToHead() {
        LinkedList<Integer> list = new LinkedList<>(Integer.class);

        list.addFirst(1);

        assertThat(list.isEmpty())
                .isFalse();
        assertThat(list.toArray())
                .isNotEmpty();
    }

    @Test
    void shouldNotBeEmptyAfterAddingAtLeastOneElementToTail() {
        LinkedList<Integer> list = new LinkedList<>(Integer.class);

        list.addLast(1);

        assertThat(list.isEmpty())
                .isFalse();
        assertThat(list.toArray())
                .isNotEmpty();
    }

    @Test
    void shouldReturnFirstElementCorrectly() {
        LinkedList<Integer> list = new LinkedList<>(Integer.class);

        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addLast(4);

        assertThat(list.getFirst())
                .isEqualTo(2);
    }

    @Test
    void shouldReturnNullForFirstElementWhenListIsEmpty() {
        LinkedList<Integer> list = new LinkedList<>(Integer.class);

        assertThat(list.getFirst())
                .isNull();
    }

    @Test
    void shouldReturnLastElementCorrectly() {
        LinkedList<Integer> list = new LinkedList<>(Integer.class);

        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addLast(4);

        assertThat(list.getLast())
                .isEqualTo(4);
    }

    @Test
    void shouldReturnNullForLastElementWhenListIsEmpty() {
        LinkedList<Integer> list = new LinkedList<>(Integer.class);

        assertThat(list.getLast())
                .isNull();
    }
}
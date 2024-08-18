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
}
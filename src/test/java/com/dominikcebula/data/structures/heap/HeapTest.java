package com.dominikcebula.data.structures.heap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HeapTest {
    @Test
    void shouldBeEmptyByDefault() {
        Heap<Integer> heap = new Heap<>(Integer.class, 20);

        assertThat(heap.isEmpty())
                .isTrue();
        assertThat(heap.toArray())
                .isEmpty();
    }

    @Test
    void shouldReturnNullWhenPeekingEmptyHeap() {
        Heap<Integer> heap = new Heap<>(Integer.class, 20);

        assertThat(heap.peek())
                .isNull();
    }

    @Test
    void shouldReturnNullWhenTryingToPopEmptyHeap() {
        Heap<Integer> heap = new Heap<>(Integer.class, 20);

        assertThat(heap.pop())
                .isNull();
    }

    @Test
    void shouldAddSingleElement() {
        Heap<Integer> heap = new Heap<>(Integer.class, 20);

        heap.add(1);

        assertThat(heap.peek())
                .isEqualTo(1);
        assertThat(heap.toArray())
                .isEqualTo(new Integer[]{1});
        assertThat(heap.pop())
                .isEqualTo(1);
    }
}
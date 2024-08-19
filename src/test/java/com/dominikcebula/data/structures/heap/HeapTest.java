package com.dominikcebula.data.structures.heap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HeapTest {
    @Test
    void shouldBeEmptyByDefault() {
        Heap<Integer> heap = new Heap<>(Integer.class, 20);

        assertThat(heap.isEmpty())
                .isTrue();
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
        assertThat(heap.pop())
                .isEqualTo(1);
    }

    @Test
    void shouldAddAndPopMultipleElements() {
        Heap<Integer> heap = new Heap<>(Integer.class, 3);

        heap.add(16);
        heap.add(10);
        heap.add(5);
        heap.add(8);
        heap.add(14);
        heap.add(12);
        heap.add(18);

        assertThat(heap.pop()).isEqualTo(5);
        assertThat(heap.pop()).isEqualTo(8);
        assertThat(heap.pop()).isEqualTo(10);
        assertThat(heap.pop()).isEqualTo(12);
        assertThat(heap.pop()).isEqualTo(14);
        assertThat(heap.pop()).isEqualTo(16);
        assertThat(heap.pop()).isEqualTo(18);
    }
}
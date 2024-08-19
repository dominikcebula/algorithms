package com.dominikcebula.data.structures.heap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void shouldAddThreeElement() {
        Heap<Integer> heap = new Heap<>(Integer.class, 20);

        heap.add(1);
        heap.add(2);
        heap.add(3);

        assertThat(heap.peek()).isEqualTo(1);
        assertThat(heap.pop()).isEqualTo(1);

        assertThat(heap.peek()).isEqualTo(2);
        assertThat(heap.pop()).isEqualTo(2);

        assertThat(heap.peek()).isEqualTo(3);
        assertThat(heap.pop()).isEqualTo(3);
    }

    @Test
    void shouldReturnNullForPeekAndPopAfterRemovingAllElements() {
        Heap<Integer> heap = new Heap<>(Integer.class, 20);

        heap.add(1);
        heap.add(2);
        heap.add(3);

        heap.pop();
        heap.pop();
        heap.pop();

        assertThat(heap.peek()).isNull();
        assertThat(heap.pop()).isNull();
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

    @Test
    void shouldNotAllowEmptyCapacityHeapCreation() {
        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class, () -> {
            new Heap<>(Integer.class, 0);
        });

        assertThat(thrownException.getMessage())
                .isEqualTo("Heap capacity needs to be greater than zero.");
    }

    @Test
    void shouldNotAllowNegativeCapacityHeapCreation() {
        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class, () -> {
            new Heap<>(Integer.class, -1);
        });

        assertThat(thrownException.getMessage())
                .isEqualTo("Heap capacity needs to be greater than zero.");
    }
}
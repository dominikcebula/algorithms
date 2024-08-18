package com.dominikcebula.data.structures.stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackTest {
    @Test
    void shouldBeEmptyByDefault() {
        Stack<Integer> stack = new Stack<>();

        assertThat(stack.isEmpty())
                .isTrue();
    }

    @Test
    void shouldAddOneElement() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);

        assertThat(stack.peek())
                .isEqualTo(1);
        assertThat(stack.isEmpty())
                .isFalse();
    }

    @Test
    void shouldAddThreeElements() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThat(stack.peek())
                .isEqualTo(3);
        assertThat(stack.isEmpty())
                .isFalse();
    }

    @Test
    void shouldAddAndPopElements() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(2);

        assertThat(stack.peek())
                .isEqualTo(1);
        assertThat(stack.isEmpty())
                .isFalse();
    }

    @Test
    void shouldAddAndPopAllElements() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(2);

        stack.push(4);
        stack.push(5);

        assertThat(stack.pop()).isEqualTo(5);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(1);

        assertThat(stack.peek())
                .isNull();
        assertThat(stack.isEmpty())
                .isTrue();
    }
}
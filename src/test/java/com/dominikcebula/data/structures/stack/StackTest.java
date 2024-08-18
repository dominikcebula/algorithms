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
}
package com.dominikcebula.algorithms.dynamic.programming.rod.cutting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RodCuttingTest {
    private final RodCuttingRecursion rodCuttingRecursion = new RodCuttingRecursion();

    public static Stream<Arguments> maxCuttingRodValueCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 8, 9, 10, 17, 17, 20}, 22),
                Arguments.of(new int[]{3, 5, 8, 9, 10, 17}, 18),
                Arguments.of(new int[]{5}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("maxCuttingRodValueCases")
    void shouldFindMaxCuttingRodValueUsingRecursion(int[] prices, int expectedMaxCuttingRodValue) {
        int maxCuttingRodValue = rodCuttingRecursion.findMaxCuttingRodValue(prices);

        assertThat(maxCuttingRodValue)
                .isEqualTo(expectedMaxCuttingRodValue);
    }
}
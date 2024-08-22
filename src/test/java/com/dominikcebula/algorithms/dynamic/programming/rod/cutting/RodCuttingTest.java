package com.dominikcebula.algorithms.dynamic.programming.rod.cutting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RodCuttingTest {
    private final RodCuttingRecursion rodCuttingRecursion = new RodCuttingRecursion();
    private final RodCuttingMemoization rodCuttingMemoization = new RodCuttingMemoization();
    private final RodCuttingTabulation rodCuttingTabulation = new RodCuttingTabulation();

    public static Stream<Arguments> maxCuttingRodValueCases() {
        return Stream.of(
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{5}, 5),
                Arguments.of(new int[]{1, 5, 8, 9, 10, 17, 17, 20}, 22),
                Arguments.of(new int[]{3, 5, 8, 9, 10, 17}, 18),
                Arguments.of(new int[]{1, 4, 6, 5}, 8),
                Arguments.of(new int[]{3, 6, 9, 12, 15, 14, 11}, 21),
                Arguments.of(new int[]{2, 4, 5, 7, 11, 13, 14, 9, 12, 6}, 22),
                Arguments.of(new int[]{1, 3, 4, 8, 10, 13}, 13),
                Arguments.of(new int[]{2, 5, 7, 11, 9, 12, 13, 14, 6}, 24),
                Arguments.of(new int[]{4, 8, 9, 12, 14}, 20),
                Arguments.of(new int[]{3, 5, 7, 10, 11, 14, 15}, 21),
                Arguments.of(new int[]{2, 3, 6, 7, 8, 10, 11, 13}, 16),
                Arguments.of(new int[]{1, 4, 5, 9, 12, 13, 15}, 16),
                Arguments.of(new int[]{2, 4, 7, 8, 10, 12, 14, 15}, 18),
                Arguments.of(new int[]{1, 6, 7, 11, 13, 14, 15}, 19)
        );
    }

    @ParameterizedTest
    @MethodSource("maxCuttingRodValueCases")
    void shouldFindMaxCuttingRodValueUsingRecursion(int[] prices, int expectedMaxCuttingRodValue) {
        int maxCuttingRodValue = rodCuttingRecursion.findMaxCuttingRodValue(prices);

        assertThat(maxCuttingRodValue)
                .isEqualTo(expectedMaxCuttingRodValue);
    }

    @ParameterizedTest
    @MethodSource("maxCuttingRodValueCases")
    void shouldFindMaxCuttingRodValueUsingMemoization(int[] prices, int expectedMaxCuttingRodValue) {
        int maxCuttingRodValue = rodCuttingMemoization.findMaxCuttingRodValue(prices);

        assertThat(maxCuttingRodValue)
                .isEqualTo(expectedMaxCuttingRodValue);
    }

    @ParameterizedTest
    @MethodSource("maxCuttingRodValueCases")
    void shouldFindMaxCuttingRodValueUsingTabulation(int[] prices, int expectedMaxCuttingRodValue) {
        int maxCuttingRodValue = rodCuttingTabulation.findMaxCuttingRodValue(prices);

        assertThat(maxCuttingRodValue)
                .isEqualTo(expectedMaxCuttingRodValue);
    }
}
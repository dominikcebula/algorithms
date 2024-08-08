package com.dominikcebula.algorithms.dynamic.programming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinChangeTest {
    private final CoinChangeRecursion coinChangeRecursion = new CoinChangeRecursion();
    private final CoinChangeMemoization coinChangeMemoization = new CoinChangeMemoization();

    private static Stream<Arguments> coinChangeTestCases() {
        return Stream.of(
                Arguments.of(0, new int[]{1, 2, 3}, 1),
                Arguments.of(3, new int[]{5, 7, 8}, 0),
                Arguments.of(4, new int[]{1, 2, 3}, 4),
                Arguments.of(5, new int[]{1, 2, 5}, 4),
                Arguments.of(6, new int[]{1, 3, 4}, 4),
                Arguments.of(8, new int[]{1, 2, 3}, 10),
                Arguments.of(10, new int[]{2, 5, 3, 6}, 5),
                Arguments.of(11, new int[]{2, 3, 5, 7}, 5),
                Arguments.of(12, new int[]{1, 2, 5}, 13),
                Arguments.of(14, new int[]{1, 2, 5}, 16),
                Arguments.of(15, new int[]{2, 3, 7}, 5),
                Arguments.of(16, new int[]{3, 4, 7, 9}, 5),
                Arguments.of(17, new int[]{1, 2, 3, 4}, 72),
                Arguments.of(18, new int[]{5, 10, 12}, 0),
                Arguments.of(19, new int[]{1, 5, 10}, 6),
                Arguments.of(20, new int[]{2, 3, 7, 10}, 12)
        );
    }

    @ParameterizedTest
    @MethodSource("coinChangeTestCases")
    void shouldSolveCoinChaneProblemCorrectlyUsingRecursion(int sum, int[] coinDenominations, int expectedNumberOfCombinations) {
        int numberOfCombinations = coinChangeRecursion.solve(sum, coinDenominations);

        assertEquals(expectedNumberOfCombinations, numberOfCombinations);
    }

    @ParameterizedTest
    @MethodSource("coinChangeTestCases")
    void shouldSolveCoinChaneProblemCorrectlyUsingMemoization(int sum, int[] coinDenominations, int expectedNumberOfCombinations) {
        int numberOfCombinations = coinChangeMemoization.solve(sum, coinDenominations);

        assertEquals(expectedNumberOfCombinations, numberOfCombinations);
    }
}
package com.dominikcebula.algorithms.dynamic.programming.knapsack.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnapsackProblemTest {
    private final KnapsackProblemRecursion knapsackProblemRecursion = new KnapsackProblemRecursion();
    private final KnapsackProblemMemoization knapsackProblemMemoization = new KnapsackProblemMemoization();

    private static Stream<Arguments> knapsackProblemTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3},
                        new int[]{4, 5, 1},
                        3, 4,
                        3
                ),
                Arguments.of(
                        new int[]{1, 2, 3},
                        new int[]{4, 5, 6},
                        3, 3,
                        0
                ),
                Arguments.of(
                        new int[]{20, 5, 10, 40, 15, 25},
                        new int[]{1, 2, 3, 8, 7, 4},
                        6, 10,
                        60
                ),
                Arguments.of(
                        new int[]{24, 18, 18, 10},
                        new int[]{24, 10, 10, 7},
                        4, 25,
                        36
                ),
                Arguments.of(
                        new int[]{10, 20, 30},
                        new int[]{1, 1, 1},
                        3, 2,
                        50
                ),
                Arguments.of(
                        new int[]{5, 7, 12, 18, 3},
                        new int[]{1, 3, 4, 5, 1},
                        5, 7,
                        26
                ),
                Arguments.of(
                        new int[]{15, 14, 10, 45, 30},
                        new int[]{2, 5, 1, 3, 4},
                        5, 7,
                        75
                ),
                Arguments.of(
                        new int[]{10, 20, 15, 25},
                        new int[]{1, 3, 4, 2},
                        4, 5,
                        45
                ),
                Arguments.of(
                        new int[]{20, 30, 50, 10},
                        new int[]{3, 4, 5, 2},
                        4, 8,
                        70
                ),
                Arguments.of(
                        new int[]{7, 2, 9, 4},
                        new int[]{3, 1, 2, 1},
                        4, 5,
                        16
                ),
                Arguments.of(
                        new int[]{16, 19, 23, 28, 40},
                        new int[]{2, 3, 4, 5, 6},
                        5, 10,
                        63
                ),
                Arguments.of(
                        new int[]{50, 40, 30, 20},
                        new int[]{5, 4, 6, 3},
                        4, 10,
                        90
                )
        );
    }

    @ParameterizedTest
    @MethodSource("knapsackProblemTestCases")
    void shouldSolveKnapsackProblemUsingRecursion(int[] profits, int[] weights, int itemCount, int bagCapacity, int expectedMaxProfit) {
        int maxProfit = knapsackProblemRecursion.findMaxProfit(profits, weights, itemCount, bagCapacity);

        assertEquals(expectedMaxProfit, maxProfit);
    }

    @ParameterizedTest
    @MethodSource("knapsackProblemTestCases")
    void shouldSolveKnapsackProblemUsingMemoization(int[] profits, int[] weights, int itemCount, int bagCapacity, int expectedMaxProfit) {
        int maxProfit = knapsackProblemMemoization.findMaxProfit(profits, weights, itemCount, bagCapacity);

        assertEquals(expectedMaxProfit, maxProfit);
    }
}
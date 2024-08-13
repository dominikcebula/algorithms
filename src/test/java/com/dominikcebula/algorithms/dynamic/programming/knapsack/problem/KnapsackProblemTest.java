package com.dominikcebula.algorithms.dynamic.programming.knapsack.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnapsackProblemTest {
    private final KnapsackProblemRecursion knapsackProblemRecursion = new KnapsackProblemRecursion();

    private static Stream<Arguments> knapsackProblemTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3},
                        new int[]{4, 5, 1},
                        3, 4,
                        3
                )
        );
    }

    @ParameterizedTest
    @MethodSource("knapsackProblemTestCases")
    void shouldSolveKnapsackProblemUsingRecursion(int[] profits, int[] weights, int itemCount, int bagCapacity, int expectedMaxProfit) {
        int maxProfit = knapsackProblemRecursion.findMaxProfit(profits, weights, itemCount, bagCapacity);

        assertEquals(expectedMaxProfit, maxProfit);
    }
}
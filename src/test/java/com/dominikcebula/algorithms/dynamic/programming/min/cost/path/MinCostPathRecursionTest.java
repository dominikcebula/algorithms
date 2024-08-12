package com.dominikcebula.algorithms.dynamic.programming.min.cost.path;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinCostPathRecursionTest {
    private final MinCostPathRecursion minCostPathRecursion = new MinCostPathRecursion();

    private static Stream<Arguments> minCostPathTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{
                                {1}},
                        0, 0, 1),
                Arguments.of(new int[][]{
                                {1, 2},
                                {3, 4}},
                        1, 1, 5),
                Arguments.of(new int[][]{
                                {1, 2},
                                {3, 4}},
                        0, 1, 3),
                Arguments.of(new int[][]{
                                {1, 2, 3},
                                {4, 8, 2},
                                {1, 5, 3}},
                        2, 2, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("minCostPathTestCases")
    void shouldFindMinCostPathUsingRecursion(int[][] costs, int targetPositionM, int targetPositionN, int expectedMinCost) {
        int minCostPath = minCostPathRecursion.findMinCostPath(costs, targetPositionM, targetPositionN);

        assertEquals(expectedMinCost, minCostPath);
    }
}
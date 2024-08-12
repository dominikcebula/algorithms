package com.dominikcebula.algorithms.dynamic.programming.min.cost.path;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinCostPathTest {
    private final MinCostPathRecursion minCostPathRecursion = new MinCostPathRecursion();
    private final MinCostPathMemoization minCostPathMemoization = new MinCostPathMemoization();
    private final MinCostPathTabulation minCostPathTabulation = new MinCostPathTabulation();

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
                        2, 2, 8),
                Arguments.of(new int[][]{
                                {1, 2},
                                {3, 4}},
                        1, 1, 5),
                Arguments.of(new int[][]{
                                {4, 8, 2},
                                {1, 5, 3},
                                {6, 7, 9}},
                        0, 0, 4),
                Arguments.of(new int[][]{
                                {10, 10, 2},
                                {10, 10, 3},
                                {10, 10, 9}},
                        2, 2, 29),
                Arguments.of(new int[][]{
                                {1, 2, 3},
                                {4, 8, 2},
                                {1, 5, 3}},
                        2, 2, 8),
                Arguments.of(new int[][]{
                                {2, 3, 4},
                                {8, 9, 1},
                                {3, 2, 6}},
                        2, 2, 12),
                Arguments.of(new int[][]{
                                {1, 2, 3},
                                {4, 8, 2},
                                {1, 5, 3}},
                        2, 2, 8),
                Arguments.of(new int[][]{
                                {5, 9, 6},
                                {11, 5, 2},
                                {8, 7, 4}},
                        2, 2, 14),
                Arguments.of(new int[][]{
                                {3, 2, 1, 4},
                                {1, 7, 3, 8},
                                {5, 6, 2, 9},
                                {8, 4, 3, 5}},
                        3, 3, 15),
                Arguments.of(new int[][]{
                                {1, 1, 1, 1},
                                {1, 1, 1, 1},
                                {1, 1, 1, 1},
                                {1, 1, 1, 1}},
                        3, 3, 4),
                Arguments.of(new int[][]{
                                {1, 3, 5, 8},
                                {4, 2, 1, 7},
                                {4, 3, 2, 3},
                                {4, 1, 5, 6}},
                        3, 3, 11),
                Arguments.of(new int[][]{
                                {1, 3, 1},
                                {1, 5, 1},
                                {4, 2, 1}},
                        2, 1, 4),
                Arguments.of(new int[][]{
                                {1, 2, 5},
                                {3, 2, 1},
                                {4, 2, 2}},
                        1, 2, 4),
                Arguments.of(new int[][]{
                                {1, 2, 5},
                                {3, 2, 1},
                                {4, 2, 2}},
                        2, 2, 5),
                Arguments.of(new int[][]{
                                {1, 2, 5},
                                {3, 9, 1},
                                {4, 2, 2}},
                        2, 2, 6),
                Arguments.of(new int[][]{
                                {1, 9, 1, 1},
                                {1, 5, 1, 1},
                                {1, 1, 1, 1},
                                {1, 1, 1, 1}},
                        0, 2, 11),
                Arguments.of(new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}},
                        2, 1, 13),
                Arguments.of(new int[][]{
                                {1, 3, 1},
                                {2, 1, 3},
                                {3, 2, 1}},
                        2, 2, 3),
                Arguments.of(new int[][]{
                                {1, 2, 3, 4, 5},
                                {6, 7, 8, 9, 10},
                                {11, 12, 13, 14, 15},
                                {16, 17, 18, 19, 20},
                                {21, 22, 23, 24, 25}},
                        4, 4, 65),
                Arguments.of(new int[][]{
                                {5, 9, 3, 8, 2},
                                {7, 1, 6, 4, 9},
                                {3, 2, 5, 7, 1},
                                {8, 3, 6, 9, 4},
                                {4, 1, 8, 2, 7}},
                        4, 4, 23),
                Arguments.of(new int[][]{
                                {1, 1, 1, 1, 1, 1},
                                {1, 2, 2, 2, 2, 1},
                                {1, 2, 3, 3, 2, 1},
                                {1, 2, 3, 3, 2, 1},
                                {1, 2, 2, 2, 2, 1},
                                {1, 1, 1, 1, 1, 1}},
                        5, 5, 10),
                Arguments.of(new int[][]{
                                {5, 2, 8, 6, 1, 4},
                                {7, 9, 1, 3, 8, 2},
                                {3, 6, 4, 7, 9, 5},
                                {8, 3, 7, 2, 1, 9},
                                {2, 5, 9, 8, 6, 3},
                                {4, 7, 2, 5, 4, 8}},
                        5, 5, 26),
                Arguments.of(new int[][]{
                                {1, 3, 4, 6, 7, 1, 8, 2},
                                {4, 5, 7, 9, 2, 3, 4, 6},
                                {6, 1, 2, 4, 5, 7, 9, 3},
                                {7, 2, 4, 1, 3, 8, 6, 5},
                                {8, 4, 5, 6, 2, 9, 3, 7},
                                {9, 6, 1, 2, 4, 5, 7, 8},
                                {2, 7, 3, 5, 1, 6, 8, 9},
                                {3, 8, 6, 7, 9, 2, 4, 1}},
                        7, 7, 23)

        );
    }

    @ParameterizedTest
    @MethodSource("minCostPathTestCases")
    void shouldFindMinCostPathUsingRecursion(int[][] costs, int targetPositionM, int targetPositionN, int expectedMinCost) {
        int minCostPath = minCostPathRecursion.findMinCostPath(costs, targetPositionM, targetPositionN);

        assertEquals(expectedMinCost, minCostPath);
    }

    @ParameterizedTest
    @MethodSource("minCostPathTestCases")
    void shouldFindMinCostPathUsingMemoization(int[][] costs, int targetPositionM, int targetPositionN, int expectedMinCost) {
        int minCostPath = minCostPathMemoization.findMinCostPath(costs, targetPositionM, targetPositionN);

        assertEquals(expectedMinCost, minCostPath);
    }

    @ParameterizedTest
    @MethodSource("minCostPathTestCases")
    void shouldFindMinCostPathUsingTabulation(int[][] costs, int targetPositionM, int targetPositionN, int expectedMinCost) {
        int minCostPath = minCostPathTabulation.findMinCostPath(costs, targetPositionM, targetPositionN);

        assertEquals(expectedMinCost, minCostPath);
    }
}
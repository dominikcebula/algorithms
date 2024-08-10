package com.dominikcebula.algorithms.dynamic.programming.longest.increasing.subsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestIncreasingSubsequenceTest {
    private final LongestIncreasingSubsequenceRecursion longestIncreasingSubsequenceRecursion = new LongestIncreasingSubsequenceRecursion();
    private final LongestIncreasingSubsequenceMemoization longestIncreasingSubsequenceMemoization = new LongestIncreasingSubsequenceMemoization();
    private final LongestIncreasingSubsequenceTabulation longestIncreasingSubsequenceTabulation = new LongestIncreasingSubsequenceTabulation();

    private static Stream<Arguments> longestIncreasingSubsequenceTestCases() {
        return Stream.of(
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{10}, 1),
                Arguments.of(new int[]{10, 20, 30}, 3),
                Arguments.of(new int[]{30, 20, 10}, 1),
                Arguments.of(new int[]{1, -1, 2, 3}, 3),
                Arguments.of(new int[]{3, 10, 2, 1, 20}, 3),
                Arguments.of(new int[]{50, 3, 10, 7, 40, 80}, 4),
                Arguments.of(new int[]{50, 40, 30, 20, 10}, 1),
                Arguments.of(new int[]{10, 20, 35, 80}, 4),
                Arguments.of(new int[]{10, 20, 30, 40, 50}, 5),
                Arguments.of(new int[]{5, 7, 4, 8, 2, 9, 10}, 5),
                Arguments.of(new int[]{2, 2, 2, 2, 2}, 1),
                Arguments.of(new int[]{3, 4, -1, 0, 6, 2, 3}, 4),
                Arguments.of(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}, 6),
                Arguments.of(new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4),
                Arguments.of(new int[]{1, 2, 3, 2, 3, 4, 5}, 5),
                Arguments.of(new int[]{9, 1, 3, 7, 5, 6, 20, 15}, 5),
                Arguments.of(new int[]{5, -2, 6, 1, 2, 3, -5}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("longestIncreasingSubsequenceTestCases")
    void shouldFindLongestIncreasingSubsequenceUsingRecursion(int[] elements, int expectedLongestIncreasingSubsequence) {
        int longestIncreasingSubsequence = longestIncreasingSubsequenceRecursion.findLongestIncreasingSubsequence(elements);

        assertEquals(expectedLongestIncreasingSubsequence, longestIncreasingSubsequence);
    }

    @ParameterizedTest
    @MethodSource("longestIncreasingSubsequenceTestCases")
    void shouldFindLongestIncreasingSubsequenceUsingMemoization(int[] elements, int expectedLongestIncreasingSubsequence) {
        int longestIncreasingSubsequence = longestIncreasingSubsequenceMemoization.findLongestIncreasingSubsequence(elements);

        assertEquals(expectedLongestIncreasingSubsequence, longestIncreasingSubsequence);
    }

    @ParameterizedTest
    @MethodSource("longestIncreasingSubsequenceTestCases")
    void shouldFindLongestIncreasingSubsequenceUsingTabulation(int[] elements, int expectedLongestIncreasingSubsequence) {
        int longestIncreasingSubsequence = longestIncreasingSubsequenceTabulation.findLongestIncreasingSubsequence(elements);

        assertEquals(expectedLongestIncreasingSubsequence, longestIncreasingSubsequence);
    }
}
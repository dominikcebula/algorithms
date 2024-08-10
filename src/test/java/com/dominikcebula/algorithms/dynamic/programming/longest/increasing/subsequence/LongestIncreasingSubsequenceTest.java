package com.dominikcebula.algorithms.dynamic.programming.longest.increasing.subsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestIncreasingSubsequenceTest {
    private final LongestIncreasingSubsequenceRecursion longestIncreasingSubsequenceRecursion = new LongestIncreasingSubsequenceRecursion();

    private static Stream<Arguments> longestIncreasingSubsequenceTestCases() {
        return Stream.of(
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{10}, 1),
                Arguments.of(new int[]{3, 10, 2, 1, 20}, 3),
                Arguments.of(new int[]{50, 3, 10, 7, 40, 80}, 4),
                Arguments.of(new int[]{30, 20, 10}, 1),
                Arguments.of(new int[]{50, 40, 30, 20, 10}, 1),
                Arguments.of(new int[]{10, 20, 35, 80}, 4),
                Arguments.of(new int[]{10, 20, 30, 40, 50}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("longestIncreasingSubsequenceTestCases")
    void shouldLongestIncreasingSubsequenceUsingRecursion(int[] elements, int expectedLongestIncreasingSubsequence) {
        int longestIncreasingSubsequence = longestIncreasingSubsequenceRecursion.findLongestIncreasingSubsequence(elements);

        assertEquals(expectedLongestIncreasingSubsequence, longestIncreasingSubsequence);
    }
}
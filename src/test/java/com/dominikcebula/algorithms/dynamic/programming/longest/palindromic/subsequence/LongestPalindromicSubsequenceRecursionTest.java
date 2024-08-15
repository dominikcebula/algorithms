package com.dominikcebula.algorithms.dynamic.programming.longest.palindromic.subsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromicSubsequenceRecursionTest {
    private final LongestPalindromicSubsequenceRecursion longestPalindromicSubsequenceRecursion = new LongestPalindromicSubsequenceRecursion();

    private static Stream<Arguments> longestPalindromicSubsequenceTestCases() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("A", 1),
                Arguments.of("AA", 2),
                Arguments.of("AABB", 2),
                Arguments.of("AABBAA", 4),
                Arguments.of("BBABCBCAB", 7)
        );
    }

    @ParameterizedTest
    @MethodSource("longestPalindromicSubsequenceTestCases")
    void shouldFindLongestPalindromicSubsequenceUsingRecursion(String string, int expectedLongestPalindromicSubsequence) {
        int longestPalindromicSubsequence = longestPalindromicSubsequenceRecursion.findLongestPalindromicSubsequence(string);

        assertEquals(expectedLongestPalindromicSubsequence, longestPalindromicSubsequence);
    }
}
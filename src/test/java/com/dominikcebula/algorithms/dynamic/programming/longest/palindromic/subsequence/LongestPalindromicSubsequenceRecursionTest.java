package com.dominikcebula.algorithms.dynamic.programming.longest.palindromic.subsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromicSubsequenceRecursionTest {
    private final LongestPalindromicSubsequenceRecursion longestPalindromicSubsequenceRecursion = new LongestPalindromicSubsequenceRecursion();
    private final LongestPalindromicSubsequenceMemoization longestPalindromicSubsequenceMemoization = new LongestPalindromicSubsequenceMemoization();

    private static Stream<Arguments> longestPalindromicSubsequenceTestCases() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("A", 1),
                Arguments.of("AA", 2),
                Arguments.of("AABB", 2),
                Arguments.of("ABBA", 4),
                Arguments.of("AABBAA", 6),
                Arguments.of("AFABCBADA", 7),
                Arguments.of("ACABCBACA", 9),
                Arguments.of("BBABCBCAB", 7),
                Arguments.of("REDIVIDER", 9),
                Arguments.of("ROTAVATOR", 9),
                Arguments.of("DCELEVCELED", 9),
                Arguments.of("DETARTCRACTED", 11),
                Arguments.of("MALAYCCALAM", 10),
                Arguments.of("DCEIFIEDC", 7),
                Arguments.of("CRELEVELECR", 9),
                Arguments.of("CRECVIVECR", 7),
                Arguments.of("TATCTARRACTTAT", 12),
                Arguments.of("MACDAMIMXADCAM", 13)
        );
    }

    @ParameterizedTest
    @MethodSource("longestPalindromicSubsequenceTestCases")
    void shouldFindLongestPalindromicSubsequenceUsingRecursion(String string, int expectedLongestPalindromicSubsequence) {
        int longestPalindromicSubsequence = longestPalindromicSubsequenceRecursion.findLongestPalindromicSubsequence(string);

        assertEquals(expectedLongestPalindromicSubsequence, longestPalindromicSubsequence);
    }

    @ParameterizedTest
    @MethodSource("longestPalindromicSubsequenceTestCases")
    void shouldFindLongestPalindromicSubsequenceUsingMemoization(String string, int expectedLongestPalindromicSubsequence) {
        int longestPalindromicSubsequence = longestPalindromicSubsequenceMemoization.findLongestPalindromicSubsequence(string);

        assertEquals(expectedLongestPalindromicSubsequence, longestPalindromicSubsequence);
    }
}
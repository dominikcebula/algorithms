package com.dominikcebula.algorithms.dynamic.programming.longest.common.subsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonSubsequenceTest {
    private final LongestCommonSubsequenceRecursion longestCommonSubsequenceRecursion = new LongestCommonSubsequenceRecursion();
    private final LongestCommonSubsequenceMemoization longestCommonSubsequenceMemoization = new LongestCommonSubsequenceMemoization();
    private final LongestCommonSubsequenceTabulation longestCommonSubsequenceTabulation = new LongestCommonSubsequenceTabulation();

    private static Stream<Arguments> longestCommonSubsequenceTestCases() {
        return Stream.of(
                Arguments.of("", "", 0),
                Arguments.of("A", "", 0),
                Arguments.of("", "B", 0),
                Arguments.of("A", "B", 0),
                Arguments.of("ABC", "ACD", 2),
                Arguments.of("ABC", "CBA", 1),
                Arguments.of("XYZW", "XYWZ", 3),
                Arguments.of("AGGTAB", "GXTXAYB", 4),
                Arguments.of("XYZW", "XYWZ", 3),
                Arguments.of("ABCBDAB", "BDCAB", 4),
                Arguments.of("AGGTAB", "GXTXAYB", 4),
                Arguments.of("12345", "54321", 1),
                Arguments.of("ABCD", "EFGH", 0),
                Arguments.of("ABC", "ABC", 3),
                Arguments.of("AAB", "ABA", 2),
                Arguments.of("XMJYAUZ", "MZJAWXU", 4),
                Arguments.of("ABCDGH", "AEDFHR", 3),
                Arguments.of("ABC", "AC", 2),
                Arguments.of("BANANA", "ATANA", 4),
                Arguments.of("ABAZDC", "BACBAD", 4),
                Arguments.of("HELLO", "GELLO", 4),
                Arguments.of("ABCE", "ADFCE", 3),
                Arguments.of("GAC", "AGCAT", 2),
                Arguments.of("ABCDXYWZEFGH", "XYZEFGHABCD", 7),
                Arguments.of("LONGESTCOMMON", "CONNECTIONS", 6),
                Arguments.of("DYNAMICPROG", "AMICROGRAMMING", 7),
                Arguments.of("SUBSEQUENCE", "CONSEQUENCES", 8),
                Arguments.of("ALGORITHMS", "RHETORICAL", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("longestCommonSubsequenceTestCases")
    void shouldFindLongestCommonSubsequenceUsingRecursion(String string1, String string2, int expectedLongestCommonSubsequence) {
        int longestCommonSubsequence = longestCommonSubsequenceRecursion.findLongestCommonSubsequence(string1, string2);

        assertEquals(expectedLongestCommonSubsequence, longestCommonSubsequence);
    }

    @ParameterizedTest
    @MethodSource("longestCommonSubsequenceTestCases")
    void shouldFindLongestCommonSubsequenceUsingMemoization(String string1, String string2, int expectedLongestCommonSubsequence) {
        int longestCommonSubsequence = longestCommonSubsequenceMemoization.findLongestCommonSubsequence(string1, string2);

        assertEquals(expectedLongestCommonSubsequence, longestCommonSubsequence);
    }

    @ParameterizedTest
    @MethodSource("longestCommonSubsequenceTestCases")
    void shouldFindLongestCommonSubsequenceUsingTabulation(String string1, String string2, int expectedLongestCommonSubsequence) {
        int longestCommonSubsequence = longestCommonSubsequenceTabulation.findLongestCommonSubsequence(string1, string2);

        assertEquals(expectedLongestCommonSubsequence, longestCommonSubsequence);
    }
}
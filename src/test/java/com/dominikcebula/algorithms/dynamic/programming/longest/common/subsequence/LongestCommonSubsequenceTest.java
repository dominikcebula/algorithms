package com.dominikcebula.algorithms.dynamic.programming.longest.common.subsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonSubsequenceTest {
    private final LongestCommonSubsequenceRecursion longestCommonSubsequenceRecursion = new LongestCommonSubsequenceRecursion();

    private static Stream<Arguments> longestCommonSubsequenceTestCases() {
        return Stream.of(
                Arguments.of("", "", 0),
                Arguments.of("A", "", 0),
                Arguments.of("", "B", 0),
                Arguments.of("A", "B", 0),
                Arguments.of("ABC", "ACD", 2),
                Arguments.of("ABC", "CBA", 1),
                Arguments.of("XYZW", "XYWZ", 3),
                Arguments.of("AGGTAB", "GXTXAYB", 4)
        );
    }

    @ParameterizedTest
    @MethodSource("longestCommonSubsequenceTestCases")
    void shouldFindLongestCommonSubsequenceUsingRecursion(String string1, String string2, int expectedLongestCommonSubsequence) {
        int longestCommonSubsequence = longestCommonSubsequenceRecursion.findLongestCommonSubsequence(string1, string2);

        assertEquals(expectedLongestCommonSubsequence, longestCommonSubsequence);
    }
}
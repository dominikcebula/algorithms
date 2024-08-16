package com.dominikcebula.algorithms.dynamic.programming.palindrome.partitioning;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromePartitioningRecursionTest {
    private final PalindromePartitioningRecursion palindromePartitioningRecursion = new PalindromePartitioningRecursion();

    private static Stream<Arguments> palindromePartitioningUseCases() {
        return Stream.of(
                Arguments.of("peek", 2),
                Arguments.of("a", 0),
                Arguments.of("aa", 0),
                Arguments.of("aaaa", 0),
                Arguments.of("abba", 0),
                Arguments.of("abbac", 1),
                Arguments.of("cabbac", 2),
                Arguments.of("ababbbabbababa", 3),
                Arguments.of("abbacddc", 2),
                Arguments.of("abcdefgh", 8),
                Arguments.of("aaaabbbb", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("palindromePartitioningUseCases")
    void shouldFindMinCutsToGetPalindromeUsingRecursion(String string, int expectedMinCutsToGetPalindrome) {
        int minCutsToGetPalindrome = palindromePartitioningRecursion.findMinCutsToGetPalindrome(string);

        assertEquals(expectedMinCutsToGetPalindrome, minCutsToGetPalindrome);
    }
}
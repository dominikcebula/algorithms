package com.dominikcebula.algorithms.dynamic.programming.palindrome.partitioning;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromePartitioningRecursionTest {
    private final PalindromePartitioningRecursion palindromePartitioningRecursion = new PalindromePartitioningRecursion();
    private final PalindromePartitioningTabulation palindromePartitioningTabulation = new PalindromePartitioningTabulation();

    private static Stream<Arguments> palindromePartitioningUseCases() {
        return Stream.of(
                Arguments.of("a", 0),
                Arguments.of("aa", 0),
                Arguments.of("aaaa", 0),
                Arguments.of("abba", 0),
                Arguments.of("peek", 2),
                Arguments.of("abbac", 1),
                Arguments.of("cabbac", 0),
                Arguments.of("ababbbabbababa", 3),
                Arguments.of("abbacddc", 1),
                Arguments.of("abcdefgh", 7),
                Arguments.of("aaaabbbb", 1),
                Arguments.of("abbabbc", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("palindromePartitioningUseCases")
    void shouldFindMinCutsToGetPalindromesUsingRecursion(String string, int expectedMinCutsToGetPalindrome) {
        int minCutsToGetPalindrome = palindromePartitioningRecursion.findMinCutsToGetPalindromes(string);

        assertEquals(expectedMinCutsToGetPalindrome, minCutsToGetPalindrome);
    }

    @ParameterizedTest
    @MethodSource("palindromePartitioningUseCases")
    void shouldFindMinCutsToGetPalindromesUsingTabulation(String string, int expectedMinCutsToGetPalindrome) {
        int minCutsToGetPalindrome = palindromePartitioningTabulation.findMinCutsToGetPalindromes(string);

        assertEquals(expectedMinCutsToGetPalindrome, minCutsToGetPalindrome);
    }
}
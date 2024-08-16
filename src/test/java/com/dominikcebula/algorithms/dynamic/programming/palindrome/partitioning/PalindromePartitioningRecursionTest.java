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
                Arguments.of("peek", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("palindromePartitioningUseCases")
    void shouldFindMinCutsToGetPalindromeUsingRecursion(String string, int expectedMinCutsToGetPalindrome) {
        int minCutsToGetPalindrome = palindromePartitioningRecursion.findMinCutsToGetPalindrome(string);

        assertEquals(expectedMinCutsToGetPalindrome, minCutsToGetPalindrome);
    }
}
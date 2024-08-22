package com.dominikcebula.algorithms.dynamic.programming.subset.sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SubsetSumRecursionTest {
    private final SubsetSumRecursion subsetSumRecursion = new SubsetSumRecursion();

    public static Stream<Arguments> subsetSumCases() {
        return Stream.of(
                Arguments.of(new int[]{}, 5, false),
                Arguments.of(new int[]{5}, 5, true),
                Arguments.of(new int[]{5}, 6, false),
                Arguments.of(new int[]{5, 8}, 4, false),
                Arguments.of(new int[]{5, 8}, 5, true),
                Arguments.of(new int[]{5, 8}, 8, true),
                Arguments.of(new int[]{5, 8}, 13, true),
                Arguments.of(new int[]{1, 2, 3}, 6, true),
                Arguments.of(new int[]{1, 2, 5}, 4, false),
                Arguments.of(new int[]{1, 2, 5}, 3, true),
                Arguments.of(new int[]{1, 2, 5}, 7, true),
                Arguments.of(new int[]{1, 2, 5}, 8, true),
                Arguments.of(new int[]{1, 2, 5}, 1, true),
                Arguments.of(new int[]{1, 2, 5}, 6, true),
                Arguments.of(new int[]{5, 12, 18, 25}, 37, true),
                Arguments.of(new int[]{7, 9, 13, 21}, 20, true),
                Arguments.of(new int[]{4, 6, 14, 21, 26}, 11, false),
                Arguments.of(new int[]{3, 34, 4, 12, 5, 2}, 9, true),
                Arguments.of(new int[]{3, 34, 4, 12, 5, 2}, 48, true),
                Arguments.of(new int[]{3, 34, 4, 12, 5, 2}, 12, true),
                Arguments.of(new int[]{3, 34, 4, 12, 5, 2}, 13, false),
                Arguments.of(new int[]{3, 34, 4, 12, 5, 2}, 45, true),
                Arguments.of(new int[]{3, 34, 4, 12, 5, 2}, 30, false)
        );
    }

    @ParameterizedTest
    @MethodSource("subsetSumCases")
    void shouldSolveSubsetSumProblemUsingRecursion(int[] elements, int sum, boolean expectedDoesSubsetSumExist) {
        boolean doesSubsetSumExist = subsetSumRecursion.doesSubsetSumExist(elements, sum);

        assertThat(doesSubsetSumExist)
                .isEqualTo(expectedDoesSubsetSumExist);
    }
}
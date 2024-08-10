package com.dominikcebula.algorithms.dynamic.programming.longest.increasing.subsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequenceMemoization {

    private static final int NO_VALUE = -1;

    public int findLongestIncreasingSubsequence(int[] elements) {
        if (elements.length == 0)
            return 0;

        if (elements.length == 1)
            return 1;

        int longestIncreasingSubsequence = 0;

        int[] memo = new int[elements.length];
        Arrays.fill(memo, NO_VALUE);

        for (int startIdx = 0; startIdx < elements.length; startIdx++) {
            longestIncreasingSubsequence = Math.max(
                    longestIncreasingSubsequence,
                    findLongestIncreasingSubsequence(elements, elements[startIdx], startIdx, memo) + 1
            );
        }

        return longestIncreasingSubsequence;
    }

    private int findLongestIncreasingSubsequence(int[] elements, int startElementValue, int currentElementIdx, int[] memo) {
        if (currentElementIdx == elements.length)
            return 1;

        if (memo[currentElementIdx] != NO_VALUE)
            return memo[currentElementIdx];

        int longestIncreasingSubsequence = 0;

        for (int candidateIdx = currentElementIdx + 1; candidateIdx < elements.length; candidateIdx++) {
            int candidateValue = elements[candidateIdx];

            if (candidateValue > startElementValue) {
                longestIncreasingSubsequence = Math.max(
                        longestIncreasingSubsequence,
                        findLongestIncreasingSubsequence(elements, elements[candidateIdx], candidateIdx, memo) + 1
                );
            }
        }

        memo[currentElementIdx] = longestIncreasingSubsequence;

        return longestIncreasingSubsequence;
    }
}

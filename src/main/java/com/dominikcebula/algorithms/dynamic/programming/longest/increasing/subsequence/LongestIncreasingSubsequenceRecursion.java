package com.dominikcebula.algorithms.dynamic.programming.longest.increasing.subsequence;

public class LongestIncreasingSubsequenceRecursion {
    public int findLongestIncreasingSubsequence(int[] elements) {
        if (elements.length == 0)
            return 0;

        if (elements.length == 1)
            return 1;

        int longestIncreasingSubsequence = 0;

        for (int startIdx = 0; startIdx < elements.length; startIdx++) {
            longestIncreasingSubsequence = Math.max(
                    longestIncreasingSubsequence,
                    findLongestIncreasingSubsequence(elements, elements[startIdx], startIdx) + 1
            );
        }

        return longestIncreasingSubsequence;
    }

    private int findLongestIncreasingSubsequence(int[] elements, int startElementValue, int currentElementIdx) {
        int longestIncreasingSubsequence = 0;

        for (int candidateIdx = currentElementIdx + 1; candidateIdx < elements.length; candidateIdx++) {
            int candidateValue = elements[candidateIdx];

            if (candidateValue > startElementValue) {
                longestIncreasingSubsequence = Math.max(
                        longestIncreasingSubsequence,
                        findLongestIncreasingSubsequence(elements, elements[candidateIdx], candidateIdx) + 1
                );
            }
        }

        return longestIncreasingSubsequence;
    }
}

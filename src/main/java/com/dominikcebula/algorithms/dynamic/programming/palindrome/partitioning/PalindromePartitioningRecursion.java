package com.dominikcebula.algorithms.dynamic.programming.palindrome.partitioning;

public class PalindromePartitioningRecursion {
    public int findMinCutsToGetPalindrome(String string) {
        return findMinCutsToGetPalindrome(string.toCharArray(), 0, string.length() - 1);
    }

    private int findMinCutsToGetPalindrome(char[] string, int beginIdx, int endIdx) {
        if (beginIdx == endIdx)
            return 0;

        if (isPalindrome(string, beginIdx, endIdx))
            return 0;

        int minCuts = endIdx - beginIdx;

        for (int cutIdx = beginIdx + 1; cutIdx <= endIdx; cutIdx++) {
            minCuts = Math.min(
                    minCuts,
                    findMinCutsToGetPalindrome(string, beginIdx, cutIdx - 1) +
                            findMinCutsToGetPalindrome(string, cutIdx, endIdx) + 1
            );
        }

        return minCuts;
    }

    private boolean isPalindrome(char[] string, int beginIdx, int endIdx) {
        while (beginIdx < endIdx) {
            if (string[beginIdx] != string[endIdx])
                return false;

            ++beginIdx;
            --endIdx;
        }

        return true;
    }
}

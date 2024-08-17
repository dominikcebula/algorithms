package com.dominikcebula.algorithms.dynamic.programming.palindrome.partitioning;

public class PalindromePartitioningTabulation {
    public int findMinCutsToGetPalindromes(String string) {
        return findMinCutsToGetPalindromes(string.toCharArray());
    }

    private int findMinCutsToGetPalindromes(char[] string) {
        int[][] minCuts = new int[string.length][string.length];

        for (int beginIdx = 0; beginIdx < string.length - 1; beginIdx++) {
            for (int endIdx = beginIdx + 1; endIdx < string.length; endIdx++) {
                if (isPalindrome(string, beginIdx, endIdx)) {
                    minCuts[beginIdx][endIdx] = 0;
                } else {
                    minCuts[beginIdx][endIdx] = Integer.MAX_VALUE;
                    for (int cutIdx = beginIdx; cutIdx < endIdx; cutIdx++) {
                        minCuts[beginIdx][endIdx] = Math.min(
                                minCuts[beginIdx][endIdx],
                                1 + minCuts[beginIdx][cutIdx] + minCuts[cutIdx + 1][endIdx]
                        );
                    }
                }
            }
        }

        return minCuts[0][string.length - 1];
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

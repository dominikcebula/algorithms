package com.dominikcebula.algorithms.dynamic.programming.longest.common.subsequence;

import com.dominikcebula.algorithms.utils.ArrayUtils;

public class LongestCommonSubsequenceMemoization {
    private static final int NO_VALUE = -1;

    public int findLongestCommonSubsequence(String string1, String string2) {
        int[][] memo = new int[string1.length() + 1][string2.length() + 1];
        ArrayUtils.fill2d(memo, NO_VALUE);

        return findLongestCommonSubsequence(string1, 0, string2, 0, memo);
    }

    private int findLongestCommonSubsequence(String string1, int string1Idx, String string2, int string2Idx, int[][] memo) {
        if (memo[string1Idx][string2Idx] != NO_VALUE)
            return memo[string1Idx][string2Idx];

        if (string1Idx == string1.length() || string2Idx == string2.length()) {
            memo[string1Idx][string2Idx] = 0;
            return 0;
        }

        int longestCommonSubsequence;

        if (string1.charAt(string1Idx) == string2.charAt(string2Idx))
            longestCommonSubsequence = findLongestCommonSubsequence(string1, string1Idx + 1, string2, string2Idx + 1, memo) + 1;
        else
            longestCommonSubsequence = Math.max(
                    findLongestCommonSubsequence(string1, string1Idx, string2, string2Idx + 1, memo),
                    findLongestCommonSubsequence(string1, string1Idx + 1, string2, string2Idx, memo)
            );

        memo[string1Idx][string2Idx] = longestCommonSubsequence;
        return longestCommonSubsequence;
    }
}

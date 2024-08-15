package com.dominikcebula.algorithms.dynamic.programming.longest.palindromic.subsequence;

import com.dominikcebula.algorithms.utils.ArrayUtils;

public class LongestPalindromicSubsequenceMemoization {

    private static final int NO_VALUE = -1;

    public int findLongestPalindromicSubsequence(String string) {
        if (string.isEmpty())
            return 0;

        int[][] memo = new int[string.length()][string.length()];
        ArrayUtils.fill2d(memo, NO_VALUE);

        return findLongestPalindromicSubsequence(string.toCharArray(), 0, string.length() - 1, memo);
    }

    private int findLongestPalindromicSubsequence(char[] string, int beginIdx, int endIdx, int[][] memo) {
        if (memo[beginIdx][endIdx] != NO_VALUE)
            return memo[beginIdx][endIdx];

        if (isSingleCharacterString(beginIdx, endIdx)) {
            memo[beginIdx][endIdx] = 1;
            return 1;
        }

        if (isDoubleCharacterString(beginIdx, endIdx) && charactersAreTheSame(string, beginIdx, endIdx)) {
            memo[beginIdx][endIdx] = 2;
            return 2;
        }

        if (charactersAreTheSame(string, beginIdx, endIdx)) {
            int palindromicSubsequenceLength = findLongestPalindromicSubsequence(string, beginIdx + 1, endIdx - 1, memo) + 2;
            memo[beginIdx][endIdx] = palindromicSubsequenceLength;
            return palindromicSubsequenceLength;
        } else {
            int palindromicSubsequenceLength = Math.max(
                    findLongestPalindromicSubsequence(string, beginIdx + 1, endIdx, memo),
                    findLongestPalindromicSubsequence(string, beginIdx, endIdx - 1, memo)
            );
            memo[beginIdx][endIdx] = palindromicSubsequenceLength;
            return palindromicSubsequenceLength;
        }
    }

    private boolean isSingleCharacterString(int beginIdx, int endIdx) {
        return beginIdx == endIdx;
    }

    private boolean isDoubleCharacterString(int beginIdx, int endIdx) {
        return endIdx - beginIdx == 1;
    }

    private boolean charactersAreTheSame(char[] string, int beginIdx, int endIdx) {
        return string[beginIdx] == string[endIdx];
    }
}

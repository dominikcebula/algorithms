package com.dominikcebula.algorithms.dynamic.programming.longest.palindromic.subsequence;

public class LongestPalindromicSubsequenceRecursion {
    public int findLongestPalindromicSubsequence(String string) {
        if (string.isEmpty())
            return 0;

        return findLongestPalindromicSubsequence(string.toCharArray(), 0, string.length() - 1);
    }

    private int findLongestPalindromicSubsequence(char[] string, int beginIdx, int endIdx) {
        if (isSingleCharacterString(beginIdx, endIdx))
            return 1;

        if (isDoubleCharacterString(beginIdx, endIdx) && charactersAreTheSame(string, beginIdx, endIdx))
            return 2;

        if (charactersAreTheSame(string, beginIdx, endIdx)) {
            return findLongestPalindromicSubsequence(string, beginIdx + 1, endIdx - 1) + 2;
        } else {
            return Math.max(
                    findLongestPalindromicSubsequence(string, beginIdx + 1, endIdx),
                    findLongestPalindromicSubsequence(string, beginIdx, endIdx - 1)
            );
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

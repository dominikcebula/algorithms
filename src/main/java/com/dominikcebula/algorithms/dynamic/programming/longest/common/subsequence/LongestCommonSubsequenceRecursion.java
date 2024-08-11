package com.dominikcebula.algorithms.dynamic.programming.longest.common.subsequence;

public class LongestCommonSubsequenceRecursion {
    public int findLongestCommonSubsequence(String string1, String string2) {
        return findLongestCommonSubsequence(string1, 0, string2, 0);
    }

    private int findLongestCommonSubsequence(String string1, int string1Idx, String string2, int string2Idx) {
        if (string1Idx == string1.length() || string2Idx == string2.length()) return 0;

        if (string1.charAt(string1Idx) == string2.charAt(string2Idx))
            return findLongestCommonSubsequence(string1, string1Idx + 1, string2, string2Idx + 1) + 1;
        else
            return Math.max(findLongestCommonSubsequence(string1, string1Idx, string2, string2Idx + 1), findLongestCommonSubsequence(string1, string1Idx + 1, string2, string2Idx));
    }
}

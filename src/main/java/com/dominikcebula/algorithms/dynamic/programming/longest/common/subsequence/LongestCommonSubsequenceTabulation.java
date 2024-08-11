package com.dominikcebula.algorithms.dynamic.programming.longest.common.subsequence;

public class LongestCommonSubsequenceTabulation {
    public int findLongestCommonSubsequence(String string1, String string2) {
        int[][] subsequencesLengths = new int[string1.length() + 1][string2.length() + 1];

        for (int string1Idx = 0; string1Idx < string1.length(); string1Idx++) {
            for (int string2Idx = 0; string2Idx < string2.length(); string2Idx++) {
                if (string1.charAt(string1Idx) == string2.charAt(string2Idx)) {
                    subsequencesLengths[string1Idx + 1][string2Idx + 1] =
                            subsequencesLengths[string1Idx][string2Idx] + 1;
                } else {
                    subsequencesLengths[string1Idx + 1][string2Idx + 1] = Math.max(
                            subsequencesLengths[string1Idx + 1][string2Idx],
                            subsequencesLengths[string1Idx][string2Idx + 1]
                    );
                }
            }
        }

        return subsequencesLengths[string1.length()][string2.length()];
    }
}

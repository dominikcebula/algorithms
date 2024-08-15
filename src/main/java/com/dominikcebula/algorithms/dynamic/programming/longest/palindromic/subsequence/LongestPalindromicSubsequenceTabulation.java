package com.dominikcebula.algorithms.dynamic.programming.longest.palindromic.subsequence;

public class LongestPalindromicSubsequenceTabulation {
    public int findLongestPalindromicSubsequence(String string) {
        return findLongestPalindromicSubsequence(string.toCharArray(), reverse(string).toCharArray());
    }

    private int findLongestPalindromicSubsequence(char[] string, char[] reversedString) {
        int[][] palindromicSubsequences = new int[string.length + 1][reversedString.length + 1];

        for (int beingIdx = 1; beingIdx <= string.length; beingIdx++) {
            for (int endIdx = 1; endIdx <= reversedString.length; endIdx++) {
                if (string[beingIdx - 1] == reversedString[endIdx - 1])
                    palindromicSubsequences[beingIdx][endIdx] = palindromicSubsequences[beingIdx - 1][endIdx - 1] + 1;
                else
                    palindromicSubsequences[beingIdx][endIdx] = Math.max(
                            palindromicSubsequences[beingIdx - 1][endIdx],
                            palindromicSubsequences[beingIdx][endIdx - 1]
                    );
            }
        }

        return palindromicSubsequences[string.length][reversedString.length];
    }

    private String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }
}

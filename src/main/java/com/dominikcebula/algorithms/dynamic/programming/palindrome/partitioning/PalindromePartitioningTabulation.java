package com.dominikcebula.algorithms.dynamic.programming.palindrome.partitioning;

public class PalindromePartitioningTabulation {
    public int findMinCutsToGetPalindromes(String string) {
        return findMinCutsToGetPalindromes(string.toCharArray());
    }

    private int findMinCutsToGetPalindromes(char[] string) {
        int[][] minCuts = new int[string.length][string.length];
        boolean[][] palindromes = new boolean[string.length][string.length];

        initializeSingleCharPalindromes(string, minCuts, palindromes);
        calculateCuts(string, minCuts, palindromes);

        return minCuts[0][string.length - 1];
    }

    private void initializeSingleCharPalindromes(char[] string, int[][] minCuts, boolean[][] palindromes) {
        for (int sameCharIndex = 0; sameCharIndex < string.length; sameCharIndex++) {
            minCuts[sameCharIndex][sameCharIndex] = 0;
            palindromes[sameCharIndex][sameCharIndex] = true;
        }
    }

    private void calculateCuts(char[] string, int[][] minCuts, boolean[][] palindromes) {
        for (int candidateLength = 2; candidateLength <= string.length; candidateLength++) {
            for (int beginIdx = 0; beginIdx + candidateLength - 1 < string.length; beginIdx++) {
                int endIdx = beginIdx + candidateLength - 1;

                updatePalindromesForCandidate(string, palindromes, candidateLength, beginIdx, endIdx);
                updateCutsForCandidate(minCuts, palindromes, beginIdx, endIdx);
            }
        }
    }

    private void updatePalindromesForCandidate(char[] string, boolean[][] palindromes, int candidateLength, int beginIdx, int endIdx) {
        if (candidateLength == 2)
            palindromes[beginIdx][endIdx] = string[beginIdx] == string[endIdx];
        else
            palindromes[beginIdx][endIdx] = string[beginIdx] == string[endIdx] && palindromes[beginIdx + 1][endIdx - 1];
    }

    private void updateCutsForCandidate(int[][] minCuts, boolean[][] palindromes, int beginIdx, int endIdx) {
        if (palindromes[beginIdx][endIdx]) {
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

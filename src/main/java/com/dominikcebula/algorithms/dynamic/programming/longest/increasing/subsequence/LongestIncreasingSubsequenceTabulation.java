package com.dominikcebula.algorithms.dynamic.programming.longest.increasing.subsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequenceTabulation {

    private static final int DEFAULT_SEQUENCE_LENGTH_OF_ONE = 1;

    public int findLongestIncreasingSubsequence(int[] elements) {
        int[] sequenceLengths = new int[elements.length];
        Arrays.fill(sequenceLengths, DEFAULT_SEQUENCE_LENGTH_OF_ONE);

        for (int currentIdx = 1; currentIdx < elements.length; currentIdx++) {
            for (int prevIdx = 0; prevIdx < currentIdx; prevIdx++) {
                int currentElementValue = elements[currentIdx];
                int prevElementValue = elements[prevIdx];

                if (currentElementValue > prevElementValue) {
                    sequenceLengths[currentIdx] = Math.max(
                            sequenceLengths[currentIdx],
                            sequenceLengths[prevIdx] + 1
                    );
                }
            }
        }

        return Arrays.stream(sequenceLengths).max().orElse(0);
    }
}

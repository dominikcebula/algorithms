package com.dominikcebula.algorithms.dynamic.programming.rod.cutting;

import com.dominikcebula.algorithms.utils.ArrayUtils;

public class RodCuttingMemoization {

    private static final int NO_VALUE = -1;

    public int findMaxCuttingRodValue(int[] prices) {
        int rodLength = prices.length;
        int[][] memo = new int[prices.length][rodLength + 1];
        ArrayUtils.fill2d(memo, NO_VALUE);

        return findMaxCuttingRodValue(prices, prices.length - 1, rodLength, memo);
    }

    private int findMaxCuttingRodValue(int[] prices, int currentIndex, int rodLength, int[][] memo) {
        int currentPieceLength = currentIndex + 1;

        if (currentIndex < 0)
            return 0;

        if (currentPieceLength == 1)
            return rodLength * prices[currentIndex];

        if (memo[currentIndex][rodLength] != NO_VALUE)
            return memo[currentIndex][rodLength];

        int maxCuttingRodValue;

        if (currentPieceLength > rodLength)
            maxCuttingRodValue = findMaxCuttingRodValue(prices, currentIndex - 1, rodLength, memo);
        else
            maxCuttingRodValue = Math.max(
                    prices[currentIndex] + findMaxCuttingRodValue(prices, currentIndex, rodLength - currentPieceLength, memo),
                    findMaxCuttingRodValue(prices, currentIndex - 1, rodLength, memo)
            );

        memo[currentIndex][rodLength] = maxCuttingRodValue;
        return maxCuttingRodValue;
    }
}

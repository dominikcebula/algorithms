package com.dominikcebula.algorithms.dynamic.programming.rod.cutting;

public class RodCuttingRecursion {
    public int findMaxCuttingRodValue(int[] prices) {
        int rodLength = prices.length;

        return findMaxCuttingRodValue(prices, prices.length - 1, rodLength);
    }

    private int findMaxCuttingRodValue(int[] prices, int currentIndex, int rodLength) {
        int currentPieceLength = currentIndex + 1;

        if (currentIndex < 0)
            return 0;

        if (currentPieceLength == 1) {
            return rodLength * prices[currentIndex];
        }

        if (currentPieceLength > rodLength)
            return findMaxCuttingRodValue(prices, currentIndex - 1, rodLength);
        else
            return Math.max(
                    prices[currentIndex] + findMaxCuttingRodValue(prices, currentIndex, rodLength - currentPieceLength),
                    findMaxCuttingRodValue(prices, currentIndex - 1, rodLength)
            );
    }
}

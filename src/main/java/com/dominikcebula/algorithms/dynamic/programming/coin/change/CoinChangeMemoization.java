package com.dominikcebula.algorithms.dynamic.programming.coin.change;

import com.dominikcebula.algorithms.utils.ArrayUtils;

public class CoinChangeMemoization {
    private static final int NO_VALUE = -1;

    public int countCoinCombinationsToMakeGivenSum(int sum, int[] coinDenominations) {
        int[][] memo = new int[sum + 1][coinDenominations.length + 1];
        ArrayUtils.fill2d(memo, NO_VALUE);

        return countCoinCombinationsToMakeGivenSum(sum, coinDenominations, 0, memo);
    }

    private int countCoinCombinationsToMakeGivenSum(int sum, int[] coinDenominations, int currentCoinIdx, int[][] memo) {
        if (sum == 0)
            return 1;

        if (sum < 0)
            return 0;

        if (memo[sum][currentCoinIdx] != NO_VALUE)
            return memo[sum][currentCoinIdx];

        if (currentCoinIdx >= coinDenominations.length)
            return 0;

        int nextCoinIdx = currentCoinIdx + 1;
        int numberOfCombinationsWithoutSelectingCurrentCoin = countCoinCombinationsToMakeGivenSum(sum, coinDenominations, nextCoinIdx, memo);

        int currentCoinValue = coinDenominations[currentCoinIdx];
        int sumDecreasedBySelectedCurrentCoinValue = sum - currentCoinValue;
        int numberOfCombinationsIncludingCurrentCoin = countCoinCombinationsToMakeGivenSum(sumDecreasedBySelectedCurrentCoinValue, coinDenominations, currentCoinIdx, memo);

        int numberOfCombinationsForGivenSum = numberOfCombinationsWithoutSelectingCurrentCoin + numberOfCombinationsIncludingCurrentCoin;
        memo[sum][currentCoinIdx] = numberOfCombinationsForGivenSum;

        return numberOfCombinationsForGivenSum;
    }
}

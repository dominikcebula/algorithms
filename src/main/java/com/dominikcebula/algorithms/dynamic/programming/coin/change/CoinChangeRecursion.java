package com.dominikcebula.algorithms.dynamic.programming.coin.change;

public class CoinChangeRecursion {
    public int countCoinCombinationsToMakeGivenSum(int sum, int[] coinDenominations) {
        return countCoinCombinationsToMakeGivenSum(sum, coinDenominations, 0);
    }

    private int countCoinCombinationsToMakeGivenSum(int sum, int[] coinDenominations, int currentCoinIdx) {
        if (sum == 0)
            return 1;

        if (sum < 0)
            return 0;

        if (currentCoinIdx >= coinDenominations.length)
            return 0;

        int nextCoinIdx = currentCoinIdx + 1;
        int numberOfCombinationsWithoutSelectingCurrentCoin = countCoinCombinationsToMakeGivenSum(sum, coinDenominations, nextCoinIdx);

        int currentCoinValue = coinDenominations[currentCoinIdx];
        int sumDecreasedBySelectedCurrentCoinValue = sum - currentCoinValue;
        int numberOfCombinationsIncludingCurrentCoin = countCoinCombinationsToMakeGivenSum(sumDecreasedBySelectedCurrentCoinValue, coinDenominations, currentCoinIdx);

        return numberOfCombinationsWithoutSelectingCurrentCoin + numberOfCombinationsIncludingCurrentCoin;
    }
}

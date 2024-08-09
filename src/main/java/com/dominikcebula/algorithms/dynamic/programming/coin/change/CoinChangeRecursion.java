package com.dominikcebula.algorithms.dynamic.programming.coin.change;

public class CoinChangeRecursion {
    public int countCoinCombinationsToMakeGivenSum(int sum, int[] coinDenominations) {
        return countCoinCombinationsToMakeGivenSum(sum, coinDenominations, 0);
    }

    private int countCoinCombinationsToMakeGivenSum(int sum, int[] coinDenominations, int currentCoin) {
        if (sum == 0)
            return 1;

        if (sum < 0)
            return 0;

        if (currentCoin >= coinDenominations.length)
            return 0;

        return countCoinCombinationsToMakeGivenSum(sum - coinDenominations[currentCoin], coinDenominations, currentCoin)
                + countCoinCombinationsToMakeGivenSum(sum, coinDenominations, currentCoin + 1);
    }
}

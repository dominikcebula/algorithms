package com.dominikcebula.algorithms.dynamic.programming.coin.change;

public class CoinChangeTabulation {
    private static final int ONE_COMBINATION_FOR_ZERO_COINS = 1;

    public int countCoinCombinationsToMakeGivenSum(int sum, int[] coinDenominations) {
        int[][] coinCombinations = new int[coinDenominations.length + 1][sum + 1];

        coinCombinations[0][0] = ONE_COMBINATION_FOR_ZERO_COINS;

        for (int coinDenominationIdx = 0; coinDenominationIdx < coinDenominations.length; coinDenominationIdx++) {
            int coinCombinationsIdx = coinDenominationIdx + 1;

            for (int combinationSum = 0; combinationSum <= sum; combinationSum++) {
                int numberOfCombinationsWithoutSelectingCurrentCoin = coinCombinations[coinCombinationsIdx - 1][combinationSum];
                coinCombinations[coinCombinationsIdx][combinationSum] += numberOfCombinationsWithoutSelectingCurrentCoin;

                int coinDenominationValue = coinDenominations[coinDenominationIdx];
                int decreasedSumIdxWhenSelectingCurrentCoin = combinationSum - coinDenominationValue;
                if (decreasedSumIdxWhenSelectingCurrentCoin >= 0) {
                    int numberOfCombinationsIncludingCurrentCoin = coinCombinations[coinCombinationsIdx][decreasedSumIdxWhenSelectingCurrentCoin];
                    coinCombinations[coinCombinationsIdx][combinationSum] += numberOfCombinationsIncludingCurrentCoin;
                }
            }
        }

        return coinCombinations[coinDenominations.length][sum];
    }
}

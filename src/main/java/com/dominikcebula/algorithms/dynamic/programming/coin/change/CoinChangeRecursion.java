package com.dominikcebula.algorithms.dynamic.programming.coin.change;

public class CoinChangeRecursion {
    public int solve(int sum, int[] coinDenominations) {
        return solve(sum, coinDenominations, 0);
    }

    private int solve(int sum, int[] coinDenominations, int currentCoin) {
        if (sum == 0)
            return 1;

        if (sum < 0)
            return 0;

        if (currentCoin >= coinDenominations.length)
            return 0;

        return solve(sum - coinDenominations[currentCoin], coinDenominations, currentCoin)
                + solve(sum, coinDenominations, currentCoin + 1);
    }
}

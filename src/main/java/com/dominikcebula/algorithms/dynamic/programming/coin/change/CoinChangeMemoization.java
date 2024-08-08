package com.dominikcebula.algorithms.dynamic.programming.coin.change;

import com.dominikcebula.algorithms.utils.ArrayUtils;

public class CoinChangeMemoization {
    private static final int NO_VALUE = -1;

    public int solve(int sum, int[] coinDenominations) {
        int[][] memo = new int[sum + 1][coinDenominations.length + 1];
        ArrayUtils.fill2d(memo, NO_VALUE);

        return solve(sum, coinDenominations, 0, memo);
    }

    private int solve(int sum, int[] coinDenominations, int currentCoin, int[][] memo) {
        if (sum == 0)
            return 1;

        if (sum < 0)
            return 0;

        if (memo[sum][currentCoin] != NO_VALUE)
            return memo[sum][currentCoin];

        if (currentCoin >= coinDenominations.length)
            return 0;

        return memo[sum][currentCoin] = solve(sum - coinDenominations[currentCoin], coinDenominations, currentCoin, memo)
                + solve(sum, coinDenominations, currentCoin + 1, memo);
    }
}

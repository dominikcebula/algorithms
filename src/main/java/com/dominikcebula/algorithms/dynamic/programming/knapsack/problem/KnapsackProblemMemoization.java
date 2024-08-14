package com.dominikcebula.algorithms.dynamic.programming.knapsack.problem;

import com.dominikcebula.algorithms.utils.ArrayUtils;

public class KnapsackProblemMemoization {
    private static final int NO_VALUE = -1;

    public int findMaxProfit(int[] profits, int[] weights, int itemCount, int bagCapacity) {
        int[][] memo = new int[itemCount][bagCapacity + 1];
        ArrayUtils.fill2d(memo, NO_VALUE);

        return findMaxProfit(profits, weights, itemCount, bagCapacity, memo);
    }

    private int findMaxProfit(int[] profits, int[] weights, int itemCount, int bagCapacity, int[][] memo) {
        if (itemCount <= 0 || bagCapacity <= 0)
            return 0;

        int currentItemIdx = itemCount - 1;

        if (memo[currentItemIdx][bagCapacity] != NO_VALUE)
            return memo[currentItemIdx][bagCapacity];

        if (weights[currentItemIdx] > bagCapacity) {
            int maxProfit = findMaxProfit(profits, weights, currentItemIdx, bagCapacity, memo);
            memo[currentItemIdx][bagCapacity] = maxProfit;
            return maxProfit;
        } else {
            int maxProfit = Math.max(
                    findMaxProfit(profits, weights, currentItemIdx, bagCapacity, memo),
                    profits[currentItemIdx] + findMaxProfit(profits, weights, currentItemIdx, bagCapacity - weights[currentItemIdx], memo)
            );
            memo[currentItemIdx][bagCapacity] = maxProfit;
            return maxProfit;
        }
    }
}

package com.dominikcebula.algorithms.dynamic.programming.knapsack.problem;

public class KnapsackProblemRecursion {
    public int findMaxProfit(int[] profits, int[] weights, int itemCount, int bagCapacity) {
        if (itemCount <= 0 || bagCapacity <= 0)
            return 0;

        int currentItemIdx = itemCount - 1;

        if (weights[currentItemIdx] > bagCapacity)
            return findMaxProfit(profits, weights, currentItemIdx, bagCapacity);
        else
            return Math.max(
                    findMaxProfit(profits, weights, currentItemIdx, bagCapacity),
                    profits[currentItemIdx] + findMaxProfit(profits, weights, currentItemIdx, bagCapacity - weights[currentItemIdx])
            );
    }
}

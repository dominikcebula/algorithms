package com.dominikcebula.algorithms.dynamic.programming.knapsack.problem;

public class KnapsackProblemRecursion {
    public int findMaxProfit(int[] profits, int[] weights, int itemCount, int bagCapacity) {
        if (itemCount <= 0 || bagCapacity <= 0)
            return 0;

        if (weights[itemCount - 1] > bagCapacity)
            return findMaxProfit(profits, weights, itemCount - 1, bagCapacity);
        else
            return Math.max(
                    findMaxProfit(profits, weights, itemCount - 1, bagCapacity),
                    profits[itemCount - 1] + findMaxProfit(profits, weights, itemCount - 1, bagCapacity - weights[itemCount - 1])
            );
    }
}

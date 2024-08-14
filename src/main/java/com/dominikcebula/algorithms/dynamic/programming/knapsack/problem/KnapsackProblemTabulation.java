package com.dominikcebula.algorithms.dynamic.programming.knapsack.problem;

public class KnapsackProblemTabulation {
    public int findMaxProfit(int[] profits, int[] weights, int itemCount, int bagCapacity) {
        int[][] bags = new int[itemCount][bagCapacity + 1];

        initializeZeroCapacityBagVector(itemCount, bags);
        initializeOneItemInBagVector(profits, weights, bagCapacity, bags);

        calculateProfitsForBagsOfDifferentSizes(profits, weights, itemCount, bagCapacity, bags);

        return bags[itemCount - 1][bagCapacity];
    }

    private void initializeZeroCapacityBagVector(int itemCount, int[][] bags) {
        for (int itemIdx = 0; itemIdx < itemCount; itemIdx++)
            bags[itemIdx][0] = 0;
    }

    private void initializeOneItemInBagVector(int[] profits, int[] weights, int bagCapacity, int[][] bags) {
        for (int capacity = 1; capacity <= bagCapacity; capacity++) {
            if (capacity < weights[0])
                bags[0][capacity] = 0;
            else
                bags[0][capacity] = profits[0];
        }
    }

    private void calculateProfitsForBagsOfDifferentSizes(int[] profits, int[] weights, int itemCount, int bagCapacity, int[][] bags) {
        for (int itemIdx = 1; itemIdx < itemCount; itemIdx++) {
            for (int capacity = 1; capacity <= bagCapacity; capacity++) {
                if (capacity < weights[itemIdx])
                    bags[itemIdx][capacity] = bags[itemIdx - 1][capacity];
                else
                    bags[itemIdx][capacity] = Math.max(
                            bags[itemIdx - 1][capacity],
                            profits[itemIdx] + bags[itemIdx - 1][capacity - weights[itemIdx]]
                    );
            }
        }
    }
}

package com.dominikcebula.algorithms.dynamic.programming.min.cost.path;

import com.dominikcebula.algorithms.utils.ArrayUtils;

import java.util.stream.IntStream;

public class MinCostPathTabulation {
    private static final int NO_VALUE = -1;

    public int findMinCostPath(int[][] costs, int targetPositionM, int targetPositionN) {
        int[][] minCosts = new int[costs.length][costs[0].length];

        ArrayUtils.fill2d(minCosts, NO_VALUE);
        minCosts[0][0] = costs[0][0];

        for (int row = 1; row <= targetPositionM; row++) {
            minCosts[row][0] = minCosts[row - 1][0] + costs[row][0];
        }

        for (int column = 1; column <= targetPositionN; column++) {
            minCosts[0][column] = minCosts[0][column - 1] + costs[0][column];
        }

        for (int row = 1; row <= targetPositionM; row++) {
            for (int column = 1; column <= targetPositionN; column++) {
                minCosts[row][column] = costs[row][column] + min(
                        minCosts[row - 1][column - 1],
                        minCosts[row][column - 1],
                        minCosts[row - 1][column]
                );
            }
        }

        return minCosts[targetPositionM][targetPositionN];
    }

    private static int min(int a, int b, int c) {
        return IntStream.of(a, b, c)
                .filter(cost -> cost != NO_VALUE)
                .min()
                .orElse(0);
    }
}

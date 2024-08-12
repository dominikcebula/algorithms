package com.dominikcebula.algorithms.dynamic.programming.min.cost.path;

import com.dominikcebula.algorithms.utils.ArrayUtils;

import java.util.stream.IntStream;

public class MinCostPathMemoization {
    private static final int NO_VALUE = -1;

    public int findMinCostPath(int[][] costs, int targetPositionM, int targetPositionN) {
        int memo[][] = new int[costs.length][costs[0].length];
        ArrayUtils.fill2d(memo, NO_VALUE);

        return findMinCostPath(costs, targetPositionM, targetPositionN, memo);
    }

    private int findMinCostPath(int[][] costs, int targetPositionM, int targetPositionN, int memo[][]) {
        if (targetPositionM < 0 || targetPositionN < 0)
            return NO_VALUE;

        if (memo[targetPositionM][targetPositionN] != NO_VALUE)
            return memo[targetPositionM][targetPositionN];

        int minCostAtPosition = costs[targetPositionM][targetPositionN] + min(
                findMinCostPath(costs, targetPositionM - 1, targetPositionN - 1, memo),
                findMinCostPath(costs, targetPositionM, targetPositionN - 1, memo),
                findMinCostPath(costs, targetPositionM - 1, targetPositionN, memo)
        );
        memo[targetPositionM][targetPositionN] = minCostAtPosition;
        return minCostAtPosition;
    }

    private static int min(int a, int b, int c) {
        return IntStream.of(a, b, c)
                .filter(cost -> cost != NO_VALUE)
                .min()
                .orElse(0);
    }
}

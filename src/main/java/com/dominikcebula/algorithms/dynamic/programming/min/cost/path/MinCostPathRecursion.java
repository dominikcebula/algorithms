package com.dominikcebula.algorithms.dynamic.programming.min.cost.path;

import java.util.stream.IntStream;

public class MinCostPathRecursion {
    private static final int NO_VALUE = -1;

    public int findMinCostPath(int[][] costs, int targetPositionM, int targetPositionN) {
        if (targetPositionM < 0 || targetPositionN < 0)
            return NO_VALUE;

        return costs[targetPositionM][targetPositionN] + min(
                findMinCostPath(costs, targetPositionM - 1, targetPositionN - 1),
                findMinCostPath(costs, targetPositionM, targetPositionN - 1),
                findMinCostPath(costs, targetPositionM - 1, targetPositionN)
        );
    }

    private static int min(int a, int b, int c) {
        return IntStream.of(a, b, c)
                .filter(cost -> cost != NO_VALUE)
                .min()
                .orElse(0);
    }
}

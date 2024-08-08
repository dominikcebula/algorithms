package com.dominikcebula.algorithms.utils;

import java.util.Arrays;

public class ArrayUtils {
    public static void fill2d(int[][] array, int value) {
        for (int[] row : array) {
            Arrays.fill(row, value);
        }
    }
}

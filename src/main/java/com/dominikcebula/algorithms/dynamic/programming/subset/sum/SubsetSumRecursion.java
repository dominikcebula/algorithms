package com.dominikcebula.algorithms.dynamic.programming.subset.sum;

public class SubsetSumRecursion {
    public boolean doesSubsetSumExist(int[] elements, int sum) {
        return doesSubsetSumExist(elements, sum, elements.length - 1);
    }

    private boolean doesSubsetSumExist(int[] elements, int sum, int currentIndex) {
        if (sum == 0)
            return true;

        if (sum < 0 || currentIndex < 0)
            return false;

        int currentElementValue = elements[currentIndex];

        return doesSubsetSumExist(elements, sum - currentElementValue, currentIndex - 1)
                || doesSubsetSumExist(elements, sum, currentIndex - 1);
    }
}

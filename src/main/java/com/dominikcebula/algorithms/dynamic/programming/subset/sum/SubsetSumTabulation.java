package com.dominikcebula.algorithms.dynamic.programming.subset.sum;

public class SubsetSumTabulation {
    public boolean doesSubsetSumExist(int[] elements, int sum) {
        Boolean[][] subsetSumExistence = new Boolean[elements.length + 1][sum + 1];

        initializeZeroSumVector(elements, subsetSumExistence);
        initializeNoMoreItemsVector(sum, subsetSumExistence);

        calculateSubsetSumExistence(elements, sum, subsetSumExistence);

        return subsetSumExistence[elements.length][sum];
    }

    private void initializeZeroSumVector(int[] elements, Boolean[][] subsetSumExistence) {
        for (int itemIndex = 0; itemIndex <= elements.length; itemIndex++) {
            subsetSumExistence[itemIndex][0] = true;
        }
    }

    private void initializeNoMoreItemsVector(int sum, Boolean[][] subsetSumExistence) {
        for (int currentSum = 1; currentSum <= sum; currentSum++)
            subsetSumExistence[0][currentSum] = false;
    }

    private void calculateSubsetSumExistence(int[] elements, int sum, Boolean[][] subsetSumExistence) {
        for (int itemIndex = 1; itemIndex <= elements.length; itemIndex++) {
            for (int currentSum = 1; currentSum <= sum; currentSum++) {
                if (elements[itemIndex - 1] > currentSum)
                    subsetSumExistence[itemIndex][currentSum] = subsetSumExistence[itemIndex - 1][currentSum];
                else
                    subsetSumExistence[itemIndex][currentSum] = subsetSumExistence[itemIndex - 1][currentSum]
                            || subsetSumExistence[itemIndex - 1][currentSum - elements[itemIndex - 1]];
            }
        }
    }
}

package com.dominikcebula.algorithms.dynamic.programming.rod.cutting;

import com.dominikcebula.algorithms.utils.ArrayUtils;

public class RodCuttingTabulation {
    public int findMaxCuttingRodValue(int[] prices) {
        final int maxRodLength = prices.length;
        final int numberOfPieces = prices.length;

        if (maxRodLength == 0)
            return 0;

        int[][] cuttingRodValue = new int[numberOfPieces][maxRodLength + 1];
        ArrayUtils.fill2d(cuttingRodValue, -1);

        initializeZeroRodLengthVector(cuttingRodValue, numberOfPieces);
        initializeOneUnitLengthPiece(cuttingRodValue, prices, maxRodLength);

        calculateCuttingRodValues(prices, numberOfPieces, maxRodLength, cuttingRodValue);

        return cuttingRodValue[numberOfPieces - 1][maxRodLength];
    }

    private void initializeZeroRodLengthVector(int[][] cuttingRodValue, int numberOfPieces) {
        final int zeroRodLengthIndex = 0;

        for (int pieceIndex = 0; pieceIndex < numberOfPieces; pieceIndex++) {
            cuttingRodValue[pieceIndex][zeroRodLengthIndex] = 0;
        }
    }

    private void initializeOneUnitLengthPiece(int[][] cuttingRodValue, int[] prices, int maxRodLength) {
        final int firstPieceIndex = 0;

        for (int rodLength = 0; rodLength <= maxRodLength; rodLength++) {
            cuttingRodValue[firstPieceIndex][rodLength] = rodLength * prices[firstPieceIndex];
        }
    }

    private void calculateCuttingRodValues(int[] prices, int numberOfPieces, int maxRodLength, int[][] cuttingRodValue) {
        for (int pieceIndex = 1; pieceIndex < numberOfPieces; pieceIndex++) {
            int pieceLength = pieceIndex + 1;
            int piecePrice = prices[pieceIndex];

            for (int rodLength = 1; rodLength <= maxRodLength; rodLength++) {
                if (pieceLength <= rodLength)
                    cuttingRodValue[pieceIndex][rodLength] = Math.max(
                            cuttingRodValue[pieceIndex - 1][rodLength],
                            piecePrice + cuttingRodValue[pieceIndex][rodLength - pieceLength]
                    );
                else
                    cuttingRodValue[pieceIndex][rodLength] = cuttingRodValue[pieceIndex - 1][rodLength];
            }
        }
    }
}

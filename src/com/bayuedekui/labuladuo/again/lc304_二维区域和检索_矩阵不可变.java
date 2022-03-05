package com.bayuedekui.labuladuo.again;

public class lc304_二维区域和检索_矩阵不可变 {
    int[][] preSum;

    public lc304_二维区域和检索_矩阵不可变(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        preSum = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];

    }
}

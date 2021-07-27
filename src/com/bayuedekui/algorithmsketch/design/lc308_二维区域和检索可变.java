package com.bayuedekui.algorithmsketch.design;

public class lc308_二维区域和检索可变 {
    int[][] arr;

    public lc308_二维区域和检索可变(int[][] matrix) {
        arr = matrix;
    }

    public void update(int row, int col, int val) {
        arr[row][col] = val;

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                res += arr[i][j];
            }
        }
        return res;
    }
}

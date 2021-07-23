package com.bayuedekui.algorithmsketch.huawei;

import java.util.Arrays;
import java.util.Queue;

public class lc304_二维区域和检索矩阵不可变 {

    int[][] arr;

    public lc304_二维区域和检索矩阵不可变(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        arr = new int[row][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j + 1] = arr[i][j] + matrix[i][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int col = arr[0].length;
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            res += arr[i][col2 + 1] - arr[i][col1];
        }
        return res;
    }
}

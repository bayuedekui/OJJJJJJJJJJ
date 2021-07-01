package com.bayuedekui.array;

public class lc85_最大矩形 {
    public int maximalRectangle(char[][] matrix) {
        //先将矩形的横排的最长的1记录好，然后在竖排方向上进行找最小横排值乘以高度
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            arr[i][0] = matrix[i][0];
            for (int j = 1; j < col; j++) {
                arr[i][j] = matrix[i][j] == '0' ? 0 : matrix[i][j - 1] + 1;
            }
        }


        //横排最小值，乘以遍历高度
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                for (int k = i - 1; k >= 0; k--) {
                    //每次取同一列上最小值
                    arr[i][j]= Math.min(arr[i][j],arr[k][j]);
                    res = Math.max(res, arr[i][j] * (i - k + 1));
                }

            }
        }

        return res;
    }
}

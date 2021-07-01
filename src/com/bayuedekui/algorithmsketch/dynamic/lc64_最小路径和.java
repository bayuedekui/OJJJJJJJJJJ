package com.bayuedekui.algorithmsketch.dynamic;

import java.util.Arrays;

public class lc64_最小路径和 {

    public int minPathSum1(int[][] grid) {
        int i = grid.length;
        int j = grid[0].length;
        mem = new int[i][j];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        return dp(grid, i - 1, j - 1);

    }

    //采用自顶向下的递归操作，一般采用一个DP函数
    int[][] mem;

    public int dp(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        if (mem[i][j] != -1) {
            return mem[i][j];
        }


        mem[i][j] = Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];

        return mem[i][j];

    }


    //采用自底向上
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        //base case
        //第一列的时候，下面的数只能有上面的数得到
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //第一行的时候，右边的数只能通过左边得到
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}

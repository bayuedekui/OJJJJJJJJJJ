package com.bayuedekui.dfsbfs;

public class lc剑指Offer13机器人的运动范围 {
    public int movingCount(int m, int n, int k) {
        int[][] arr = new int[m][n];
        int[] res = new int[1];
        dfs(0, 0, arr, res, m, n, k);
        return res[0];
    }


    public boolean isIn(int row, int col, int k) {
        return (row / 10 + row % 10 + col / 10 + col % 10) <= k;
    }

    public void dfs(int row, int col, int[][] arr, int[] res, int m, int n, int k) {
        // 当超出边界，已经访问过，当前位置不符合条件直接返回走其他方向
        if (row < 0 || row >= m || col < 0 || col >= n || arr[row][col] != 0 || !isIn(row, col, k)) {
            return;
        }

        // 标记已经访问
        arr[row][col] = 1;
        res[0]++;

        dfs(row - 1, col, arr, res, m, n, k);
        dfs(row + 1, col, arr, res, m, n, k);
        dfs(row, col - 1, arr, res, m, n, k);
        dfs(row, col + 1, arr, res, m, n, k);


    }


}

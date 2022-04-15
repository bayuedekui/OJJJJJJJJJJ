package com.bayuedekui.dfsbfs;

public class lc695_岛屿的最大面积 {
    public int maxAreaOfIsland(int[][] grid) {
        // 采用dfs:遍历遇到一个1，然后进行dfs,进行访问标记，将1置为零
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int[] tmpRes = new int[1];
                    dfs(i, j, grid, tmpRes);
                    res = Math.max(res, tmpRes[0]);
                }
            }
        }
        return res;
    }

    public void dfs(int row, int col, int[][] grid, int[] res) {
        int r = grid.length;
        int c = grid[0].length;
        if (row < 0 || row >= r || col < 0 || col >= c || grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;
        res[0]++;

        dfs(row - 1, col, grid, res);
        dfs(row + 1, col, grid, res);
        dfs(row, col + 1, grid, res);
        dfs(row, col - 1, grid, res);
    }
}

package com.bayuedekui.unionfind;

public class lc200_岛屿数量 {
    public int numIslands(char[][] grid) {
        // 采用dfs，遍历到1后，采用dfs将所有和1联通的都变成0
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(i, j, grid);
                }
            }
        }
        return res;


    }

    public void dfs(int row, int col, char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        if (row < 0 || row >= r || col < 0 || col >= c || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '0';
        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
    }
}

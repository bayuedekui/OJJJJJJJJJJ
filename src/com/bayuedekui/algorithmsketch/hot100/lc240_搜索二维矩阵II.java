package com.bayuedekui.algorithmsketch.hot100;

public class lc240_搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) {
            return false;
        }

        for (int[] mat : matrix) {
            if (mat[0] < target && mat[col - 1] > target) {
                if (binaySearch(mat, target)) {
                    return true;
                }
            }
            if (mat[0] == target || mat[col - 1] == target) {
                return true;
            }
        }
        return false;
    }

    // 二分查找
    public boolean binaySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == arr[mid]) {
                return true;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}

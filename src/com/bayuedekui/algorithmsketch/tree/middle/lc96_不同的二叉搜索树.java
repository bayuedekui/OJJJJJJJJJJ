package com.bayuedekui.algorithmsketch.tree.middle;

public class lc96_不同的二叉搜索树 {
    int[][] arr;

    public int numTrees(int n) {
        arr = new int[n + 1][n + 1];
        return traceBack(1, n);
    }


    public int traceBack(int start, int end) {
        if (start > end) {
            return 1;
        }
        if(arr[start][end]!=0){
            return arr[start][end];
        }

        int res = 0;
        for (int i = start; i <= end; i++) {
            int left = traceBack(start, i - 1);
            int right = traceBack(i + 1, end);
            res += left * right;
        }
        arr[start][end] = res;
        return res;
    }
}

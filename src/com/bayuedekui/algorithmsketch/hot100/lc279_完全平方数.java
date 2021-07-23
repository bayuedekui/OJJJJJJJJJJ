package com.bayuedekui.algorithmsketch.hot100;

public class lc279_完全平方数 {
    public int numSquares(int n) {
        if (n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}

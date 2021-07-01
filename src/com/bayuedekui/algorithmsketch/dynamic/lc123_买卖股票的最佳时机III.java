package com.bayuedekui.algorithmsketch.dynamic;

public class lc123_买卖股票的最佳时机III {
    //只可以买卖2次,每一种的情况不一样，所以需要穷举
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }

        int maxK = 2;

        int[][][] dp = new int[len][maxK + 1][2];

        for (int i = 0; i < len; i++) {
            for (int k = maxK; k >= 1; k--) {
                if (i - 1 == -1) {
                    for (int t = 1; t <= k; t++) {
                        dp[i][k-t][0]=0;
                        dp[i][k - t][1] = -prices[i];
                    }
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }

        }
        return dp[len - 1][maxK][0];

    }
}

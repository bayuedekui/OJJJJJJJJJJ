package com.bayuedekui.algorithmsketch.dynamic;

public class lc122_买卖股票的最佳时机II {
    //可以买卖无数次
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }

        int[][] dp = new int[len][2];

        //base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] - prices[i]);
        }
        return dp[len - 1][0];

    }
}

package com.bayuedekui.algorithmsketch.dynamic;

public class lc188_买卖股票的最佳时机IV {
    //最多完成k比交易
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int[][][] dp = new int[len][k + 1][2];
        k = Math.min(k, len / 2);

        for (int i = 0; i < len; i++) {
            for (int j = k; j >= 1; j--) {
                //base case
                if (i - 1 == -1) {
                    for (int t = 0; t < j; t++) {
                        dp[i][j - t][0] = 0;
                        dp[i][j - t][1] = -prices[i];
                    }
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[len - 1][k][0];


    }
}

package com.bayuedekui.algorithmsketch.dynamic;

public class lc309_最佳买卖股票时机含冷冻期 {

    //有冷冻期1天，且是无限次数购买
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }

        int[][] dp = new int[len][2];


        for (int i = 0; i < len; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            if(i - 2 == -1) {
                dp[i][0] = Math.max(prices[i]-prices[i-1],0);
                dp[i][1] = Math.max(-prices[i], -prices[i - 1]);
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[len - 1][0];

    }
}

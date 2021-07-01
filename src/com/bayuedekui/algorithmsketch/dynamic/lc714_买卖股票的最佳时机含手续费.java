package com.bayuedekui.algorithmsketch.dynamic;

public class lc714_买卖股票的最佳时机含手续费 {
    //可以无限次购买，不过每一次都要支付手续费
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int[][] dp = new int[len][2];

        for (int i = 0; i < len; i++) {
            if(i-1==-1){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];

    }
}

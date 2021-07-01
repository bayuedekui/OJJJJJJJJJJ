package com.bayuedekui.algorithmsketch.dynamic;

public class lc121_买卖股票的最佳时机 {

    //只可以买卖一次
    public int maxProfit(int[] prices) {
        //采用动态规划的思想dp[第几天][允许买卖几次股票][是否持有股票0/1]
        //dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prives[i])
        //dp[i][1]=Math.max(dp[i-1][1]dp[i-1][0]-prices[i])
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int[][] dp = new int[len][2];

        //base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];


        //状态转移
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i-1][0]-prices[i]);//因为是只能买一次，所以没买的情况只能0-prices[i]
            dp[i][1] = Math.max(dp[i - 1][1], dp[i-1][0]-prices[i]);
        }
        return dp[len - 1][0];


    }
}

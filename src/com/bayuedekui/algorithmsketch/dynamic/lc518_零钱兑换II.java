package com.bayuedekui.algorithmsketch.dynamic;

public class lc518_零钱兑换II {
    public int change(int amount, int[] coins) {
        //0-1背包的问题状态转移方程有Math.max--->dp[i-1][j]+dp[i-1][j-nums[i-1]]
        int len = coins.length;

        int[][] dp = new int[len + 1][amount + 1];
        //base case
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    //背包放不下
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //背包能放下,可以不放（dp[i-1][j]）,放入，因为用了硬币(dp[i][j-coins[i-1]])
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[len][amount];

    }
}

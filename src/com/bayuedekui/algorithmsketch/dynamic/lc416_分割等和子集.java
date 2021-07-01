package com.bayuedekui.algorithmsketch.dynamic;

public class lc416_分割等和子集 {
    public boolean canPartition(int[] nums) {
        //将nums中的数和除以2，转化为背包的概念
        //转化成0-1背包问题，dp[i][j]=true/false,表示以第i个数结束，往容量为j的包中是否能正好装满
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 0) {
            sum = sum / 2;
        } else {
            return false;
        }

        boolean[][] dp = new boolean[len + 1][sum + 1];

        //base case
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < nums[i - 1]) {
                    //背包不能放下
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //背包能放下,可以选择放/不放，最终结果取决于：不放（dp[i-1][j]）   放(确认【i-1】【j-nums[i-1]】能放下，那dp[i][j]肯定也能放下)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len][sum];
    }
}

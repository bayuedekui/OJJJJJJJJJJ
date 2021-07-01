package com.bayuedekui.algorithmsketch.dynamic;

import sun.nio.cs.ext.MacHebrew;

public class lc213_打家劫舍II {
    public int rob(int[] nums) {
        //采用自底向上的dp
        int len = nums.length;
        return Math.max(dp(nums, 0, len - 2), dp(nums, 1, len - 1));

    }

    //采用自底向上的dp
    public int dp(int[] nums, int start, int end) {
        int len = nums.length;
        int[] dp = new int[len + 2];

        for (int i = end; i >= start; i--) {
            //今天偷（然后后天才可以偷），今天不偷（明天可以偷）
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[start];
    }


}

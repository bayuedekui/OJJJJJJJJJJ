package com.bayuedekui.algorithmsketch.dynamic;

public class lc53_最大子序和 {
    public int maxSubArray(int[] nums) {
        //dp定义还是一样，dp[i]表示以第i个数结尾，存储最大子数组和
        //状态转移方程有变化，不在是在dp[i-1]基础上加1，而是math.max(dp[i],nums[i]+dp[i-1]):自成一派/同前一个最长子数组融合
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        //base case:dp[0]=nums[0]
        dp[0] = nums[0];

        //状态转移方程
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i], nums[i] + dp[i - 1]);
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

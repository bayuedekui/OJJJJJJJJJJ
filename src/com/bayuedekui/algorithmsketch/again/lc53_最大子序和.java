package com.bayuedekui.algorithmsketch.again;

public class lc53_最大子序和 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        // 采用动态规划的方法dp[i]=max(dp[i-1]+nums[i],nums[i])
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

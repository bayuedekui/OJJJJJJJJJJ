package com.bayuedekui.algorithmsketch.dynamic;

import java.util.Arrays;

public class lc198_打家劫舍 {

    //自顶向下dp
    public int rob(int[] nums) {
        int len = nums.length;
        mem = new int[len];
        Arrays.fill(mem, -1);
        return dp(nums, 0);

    }

    //自顶向下DP
    int[] mem;

    public int dp(int[] nums, int start) {
        //dp(nums,i)从i位置开始小偷能偷到的最多的钱
        if (start >= nums.length) {
            return 0;
        }

        if (mem[start] != -1) {
            return mem[start];
        }

        //start今天不偷，就可以偷明天的，start今天偷了，就只能偷后天的
        int res = Math.max(dp(nums, start + 1), dp(nums, start + 2) + nums[start]);
        mem[start] = res;

        return res;

    }

    //自底向上
    public int rob1(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len+2];//

        //base case default dp[len],dp[len+1]=0

        for (int i = len-1; i >=0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];

    }
}

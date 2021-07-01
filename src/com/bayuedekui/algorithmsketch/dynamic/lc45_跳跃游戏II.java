package com.bayuedekui.algorithmsketch.dynamic;

import org.junit.Test;

import java.util.Arrays;

public class lc45_跳跃游戏II {
    public int jump(int[] nums) {
        //dp[i]表示当前位置走到末尾最少需要的步数
        //dp[i]=min(dp[i],dp[j]+1)

        int len = nums.length;
        int[] dp = new int[len];

        //base case
        Arrays.fill(dp, len);
        dp[len - 1] = 0;

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= len - 1) {
                    dp[i] = 1;
                } else {
                    dp[i] = Math.min(dp[i], dp[i + j] + 1);
                }
            }
        }

        return dp[0];

    }


    //采用贪心
    public int jumpTan(int[] nums) {
        int len = nums.length;

        int farthest = 0;
        int end = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                res++;
                end = farthest;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}

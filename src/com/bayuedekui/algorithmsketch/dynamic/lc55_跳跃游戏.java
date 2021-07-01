package com.bayuedekui.algorithmsketch.dynamic;

public class lc55_跳跃游戏 {


    //采用动态规划
    public boolean canJump(int[] nums) {
        //dp[i]表示第i个位置是否可以到达
        //dp[i]=dp[j]&&(nums[j]+j>=i)
        int len = nums.length;
        boolean[] dp = new boolean[len];
        //base case
        dp[0] = true;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && (nums[j] + j) >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len - 1];

    }


    //采用贪心，每次选择最大的距离
    public boolean canJumpTraceback(int[] nums) {
        int len = nums.length;
        int farthest = 0;

        //遍历一次数组，每次找到最远距离，最后判断是否最远距离大于最后
        for (int i = 0; i < len; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            //可能碰到了0，直接返回false
            if (farthest <= i) {
                return false;
            }
        }

        return farthest >= len - 1;

    }
}

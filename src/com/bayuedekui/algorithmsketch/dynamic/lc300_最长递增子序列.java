package com.bayuedekui.algorithmsketch.dynamic;

import java.util.Arrays;

public class lc300_最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        //dp[i]表示以第i个数结尾的最长子序列的值
        int len = nums.length;
        int[] dp = new int[len];

        //base case
        Arrays.fill(dp, 1);

        //开始自顶向上的dp
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    //变种：并列举出最长子序列
    public int lengthOfLISWithStr(int[] nums) {
        //dp[i]表示以第i个数结尾的最长子序列的值
        int len = nums.length;
        int[] dp = new int[len];
        String[] dpStr = new String[len];

        //base case
        Arrays.fill(dp, 1);
        dpStr[0] = nums[0]+"";

        //开始自顶向上的dp
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    dpStr[i] = dpStr[j] + "" + nums[i];
                }else{
                    dpStr[i] = dpStr[j];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dpStr[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

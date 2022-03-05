package com.bayuedekui.singlestack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class lc2104_子数组范围和 {
    public long subArrayRanges(int[] nums) {
        // 我想到的时穷举所有的子数组，然后取出最大最小进行做差
        // 先将nums按照升序排序，长度为二的子数组开始，取出nums[j]与numsd[j+i-1]进行做差求和
        int len = nums.length;

        // dp数组用于存储从left到right的最大值和最小值，dp[l][r][0]表示最小值，dp[l][r][1]表示最大值
        int[][][] dp = new int[len][len][2];

        // 当l==r时，dp[i][i][0]=dp[i][i][1]=nums[i]
        for (int i = 0; i < len; i++) {
            dp[i][i][0] = nums[i];
            dp[i][i][1] = nums[i];
        }

        // 统计所有子数组（用l和r进行区间划分）的最大值与最小值
        for (int sub = 2; sub <= len; sub++) {
            for (int l = 0; l + sub - 1 < len; l++) {
                int r = l + sub - 1;
                dp[l][r][0] = Math.min(nums[r], dp[l][r - 1][0]);
                dp[l][r][1] = Math.max(nums[r], dp[l][r - 1][1]);
            }
        }

        // 计算所有子数组中最大值和最小值之差的和
        long res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                res += dp[i][j][1] - dp[i][j][0];
            }
        }

        return res;
    }


    public long subArrayRanges2(int[] nums) {
        // 采用暴力，穷举每一个子数组出来
        int len = nums.length;
        long res = 0;
        for (int sub = 2; sub <= len; sub++) {
            for (int l = 0; l + sub - 1 < len; l++) {
                int[] tmp = Arrays.copyOfRange(nums, l, l + sub);
                Arrays.sort(tmp);
                res += tmp[sub - 1] - tmp[0];
            }
        }
        return res;
    }
}

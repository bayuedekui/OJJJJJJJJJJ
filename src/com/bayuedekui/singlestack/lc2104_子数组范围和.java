package com.bayuedekui.singlestack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class lc2104_子数组范围和 {
    // 先存字典法
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

    // 采用变量代替dp数组的方法
    public long subArrayRanges3(int[] nums) {
        int len = nums.length;
        int res = 0;
        // 因为dp[l][r][0/1]只和l,r-1相关，所以用min变量和max变量替代dp数组
        for (int i = 0; i < len; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i + 1; j < len; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += max - min;
            }
        }
        return res;
    }


    // 暴力法
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

    // 采用单调栈的方法
    public long subArrayRanges4(int[] nums) {
        // 计算出nums的所有子数组最小值之和和最大值之和，然后用最大值之和减去最小之和
        int len = nums.length;
        int[] minLeft = new int[len];
        int[] minRight = new int[len];
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];

        Stack<Integer> stack = new Stack<>();
        // 寻找nums[i]为最大值时的左边界
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            maxLeft[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        // 寻找nums[i]为最大值的右边界
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            maxRight[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }

        stack.clear();
        // 寻找nums[i]作为最小值的左边界
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            minLeft[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        // 寻找nums[i]作为最小值的右边界
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            minRight[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }

        long minSum = 0;
        long maxSum = 0;
        for (int i = 0; i < len; i++) {
            minSum +=  ((long) (i - minLeft[i]) * (minRight[i] - i)) * nums[i];
            maxSum +=  ((long) (i - maxLeft[i]) * (maxRight[i] - i)) * nums[i];
        }
        System.out.println("minSum："+minSum);
        System.out.println("maxSum："+maxSum);
        return maxSum - minSum;
    }


}

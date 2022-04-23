package com.bayuedekui.slidewindow;

import org.junit.Test;

public class lc930_和相同的二元子数组 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // 滑动窗口:先将goal的个数满足，然后找左边0的个数和右边零的个数，然后两个相乘就是当前范围能提供的数
        int len = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = 0;
        while (right < len) {
            sum += nums[right++];
            if (sum == goal) {
                // 计算右边的零个数
                int tmpr = right;
                while (right < len && nums[right] == 0) {
                    right++;
                }
                int rcnt = right - tmpr;

                // 计算左边的零
                int tmpl = left;
                while (left < right && nums[left] == 0) {
                    left++;
                }
                int lcnt = left - tmpl;

                res += (lcnt + 1) * (rcnt + 1);

                sum -= nums[left];
                left++;
            }

        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
    }
}

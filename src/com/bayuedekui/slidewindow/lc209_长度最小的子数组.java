package com.bayuedekui.slidewindow;

public class lc209_长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int len = nums.length;
        int left = 0;
        int right = 0;
        int newl = -1;
        int newr = len;
        while (right < len) {
            int c = nums[right];
            right++;
            sum += c;

            while (left < right && sum >= target) {
                if ((newr - newl) >= (right - left)) {
                    newr = right;
                    newl = left;
                }
                int d = nums[left];
                left++;
                sum -= d;
            }

        }

        return newl == -1 ? 0 : (newr - newl);

    }
}

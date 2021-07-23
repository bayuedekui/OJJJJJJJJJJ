package com.bayuedekui.algorithmsketch.again;

public class lc152_乘积最大子数组 {
    public int maxProduct(int[] nums) {
        // 因为有负号的乘法，所有要用可能存在最大也可能存在最小
        // 用两个变量分别存最大，最小值
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] max = new int[len];
        int[] min = new int[len];
        max[0] = min[0] = nums[0];
        for (int i = 1; i < len; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(min[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(min[i - 1] * nums[i], Math.min(max[i - 1] * nums[i], nums[i]));
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, max[i]);
        }
        return res;

    }
}

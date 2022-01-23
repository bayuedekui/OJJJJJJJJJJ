package com.bayuedekui.labuladuo;

public class lc42_接雨水 {
    // 先采用备忘录写法
    public int trap(int[] height) {
        int len = height.length;
        int[] lMax = new int[len];
        int[] rMax = new int[len];

        lMax[0] = height[0];
        rMax[len - 1] = height[len - 1];

        for (int i = 1; i < len; i++) {
            lMax[i] = Math.max(lMax[i - 1], height[i]);
        }

        for (int i = len - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            res += Math.min(lMax[i], rMax[i]) - height[i];
        }

        return res;

    }

    // 采用左右指针
    public int trap2(int[] height) {
        // 过会重写
        int len = height.length;
        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len - 1;
        int lMax = height[0];
        int rMax = height[len - 1];
        int res = 0;
        while (left <= right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);
            if (lMax < rMax) {
                res += lMax - height[left];
                left++;
            } else {
                res += rMax - height[right];
                right--;
            }
        }
        return res;

    }


}

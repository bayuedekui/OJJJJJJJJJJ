package com.bayuedekui.labuladuo.again;

public class lc42_接雨水 {
    public int trap(int[] height) {
        // 找到左边比当前高和右边比当前高的，然后取左右最高小的那个减去当前
        int len = height.length;
        int[] lmax = new int[len];
        int[] rmax = new int[len];
        lmax[0] = height[0];
        rmax[len - 1] = height[len - 1];

        // 找到比当前i左边高的数，如果自身最高就取自生
        for (int i = 1; i < len; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }

        // 找到比当前i右边高的数，如果自身最高就取自生
        for (int i = len - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            res += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return res;
    }
}

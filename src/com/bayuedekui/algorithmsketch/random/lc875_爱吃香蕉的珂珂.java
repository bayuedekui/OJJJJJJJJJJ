package com.bayuedekui.algorithmsketch.random;

public class lc875_爱吃香蕉的珂珂 {
    public int minEatingSpeed(int[] piles, int h) {
        // 计算二分查找中的最大值
        int len = piles.length;
        int maxVal = 0;
        for (int i = 0; i < len; i++) {
            maxVal = Math.max(maxVal, piles[i]);
        }
        int left = 1;
        int right = maxVal;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // int mid=(left+right)/2
            if (calc(piles, mid) > h) {
                //速度慢了
                left = mid + 1;
            } else {
                // 速度快le
                right = mid;
            }
        }
        return left;

    }

    public int calc(int[] piles, int speed) {
        int res = 0;
        for (int pile : piles) {
            res += (pile + speed - 1) / speed;
        }
        return res;
    }
}

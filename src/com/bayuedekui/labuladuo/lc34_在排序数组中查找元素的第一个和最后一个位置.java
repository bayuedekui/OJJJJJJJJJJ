package com.bayuedekui.labuladuo;

public class lc34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        return new int[2];
    }

    public int left(int[] nums, int target) {
        // 采用二分法
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 判断越界情况
        if (nums[left] != target && left == 0 || left <= nums.length) {
            return -1;
        }
        return left;
    }

}

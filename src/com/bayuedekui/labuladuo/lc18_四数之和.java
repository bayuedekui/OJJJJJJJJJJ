package com.bayuedekui.labuladuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc18_四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSumTarget(nums, 4, 0, target);
    }

    // 采用递归法
    public List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || len < n) {
            return res;
        }
        if (n == 2) {
            int low = start;
            int hi = len - 1;
            while (low < hi) {
                int left = nums[low];
                int right = nums[hi];
                int sum = left + right;
                if (sum < target) {
                    while (low < hi && nums[low] == left) {
                        low++;
                    }
                } else if (sum > target) {
                    while (low < hi && nums[hi] == right) {
                        hi--;
                    }
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(left);
                    tmp.add(right);
                    res.add(tmp);
                    while (low < hi && nums[low] == left) {
                        low++;
                    }
                    while (low < hi && nums[hi] == right) {
                        hi--;
                    }
                }
            }
        } else {
            for (int i = start; i < len; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> su : sub) {
                    su.add(nums[i]);
                    res.add(su);
                }
                while (i < len - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}

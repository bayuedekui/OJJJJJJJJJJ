package com.bayuedekui.labuladuo.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc18_四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 0, 4, target);
    }


    public List<List<Integer>> nSum(int[] nums, int start, int n, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (n < 2 || len < n) {
            return res;
        }

        if (n == 2) {
            int left = start;
            int right = len - 1;
            while (left < right) {
                int low = nums[left];
                int hi = nums[right];
                int sum = low + hi;
                if (left < right && sum < target) {
                    left++;
                } else if (left < right && sum > target) {
                    right--;
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(low);
                    tmp.add(hi);
                    res.add(tmp);
                    while (left < right && nums[left] == low) {
                        left++;
                    }
                    while (left < right && nums[right] == hi) {
                        right--;
                    }
                }
            }
        } else {
            for (int i = start; i < len; i++) {
                List<List<Integer>> sub = nSum(nums, i + 1, n - 1, target - nums[i]);
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

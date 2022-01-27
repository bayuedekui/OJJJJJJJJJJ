package com.bayuedekui.labuladuo;

import org.junit.Test;

import java.lang.annotation.Target;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc15_三数之和 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nSum(nums, 3, 0, 0);
    }


    // 采用递归方式实现n的个数和
    public List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || len < n) {
            return res;
        }
        if (n == 2) {
            int low = start, hi = len - 1;
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
                List<List<Integer>> sub = nSum(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> su : sub) {
                    su.add(nums[i]);
                    res.add(su);
                }
                while (i < len -1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }


    // 开发两数之和
    public void twoSum(int[] nums, int start, int target) {
        int len = nums.length;
        int low = start + 1;
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
                // 得到结果，需要存入
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[start]);
                tmp.add(left);
                tmp.add(right);
                list.add(tmp);
                while (low < hi && nums[low] == left) {
                    low++;
                }
                while (low < hi && nums[hi] == right) {
                    hi--;
                }
            }
        }
    }


    @Test
    public void test() {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));

    }

}

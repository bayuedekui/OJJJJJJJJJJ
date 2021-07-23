package com.bayuedekui.algorithmsketch.hot100;

public class lc494_目标和 {
    public int findTargetSumWays(int[] nums, int target) {
        // 采用回溯法，递归求取相应的和
        traceBack(nums, target, 0, 0);
        return count;
    }

    int count = 0;

    public void traceBack(int[] nums, int target, int index, int sum) {
        // 字符串中所有的都要用上
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {

            traceBack(nums, target, index + 1, sum + nums[index]);
            traceBack(nums, target, index + 1, sum - nums[index]);
        }
    }
}

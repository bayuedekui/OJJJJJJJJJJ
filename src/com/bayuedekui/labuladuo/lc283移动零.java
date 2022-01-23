package com.bayuedekui.labuladuo;

public class lc283移动零 {
    public void moveZeroes(int[] nums) {
        // 相当于删除指定数字零，然后剩下的补充零
        int len = nums.length;
        int slow = 0, fast = 0;
        while (fast < len) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (; slow < len; slow++) {
            nums[slow] = 0;
        }
    }
}

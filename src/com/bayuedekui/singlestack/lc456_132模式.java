package com.bayuedekui.singlestack;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Stack;

public class lc456_132模式 {
    /*public boolean find132pattern(int[] nums) {
        // 暴力法：遍历出所有可能存在的3个数，然后进行比较，for循环控制i,然后比较对应数大小
        int len = nums.length;
        for (int i = 0; i <= len - 3; i++) {
            for (int j = i + 1; j <= len - 2; j++) {
                for (int k = j + 1; k <= len - 1; k++) {
                    if(nums[i]<nums[k]&&nums[k]<nums[j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }*/

    public boolean find132pattern(int[] nums) {
        // 采用单调栈的性质，在单调栈中维护一个递减的，当来一个元素时，如果比栈顶元素大，则栈顶出栈，
        // 大的元素入栈，这样保证了栈顶是最大，然后弹出的元素次之，记为k，然后遍历过程中遇到比k小的元素后
        // 则出现132模式
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        // 将k的初始值尽量设置小，然后遇到大的就更换，将k的值越大，这样月容易找到结果
        int k = Integer.MIN_VALUE;
        // 从后往前遍历，否则会将前面过小的提前弹出丢失，导致最后找不到最小j
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                k = Math.max(k, stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }
}

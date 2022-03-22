package com.bayuedekui.singlestack;

import java.util.Arrays;
import java.util.Stack;

public class lc42_接雨水 {
    public int trap(int[] height) {
        // 核心点就是找到每个点的左边最大值，右边最大值
        // 采用每个位置从找出左边最大的和右边最大的，然后取两边中的最小的与当前值进行做差求和，最终就是结果
        // 采用单调栈思想
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        Stack<Integer> stack = new Stack<>();
        stack.push(height[0]);
        // 找到左边最大的值
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && stack.peek() <= height[i]) {
                stack.pop();
            }
            leftMax[i] = stack.isEmpty() ? height[i] : stack.peek();
            if (!stack.isEmpty() && stack.peek() >= height[i]) {
                continue;
            }
            stack.push(height[i]);
        }
        stack.clear();
        stack.push(height[len - 1]);
        // 找到右边最大的值
        for (int i = len - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < height[i]) {
                stack.pop();
            }
            rightMax[i] = stack.isEmpty() ? height[i] : stack.peek();
            if (!stack.isEmpty() && stack.peek() >= height[i]) {
                continue;
            }
            stack.push(height[i]);
        }

        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));

        return res;
    }


    public int trap1(int[] height) {
        // 核心找出1-len-2范围内的的左边最大值和右边最大值，然后取最下的
        int len = height.length;
        int[] lmax = new int[len];
        int[] rmax = new int[len];
        lmax[0] = height[0];
        rmax[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            lmax[i] = Math.max(height[i], lmax[i - 1]);
        }

        for (int i = len - 2; i >= 0; i--) {
            rmax[i] = Math.max(height[i], rmax[i + 1]);
        }
        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            res += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return res;
    }

}

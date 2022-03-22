package com.bayuedekui.singlestack;

import java.util.Stack;

public class lc84_柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        // heights[i]找到左边第一个比heights[i]小的下标，存入left下标数组中
        // heights[i]找到右边第一个比heights[i]大的下标，存入right下标数组中
        // 以每个heights[i]为高度，right-left作为宽，计算矩形面积，然后去最大值
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            // 当左边遇到比heights[i]大的数的时候，继续向左寻找，直到找到左边第一个比height[i]小的数，然后停止寻找，进行left[i]的赋值
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // 当stack为空的时候，表示左边的数一直比heights[i]大，所以左边第一个比heights[i]小的数下表为-1
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            // 当右边遇到比heights[i]大的数的时候，继续向右寻找，直到找到第一个比heights[i]小的数，然后停驶寻找，进行right[i]的赋值
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }
            // 当stack为空的时候，表示heights[i]右边的数都是比heights[i]大的，所有右边第一个比heights[i]小的下标为len
            right[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            //   |
            // | |   这种类型求i=0结果   （2-（-1）+1）*1

            // |
            // | |   这种类型求i=0结果   （1-（-1）+1）*2
            // 所以要右边下标-左边下标+1
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;

    }
}

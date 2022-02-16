package com.bayuedekui.labuladuo.queorstack;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lc215_数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        //请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
        // 意思是和数字大小顺序无关，主要是升序排序数据后的倒数第k个数
        Arrays.sort(nums);

        // 通过，本题还是主要理解题目意思,
        return nums[nums.length - k + 1];
    }

    // 采用有限队列
    public int findKthLargest1(int[] nums, int k) {
        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            while (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}

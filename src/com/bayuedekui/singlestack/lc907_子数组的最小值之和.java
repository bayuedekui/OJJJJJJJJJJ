package com.bayuedekui.singlestack;

import java.util.PriorityQueue;

public class lc907_子数组的最小值之和 {
    public int sumSubarrayMins(int[] arr) {
        // 尝试用暴力法，用个小顶堆接受每一轮子数组的数量，然后弹出顶上最小的
        int len = arr.length;
        int res = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= len - i; j++) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for (int k = j; k < j + i; k++) {
                    pq.offer(arr[k]);
                }
                res = res + pq.poll();
            }
        }

        return res % 100000007;
    }
}

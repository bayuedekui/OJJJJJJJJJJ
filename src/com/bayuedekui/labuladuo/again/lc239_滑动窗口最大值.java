package com.bayuedekui.labuladuo.again;

import org.junit.Test;

import java.util.*;

public class lc239_滑动窗口最大值 {
    class SelfQueue {
        Deque<Integer> deque = new LinkedList<>();

        // 来一个数将队列中比这个数小的数全部移除
        public void offer(int x) {
            while (!deque.isEmpty() && deque.peekLast() < x) {
                deque.pollLast();
            }

            deque.offerLast(x);

        }

        public void poll(int x) {
            if (deque.peekFirst() == x) {
                deque.pollFirst();
            }
        }

        public int max() {
            return deque.peekFirst();
        }

    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        SelfQueue sq = new SelfQueue();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                sq.offer(nums[i]);
            } else {
                sq.offer(nums[i]);
                list.add(sq.max());
                sq.poll(nums[i - k + 1]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {-7, -8, 7, 5, 7, 1, 6, 0};
        System.out.println(maxSlidingWindow(arr, 4));
    }



}

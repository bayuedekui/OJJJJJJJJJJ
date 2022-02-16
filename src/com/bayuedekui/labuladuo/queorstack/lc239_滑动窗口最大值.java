package com.bayuedekui.labuladuo.queorstack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc239_滑动窗口最大值 {
    class SelfQueue {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int x) {
            // 插入的时候将所有比x小的都剔除
            while (!deque.isEmpty() && deque.peekLast() < x) {
                deque.pollLast();
            }
            deque.offerLast(x);
        }

        public int max() {
            return deque.peekFirst();
        }

        public void pop(int t) {
            // 如果deque的头没有该数则不返回
            if (!deque.isEmpty() && deque.peekFirst() == t) {
                deque.pollFirst();
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        SelfQueue selfQueue = new SelfQueue();
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i < k - 1) {
                selfQueue.push(nums[i]);
            } else {
                selfQueue.push(nums[i]);
                res.add(selfQueue.max());
                selfQueue.pop(nums[i - k + 1]);
            }
        }

        int size = res.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    @Test
    public void test() {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(maxSlidingWindow(arr, 3));
    }


}

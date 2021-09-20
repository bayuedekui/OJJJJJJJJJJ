package com.bayuedekui.algorithmsketch.design;

import java.util.Deque;
import java.util.LinkedList;

public class lc1381_设计一个支持增量操作的栈 {
    Deque<Integer> deque;
    int maxSize;
    Deque<Integer> tmp;

    public lc1381_设计一个支持增量操作的栈(int maxSize) {
        deque = new LinkedList<>();
        tmp = new LinkedList<>();
        this.maxSize = maxSize;

    }

    public void push(int x) {
        if (deque.size() < maxSize) {
            deque.offerFirst(x);
        }

    }

    public int pop() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.pollFirst();

    }

    public void increment(int k, int val) {
        for (int i = 1; i <= k; i++) {
            if (deque.isEmpty()) {
                break;
            } else {
                tmp.offerFirst(deque.pollLast() + val);
            }
        }
        while (!tmp.isEmpty()) {
            deque.offerLast(tmp.pollFirst());
        }
    }
}

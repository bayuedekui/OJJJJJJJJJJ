package com.bayuedekui.algorithmsketch.design;

import java.util.*;

public class lc155_最小栈 {

    Deque<Integer> deque;
    Deque<Integer> minDeque;

    /**
     * initialize your data structure here.
     */
    public lc155_最小栈() {
        deque = new LinkedList<>();
        minDeque = new LinkedList<>();
        minDeque.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        deque.push(val);
        minDeque.push(Math.min(minDeque.peek(), val));
    }

    public void pop() {
        deque.pop();
        minDeque.pop();
    }

    public int top() {
        return deque.peek();
    }

    public int getMin() {
        return minDeque.peek();
    }
}

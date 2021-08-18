package com.bayuedekui.algorithmsketch.design;

import java.util.Deque;
import java.util.LinkedList;

public class lc622_设计循环队列 {
    Deque<Integer> deque;
    int size;

    public lc622_设计循环队列(int k) {
        size = k;
        deque = new LinkedList<>();
    }

    public boolean enQueue(int value) {
        if (deque.size() < size) {
            deque.offerLast(value);
            return true;
        }
        return false;

    }

    public boolean deQueue() {
        if (deque.size() == 0) {
            return false;
        }
        deque.pollFirst();
        return true;

    }

    public int Front() {
        if(deque.isEmpty()){
            return -1;
        }
        return deque.peekFirst();
    }

    public int Rear() {
        if(deque.isEmpty()){
            return -1;
        }
        return deque.peekLast();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.size() == size;
    }
}

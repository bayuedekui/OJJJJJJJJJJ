package com.bayuedekui.algorithmsketch.design;

import java.util.Deque;
import java.util.LinkedList;

public class lc641_设计循环双端队列 {
    Deque<Integer> deque;
    int size;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public lc641_设计循环双端队列(int k) {
        size = k;
        deque = new LinkedList<>();

    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (deque.size() < size) {
            deque.offerFirst(value);
            return true;
        }
        return false;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (deque.size() < size) {
            deque.offerLast(value);
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (deque.isEmpty()) {
            return false;
        }
        deque.pollFirst();
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (deque.isEmpty()) {
            return false;
        }
        deque.pollLast();
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();

    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekLast();

    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return deque.size() == size;

    }
}

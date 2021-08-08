package com.bayuedekui.algorithmsketch.design;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class lc284_顶端迭代器 {

    Deque<Integer> deque;

    public lc284_顶端迭代器(Iterator<Integer> iterator) {
        // initialize any member here.
        deque = new LinkedList<>();
        while (iterator.hasNext()) {
            deque.offerLast(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return deque.peekFirst();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
//    @Override
    public Integer next() {
        return deque.pollFirst();
    }

    //    @Override
    public boolean hasNext() {
        System.out.println(deque);
        return deque.isEmpty();
    }
}

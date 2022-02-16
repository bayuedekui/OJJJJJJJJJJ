package com.bayuedekui.labuladuo.queorstack;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class lc295_数据流的中位数 {
    // 采用两个优先级队列
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> big;
    int cnt;


    public lc295_数据流的中位数() {
        //采用两个优先级队列，如果两个队列个数相同则是偶数，需要两个队列各吐出进行除二，个数不一样，就从big小顶堆吐出
        // small是大顶堆
        small = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // big是小顶堆
        big = new PriorityQueue<>();
        cnt = 0;
    }

    public void addNum(int num) {
        cnt++;
        small.offer(num);
        // 如何保持两个队列个数只相差0个数或者1个数
        while ((cnt / 2 + cnt % 2) != big.size()) {
            big.offer(small.poll());
        }

        if (small.size() == big.size()) {
            big.offer(small.poll());
            small.offer(big.poll());
        }
        System.out.println(small);
        System.out.println(big);
        System.out.println(cnt);
        System.out.println();

    }

    public double findMedian() {
        if (small.size() == big.size()) {
            return (small.peek() + big.peek()) / 2.0D;
        } else {
            return (double) big.peek();
        }

    }
}

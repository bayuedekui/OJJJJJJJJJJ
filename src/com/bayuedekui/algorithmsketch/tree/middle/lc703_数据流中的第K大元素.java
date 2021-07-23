package com.bayuedekui.algorithmsketch.tree.middle;

import java.util.PriorityQueue;

public class lc703_数据流中的第K大元素 {

    PriorityQueue<Integer> que;
    int tmp;

    public lc703_数据流中的第K大元素(int k, int[] nums) {
        que = new PriorityQueue<>();
        tmp=k;
        for (int i : nums) {
            add(i);
        }

    }

    public int add(int val) {
        que.offer(val);
        if (que.size() > tmp) {
            que.poll();
        }
        return que.peek();
    }
}

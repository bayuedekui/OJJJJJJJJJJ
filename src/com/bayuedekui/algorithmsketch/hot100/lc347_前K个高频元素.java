package com.bayuedekui.algorithmsketch.hot100;

import java.util.*;

public class lc347_前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        // 用一个map存储（key，出现次数），然后遍历排序
        // 用一个优先队列存储，设置queue按照指定方式排序
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : nums) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        // 队列中放入数组int[0]:key,int[1]:value
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        // 遍历map,将值传入相关的优先队列中（小顶堆）
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            // 当优先队列中的数量已经大于k,则需要将最小的次数剔除队列
            if (queue.size() == k) {
                // 只有当队列最小的值小于value后，才需要将aueue中值吐出，新的值进入
                if (queue.peek()[1] < value) {
                    queue.poll();
                    queue.offer(new int[]{key, value});
                }

            } else {
                // queue没有到达容量时，无脑插入
                queue.offer(new int[]{key, value});
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}

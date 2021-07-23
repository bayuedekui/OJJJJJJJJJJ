package com.bayuedekui.algorithmsketch.hot100;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

public class lc621_任务调度器 {
    public int leastInterval(char[] tasks, int n) {
        // 采用将任务按照最多的平铺到第一列，
        // 结果：(maxExec-1)*(n+1)+maxCount
        int maxExec = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            int times = map.getOrDefault(c, 0) + 1;
            map.put(c, times);
            maxExec = Math.max(maxExec, times);
        }

        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxExec) {
                maxCount++;
            }
        }

        return Math.max(tasks.length, (maxExec - 1) * (n + 1) + maxCount);

    }
}

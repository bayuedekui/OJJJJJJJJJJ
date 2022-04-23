package com.bayuedekui.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class lc904_水果成篮 {
    public int totalFruit(int[] fruits) {
        // 滑动窗口：使用一个map存储对应的果树种类，如果超过2就需要缩小窗口
        int len = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < len) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            right++;

            // 缩小窗口
            while (map.keySet().size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}

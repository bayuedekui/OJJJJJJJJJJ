package com.bayuedekui.slidewindow;

import java.util.HashMap;
import java.util.*;

public class lc187_重复的DNA序列 {
    public List<String> findRepeatedDnaSequences(String s) {
        // 先枚举处出来长度为10的子字符串，然后存入map中记录次数
        // 然后遍历次数，超过1的计入结果中
        Map<String, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len - 10; i++) {
            String key = s.substring(i, i + 10);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<String> res = new ArrayList<>();
        // 遍历map,找出value大于1的
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;

    }
}

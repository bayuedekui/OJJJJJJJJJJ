package com.bayuedekui.algorithmsketch.design;

import java.util.*;

public class lc911_在线选举 {
    Map<Integer, Integer> map = new TreeMap<>();

    public lc911_在线选举(int[] persons, int[] times) {
        int len = times.length;
        for (int i = 0; i < len; i++) {
            map.put(times[i], calcHigher(persons, i));
        }
    }

    public int calcHigher(int[] pers, int index) {
        Map<Integer, Integer> tmp = new HashMap<>();
        //将值放入map中
        for (int i = 0; i <= index; i++) {
            tmp.put(pers[i], tmp.getOrDefault(pers[i], 0) + 1);
        }
        //找出最大值
        int max = 0;
        Set<Map.Entry<Integer, Integer>> entries = tmp.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            max = Math.max(max, entry.getValue());
        }

        //找出key
        int maxPer = 0;
        for (int i = index; i >= 0; i--) {
            if (tmp.get(pers[i]) == max) {
                maxPer = pers[i];
                break;
            }
        }
        return maxPer;
    }

    public int q(int t) {
        Set<Integer> keys = map.keySet();
        List<Integer> list = new ArrayList<>();
        for (int k : keys) {
            list.add(k);
        }
        Collections.sort(list);
        int res = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == t || (list.get(i) < t && list.get(i + 1) > t)) {
                res = map.get(list.get(i));
                break;
            }
        }
        return res;
    }
}

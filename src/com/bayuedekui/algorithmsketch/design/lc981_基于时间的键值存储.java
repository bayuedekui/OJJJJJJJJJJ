package com.bayuedekui.algorithmsketch.design;

import java.util.*;

public class lc981_基于时间的键值存储 {
    Map<String, Map<Integer, String>> map;


    /**
     * Initialize your data structure here.
     */
    public lc981_基于时间的键值存储() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Map<Integer, String> old = map.get(key);
        if (old != null) {
            old.put(timestamp, value);
            map.put(key, old);
        } else {
            Map<Integer, String> tmp = new HashMap<>();
            tmp.put(timestamp, value);
            map.put(key, tmp);
        }
        System.out.println(map);
    }

    public String get(String key, int timestamp) {
        Map<Integer, String> values = map.get(key);
        System.out.println("values==="+values);
        Set<Integer> timestamps = values.keySet();
        List<Integer> list = new ArrayList<>();
        for (int time : timestamps) {
            list.add(time);
        }
        Collections.sort(list);

        //采用二分查找
        int idx = binarySearch(list, timestamp);
        System.out.println("idx==="+idx);
        if (idx != -1) {
            return values.get(idx);
        }

        return "";
    }


    public int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        if (list.get(left) > target) {
            return -1;
        }

        if (list.get(right) <= target) {
            return list.get(right);
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) == target) {
                return list.get(mid);
            } else if (list.get(mid) < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (list.get(left) <= target) {
            return list.get(left);
        } else {
            return list.get(left - 1);
        }


    }


}

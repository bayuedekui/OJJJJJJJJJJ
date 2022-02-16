package com.bayuedekui.labuladuo.queorstack;

import java.util.LinkedHashMap;

public class lc146_LRU缓存 {
    int capacity;
    LinkedHashMap<Integer, Integer> lhm;

    public lc146_LRU缓存(int capacity) {
        this.capacity = capacity;
        lhm = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (lhm.get(key) == null) {
            return -1;
        }
        // 将该（key,value）置成最新
        makeRecent(key);

        return lhm.get(key);
    }

    public void put(int key, int value) {
        if (lhm.containsKey(key)) {
            lhm.put(key, value);
            makeRecent(key);
            return;
        }

        if (lhm.size() >= capacity) {
            // 先退出一个，再加入
            Integer out = lhm.keySet().iterator().next();
            lhm.remove(out);
        }
        lhm.put(key, value);
    }

    public void makeRecent(int key) {
        Integer val = lhm.get(key);
        lhm.remove(key);
        lhm.put(key, val);
    }
}

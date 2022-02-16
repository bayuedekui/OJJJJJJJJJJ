package com.bayuedekui.labuladuo.queorstack;

import java.util.*;

public class lc460_LFU缓存 {
    // 记录key,value
    HashMap<Integer, Integer> keyToVal;
    // 记录频率对应的key列表
    HashMap<Integer, List<Integer>> freqToKey;
    // 每个key对应的使用频率
    HashMap<Integer, Integer> keyToFreq;

    int capacity;
    int minFreq;

    public lc460_LFU缓存(int capacity) {
        this.capacity = capacity;
        keyToVal = new HashMap<>();
        freqToKey = new HashMap<>();
        keyToFreq = new HashMap<>();
        minFreq = 0;
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (keyToVal.get(key) != null) {
            // key的使用频率增加1
            int freq = keyToFreq.get(key);
            keyToFreq.put(key, freq + 1);
            // 老的频率对应keys剔除key
            List<Integer> freqKeys = freqToKey.get(freq);
            freqKeys.remove((Integer.valueOf(key)));
            if (freqKeys.isEmpty()) {
                freqToKey.remove(freq);
                if(minFreq==freq){
                    minFreq++;
                }
            } else {
                freqToKey.put(freq, freqKeys);
            }
            // 创建新的频率对应key
            List<Integer> newKeys = freqToKey.getOrDefault(freq + 1, new ArrayList<>());
            newKeys.add(key);
            freqToKey.put(freq + 1, newKeys);

            return keyToVal.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        // 先判断是否有
        if (keyToVal.containsKey(key)) {
            // 更新（key,val）
            keyToVal.put(key, value);
            // 更新（freq,cnt）
            int freq = keyToFreq.get(key);
            keyToFreq.put(key, freq + 1);
            // 剔除老频率中的key
            List<Integer> oldFreqKeys = freqToKey.get(freq);
            oldFreqKeys.remove(Integer.valueOf(key));
            if (oldFreqKeys.isEmpty()) {
                freqToKey.remove(freq);
                if (minFreq == freq) {
                    minFreq++;
                }
            } else {
                freqToKey.put(freq, oldFreqKeys);
            }
            // 存储新频率对应值
            List<Integer> newKeys = freqToKey.getOrDefault(freq + 1, new ArrayList<>());
            newKeys.add(key);
            freqToKey.put(freq + 1, newKeys);
        } else {
            // 不包含情况，判断容量
            if (capacity <= keyToVal.size()) {
                // 找出使用频率最低的key,以及freq
                int delKey = 0;
                // 如果同一个频率的有多个，去最近不适用的
                delKey = freqToKey.get(minFreq).get(0);
                // 删除（key,val）
                keyToVal.remove(delKey);
                // 删除（key,freq）
                keyToFreq.remove(delKey);
                // 删除（freq,cnt）
                List<Integer> modifyKeys = freqToKey.get(minFreq);
                modifyKeys.remove(Integer.valueOf(delKey));
                if (modifyKeys.isEmpty()) {
                    freqToKey.remove(minFreq);
                } else {
                    freqToKey.put(minFreq, modifyKeys);
                }
            }
            // 直接插入(key,val)
            keyToVal.put(key, value);
            // 插入（key,freq）
            keyToFreq.put(key, keyToFreq.getOrDefault(key, 0) + 1);
            // 插入（freq,cnt）
            List<Integer> newFreq = freqToKey.getOrDefault(1, new ArrayList<>());
            newFreq.add(key);
            freqToKey.put(1, newFreq);
            minFreq = 1;
        }
    }


    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> freqToKey = new HashMap<>();

        freqToKey.put(1, new ArrayList<>(1));
        List<Integer> newKeys = freqToKey.putIfAbsent(2, 1);
        System.out.println(newKeys);

    }

}

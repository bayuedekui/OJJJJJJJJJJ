package com.bayuedekui.algorithmsketch.design;

import org.junit.Test;

import java.util.*;

public class lc1429_第一个唯一数字 {
    // 该方法超时
    /*List<Integer> list;
    Map<Integer, Integer> map;


    public lc1429_第一个唯一数字(int[] nums) {
        list = new ArrayList<>();
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println("init");

    }

    public int showFirstUnique() {
        // 顺序遍历list中，如果list中在map查到的为1则返回
        for (int i = 0; i < list.size(); i++) {
            if (map.get(list.get(i)) == 1) {
                return list.get(i);
            }
        }
        return -1;
    }

    public void add(int value) {
        list.add(value);
        map.put(value, map.getOrDefault(value, 0) + 1);
    }*/


    // 采用小顶堆，每次将次数出现最小的放在最前面
    LinkedHashMap<Integer, Integer> ldhm;


    public lc1429_第一个唯一数字(int[] nums) {
        ldhm = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ldhm.put(nums[i], ldhm.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(ldhm);

    }

    public int showFirstUnique() {
        for (Map.Entry<Integer, Integer> entry : ldhm.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public void add(int value) {
        ldhm.put(value, ldhm.getOrDefault(value,0) + 1);
        System.out.println(ldhm);
    }


    @Test
    public void test() {
        LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        hashMap.put(2, -1);
        hashMap.put(1, -1);
        hashMap.put(4, -1);
        hashMap.put(6, -1);
        hashMap.put(7, -1);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey());

        }

    }
}

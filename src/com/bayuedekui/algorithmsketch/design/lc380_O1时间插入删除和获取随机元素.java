package com.bayuedekui.algorithmsketch.design;

import org.junit.Test;

import java.util.*;

public class lc380_O1时间插入删除和获取随机元素 {

    // 只能过17/19个用例
    /*List<Integer> list;
     *//** Initialize your data structure here. *//*
    public lc380_O1时间插入删除和获取随机元素() {
        list = new ArrayList<>();

    }

    *//** Inserts a value to the set. Returns true if the set did not already contain the specified element. *//*
    public boolean insert(int val) {
        if(list.contains(val)){
            return false;
        }else{
            return list.add(val);
        }
    }

    *//** Removes a value from the set. Returns true if the set contained the specified element. *//*
    public boolean remove(int val) {
        if(list.contains(val)){
            list.remove(new Integer(val));
            return true;
        }else{
            return false;
        }
    }

    */
    /**
     * Get a random element from the set.
     *//*
    public int getRandom() {
        int size = list.size();
        Random ran = new Random(100);
        return list.get(ran.nextInt(size));
    }*/


    // 用来存储《元素，元素在list中的位置》，一查就能查到
    Map<Integer, Integer> map;
    // 每个位置存储对应的值,map中存储对应的值的位置，list中只存值，方便get
    List<Integer> list;
    Random ran;


    /**
     * Initialize your data structure here.
     */
    public lc380_O1时间插入删除和获取随机元素() {
        map = new HashMap<>();
        list = new ArrayList<>();
        ran = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        // 采用map才能时间复杂度为O(1)
        if (map.containsKey(val)) return false;

        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        // 将map中的元素以及位置拿出来
        int last = list.get(list.size() - 1);
        int idx = map.get(val);
        list.set(idx, last);
        map.put(last, idx);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(ran.nextInt(list.size()));
    }
}

package com.bayuedekui.algorithmsketch.design;


import java.util.HashMap;
import java.util.Map;

public class lc1570_两个稀疏向量的点积 {

    Map<Integer, Integer> map;

    lc1570_两个稀疏向量的点积(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(lc1570_两个稀疏向量的点积 vec) {
        System.out.println("this.map===" + this.map);
        System.out.println("vec.map===" + vec.map);
        Map<Integer, Integer> newMap = vec.map;
        if (this.map.size() <= newMap.size()) {
            return calc(this.map, newMap);
        } else {
            return calc(newMap, this.map);
        }

    }

    public int calc(Map<Integer, Integer> small, Map<Integer, Integer> big) {

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : small.entrySet()) {
            if (big.get(entry.getKey()) != null && big.get(entry.getKey()) != 0) {
                res += entry.getValue() * big.get(entry.getKey());
            }
        }
        return res;
    }
}

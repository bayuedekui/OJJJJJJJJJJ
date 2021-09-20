package com.bayuedekui.algorithmsketch.design;

import com.sun.deploy.security.SandboxSecurity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc1146_快照数组 {
    // 超时
    /*int[] arr;
    int snapCount;
    Map<Integer, int[]> map;

    public lc1146_快照数组(int length) {
        arr = new int[length];
        snapCount = 0;
        map = new HashMap<>();
    }

    public void set(int index, int val) {
        arr[index] = val;
    }

    public int snap() {
        int res = ++snapCount;
        int[] snapArr = Arrays.copyOfRange(arr,0,arr.length);
        map.put(res - 1, snapArr);
        return res - 1;
    }

    public int get(int index, int snap_id) {
        System.out.println(map);
        return map.get(snap_id)[index];
    }*/

}

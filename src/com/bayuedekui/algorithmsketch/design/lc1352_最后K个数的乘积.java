package com.bayuedekui.algorithmsketch.design;

import java.util.*;
import java.util.LinkedList;

public class lc1352_最后K个数的乘积 {

    List<Integer> list;

    public lc1352_最后K个数的乘积() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        list.add(num);
    }

    public int getProduct(int k) {
        int res=1;
        int size = list.size();
        for (int i = size - 1; i >= size - k; i--) {
            res *= list.get(i);
        }
        return res;
    }
}

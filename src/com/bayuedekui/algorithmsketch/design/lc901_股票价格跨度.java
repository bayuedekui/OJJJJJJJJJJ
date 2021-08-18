package com.bayuedekui.algorithmsketch.design;

import java.util.ArrayList;
import java.util.List;

public class lc901_股票价格跨度 {
    List<Integer> list;

    public lc901_股票价格跨度() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);
        int res = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) <= price) {
                res++;
            }else{
                break;
            }
        }
        return res;
    }
}

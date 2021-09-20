package com.bayuedekui.algorithmsketch.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.*;

public class lc1357_每隔n个顾客打折 {
    int index = 0;
    double discount;
    Map<Integer, Integer> map = new HashMap<>();
    int[] prices;
    int n;


    public lc1357_每隔n个顾客打折(int n, int discount, int[] products, int[] prices) {
        this.discount = discount / 100d;
        System.out.println(discount);
        this.prices = Arrays.copyOfRange(prices, 0, prices.length);
        for (int i = 0; i < products.length; i++) {
            map.put(products[i], i);
        }
        this.n = n;

    }

    public double getBill(int[] product, int[] amount) {
        index++;
        double res = 0d;
        for (int i = 0; i < product.length; i++) {
            Integer index = map.get(product[i]);
            res += prices[index] * amount[i];
        }

        if (index % n == 0) {
            return res * discount;
        } else {
            return res;
        }
    }

}

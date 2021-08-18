package com.bayuedekui.algorithmsketch.design;

import javax.swing.*;
import java.util.TreeSet;

public class lc855_考场就座 {
    TreeSet<Integer> treeSet;
    int size;

    public lc855_考场就座(int n) {
        size = n;
        treeSet = new TreeSet<>();
    }

    public int seat() {
        int number = 0;
        if (treeSet.size() > 0) {
            int dist = treeSet.first();
            Integer prev = null;
            for (int stud : treeSet) {
                if (prev != null) {
                    int tmp = (stud - prev) / 2;
                    if (tmp > dist) {
                        dist = tmp;
                        number = prev + tmp;
                    }
                }
                prev = stud;
            }

            if (size - 1 - treeSet.last() > dist) {
                number = size - 1;
            }
        }
        treeSet.add(number);
        return number;


    }

    public void leave(int p) {
        treeSet.remove(p);

    }
}

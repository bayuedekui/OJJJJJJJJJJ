package com.bayuedekui.algorithmsketch.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc676_实现一个魔法字典 {
    List<String> list;

    /**
     * Initialize your data structure here.
     */
    public lc676_实现一个魔法字典() {
        list = new ArrayList<>();
    }

    public void buildDict(String[] dictionary) {
        int len = dictionary.length;
        for (int i = 0; i < len; i++) {
            list.add(dictionary[i]);
        }

    }

    public boolean search(String searchWord) {
        for (int i = 0; i < list.size(); i++) {
            if (compare(list.get(i), searchWord)) {
                return true;
            }
        }
        return false;
    }

    public boolean compare(String dic, String target) {
        int flag = 1;
        int len1 = dic.length();
        int len2 = target.length();
        if (len1 != len2) {
            return false;
        } else {
            for (int i = 0; i < len1; i++) {
                if (dic.charAt(i) != target.charAt(i)) {
                    if (flag == 1) {
                        flag--;
                    } else {
                        return false;
                    }
                }
            }
        }
        return flag == 0;
    }
}

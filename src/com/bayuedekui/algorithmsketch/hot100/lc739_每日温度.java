package com.bayuedekui.algorithmsketch.hot100;

import java.util.LinkedList;

public class lc739_每日温度 {
    // 暴力法
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = calcNext(temperatures, i);
        }
        return res;
    }

    public int calcNext(int[] temp, int index) {
        for (int i = index; i < temp.length; i++) {
            if (temp[i] > temp[index]) {
                return i - index;
            }
        }
        return 0;
    }


    // 单调栈
    public int[] dailyTemperatures2(int[] temperatures) {
        int len = temperatures.length;
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int temp = temperatures[i];
            while (!list.isEmpty() && temperatures[list.peekLast()] < temp) {
                int preIdx = list.pollLast();
                res[preIdx] = i - preIdx;
            }
            list.offerLast(i);
        }
        return res;
    }

}

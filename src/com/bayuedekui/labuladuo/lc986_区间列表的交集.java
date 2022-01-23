package com.bayuedekui.labuladuo;

import java.util.ArrayList;
import java.util.List;

public class lc986_区间列表的交集 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int len1 = firstList.length;
        int len2 = secondList.length;
        int a = 0, b = 0;
        List<int[]> list = new ArrayList<>();
        while (a < len1 && b < len2) {
            int a0 = firstList[a][0];
            int a1 = firstList[a][1];
            int b0 = secondList[b][0];
            int b1 = secondList[b][1];
            // 存在相交部分，
            if (a0 <= b1 && b0 <= a1) {
                list.add(new int[]{Math.max(a0, b0), Math.min(a1, b1)});
            }

            // a和b进行增加，谁的结尾大 谁不需要更换
            if (a1 < b1) {
                a++;
            } else {
                b++;
            }
        }
        int size = list.size();
        int[][] res = new int[size][2];
        for (int i = 0; i < size; i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }
}

package com.bayuedekui.labuladuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc56_合并区间 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        // 按照二维数组第一个升序排列
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> list = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i <= len; i++) {
            int[] tmp = intervals[i];
            if (end >= tmp[0]) {
                end = Math.max(end, tmp[1]);
            } else {
                list.add(new int[]{start, end});
                start = tmp[0];
                end = tmp[1];
            }
        }
        list.add(new int[]{start, end});


        int size = list.size();
        int[][] res = new int[size][2];
        for (int i = 0; i < size; i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }

        return res;
    }

    // 不用start,end进行精简下
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int len = intervals.length;
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < len; i++) {
            int[] tmp = intervals[i];
            if (list.get(list.size() - 1)[1] >= tmp[0]) {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], tmp[1]);
            }else{
                list.add(tmp);
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

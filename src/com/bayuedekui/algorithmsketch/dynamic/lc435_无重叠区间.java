package com.bayuedekui.algorithmsketch.dynamic;

import java.util.Arrays;

public class lc435_无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
       //用每个子int[]中的end,进行排序
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);

        int end = intervals[0][1];

        int count = 1;//最少有1个无重叠子区间

        for(int[] i:intervals){
            int start = i[0];
            if(start>=end){
                count++;
                end = i[1];
            }
        }

        return intervals.length - count;


    }
}

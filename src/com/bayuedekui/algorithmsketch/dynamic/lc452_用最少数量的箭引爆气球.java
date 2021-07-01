package com.bayuedekui.algorithmsketch.dynamic;

import java.util.Arrays;

public class lc452_用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        //转化成求无重叠区间的个数，有多少个就需要射出多少箭
        Arrays.sort(points, (o1, o2) -> o1[1] - o2[1]);

        int res = 1;//最少需要射出一只箭

        int end = points[0][1];

        //采用贪心的思想：如果按照最后一个升序排序的时候，只要下一个start<=上一个end,则不用多增加箭
        for (int[] point : points) {
            int start = point[0];
            if (start > end) {
                res++;
                end = point[1];
            }
        }
        return res;
    }
}

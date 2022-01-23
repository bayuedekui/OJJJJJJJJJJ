package com.bayuedekui.labuladuo;

import java.util.Arrays;

public class lc1288_删除被覆盖区间 {
    public int removeCoveredIntervals(int[][] intervals) {
        // 先进行排序，先按照第一个升序，如果相同，按照第二个降序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            // 如果覆盖
            if (left <= intervals[i][0] && right >= intervals[i][1]) {
                res++;
            }
            // 如果相交,则合并分区,因为left是升序，所有right取最大值
            if (right >= intervals[i][0] && right <= intervals[i][1]) {
                right = Math.max(right, intervals[i][1]);
            }
            // 没有交集，则同时更新left和right
            if (right <= intervals[i][0]) {
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        return intervals.length - res;

    }
}

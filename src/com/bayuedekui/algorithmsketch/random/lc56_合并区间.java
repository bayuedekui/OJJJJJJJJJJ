package com.bayuedekui.algorithmsketch.random;

import java.util.ArrayList;
import java.util.*;

public class lc56_合并区间 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return new int[0][0];
        }
        // 先将intervals按照第一个数进行排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < len; i++) {
            System.out.println(intervals[i][0] + " " + intervals[i][1]);
        }

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

         /*
         遍历排序后的，用当前左边数与结果列表中的最后一个数的右边数进行相比较，
         如果当前大于右边，则将当前插入结果列表
         如果当前小于右边，则更新为结果列表中最后一个与当前右边数中最大的一个
         */
        for (int i = 1; i < len; i++) {
            int nl = intervals[i][0];
            int nr = intervals[i][1];
            int[] pre = res.get(res.size() - 1);
            if (nl > pre[1]) {
                res.add(intervals[i]);
            }else{
                pre[1] = Math.max(pre[1], nr);
            }
        }
        return res.toArray(new int[res.size()][]);

    }
}

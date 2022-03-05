package com.bayuedekui.labuladuo.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc986_区间列表的交集 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // 区间交集问题
        // 用索引指针分别指向两个数组，（a1,b1）,(a2,b2),
        // b1<a2,first指针++
        // b2<a1,second指针++
        // 交集条件：a1<=b2&&b1>=a2
        // 交集内容：max(a1,a2),min(b1,b2)
        List<int[]> res = new ArrayList<>();

        int i = 0;
        int j = 0;
        int fLen = firstList.length;
        int sLen = secondList.length;
        while (i < fLen && j < sLen) {
            int a1 = firstList[i][0];
            int b1 = firstList[i][1];
            int a2 = secondList[j][0];
            int b2 = secondList[j][1];

            if (b2 >= a1 && a2 <= b1) {
                res.add(new int[]{Math.max(a1, a2), Math.min(b1, b2)});
            }

            if (b1 < b2) {
                i++;
            } else {
                j++;
            }
        }

        return res.toArray(new int[0][0]);

    }

    // 区间删除问题
    class lc1288_删除被覆盖区间 {
        public int removeCoveredIntervals(int[][] intervals) {
            // 区间删除问题与区间合并问题都需要先排序(数组第一个数升序，第二个数降序)
            // 当第二个区间（a2,b2）与第一个区间(a1,b1):b1>=b2,则第二个区间被覆盖
            // 当第二个区间（a2,b2）与第一个区间(a1,b1):b1<b2,则延长b1与b2相等，又叫区间合并
            Arrays.sort(intervals, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            });

            int a1 = intervals[0][0];
            int b1 = intervals[0][1];

            int mergeCnt = 0;

            for (int i = 1; i < intervals.length; i++) {
                int a2 = intervals[i][0];
                int b2 = intervals[i][1];

                if (a1 <= a2 && b1 >= b2) {
                    // (a2,b2)被合并
                    mergeCnt++;
                }

                // 区间被合并
                if (b1 >= a2 && b1 <= b2) {
                    b1 = b2;
                }

                // 区间不相交，更新a1,b1
                if (b1 < a2) {
                    a1 = a2;
                    b1 = b2;
                }

            }
            return intervals.length - mergeCnt;

        }
    }


    class lc56_合并区间 {
        public int[][] merge(int[][] intervals) {
            // 先按照第一个升序，第二个降序排列
            // （a1,b1） (a2,b2),默认a1<=a2
            // 相交情况：b1>=a2时，左边取a1,右边取max(b1,b2)
            // 不相交情况：b1<a2
            Arrays.sort(intervals, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            });

            List<int[]> res = new ArrayList<>();
            int len = intervals.length;
            int a1 = intervals[0][0];
            int b1 = intervals[0][1];

            for (int i = 1; i < len; i++) {
                int a2 = intervals[i][0];
                int b2 = intervals[i][1];

                if (b1 >= a2) {
                    b1 = Math.max(b1, b2);
                } else {
                    res.add(new int[]{a1, b1});
                    a1 = a2;
                    b1 = b2;
                }
            }
            res.add(new int[]{a1, b1});

            return res.toArray(new int[0][0]);
        }
    }
}

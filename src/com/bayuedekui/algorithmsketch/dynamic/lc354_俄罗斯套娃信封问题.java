package com.bayuedekui.algorithmsketch.dynamic;

import java.util.Arrays;
import java.util.Comparator;

public class lc354_俄罗斯套娃信封问题 {
    //先将二维数组进行排序，按照宽度升序排列，然后宽度相同的，将高度进行降序排序，保证宽度相同的，取高度大的
    //转化成lis(最长子序列问题)
    public int maxEnvelopes(int[][] envelopes) {
        /*Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[1] - o2[1];
            }
        });*/
        Arrays.sort(envelopes, ((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]));

        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(envelopes[i][j]+",");
            }
            System.out.println();
        }

        //进行LIS计算
        int[] dp = new int[envelopes.length];
        //base case
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i] + "-");
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}

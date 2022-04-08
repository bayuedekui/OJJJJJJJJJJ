package com.bayuedekui.presum;

import java.util.Arrays;

public class lc1109_航班预订统计 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 一个范围内增减，典型的差分数组
        int[] diff = new int[n + 2];

        for (int i = 0; i < bookings.length; i++) {
            int start = bookings[i][0];
            int end = bookings[i][1];
            int val = bookings[i][2];
            diff[start] += val;
            diff[end + 1] -= val;
        }

        System.out.println(Arrays.toString(diff));

        int[] ori = new int[n + 2];
        int[] res = new int[n];
        ori[0] = diff[0];
        ori[1] = diff[1];
        for (int i = 2; i <= n + 1; i++) {
            ori[i] = ori[i - 1] + diff[i];
            res[i - 2] = ori[i - 1];
        }
        return res;


    }
}

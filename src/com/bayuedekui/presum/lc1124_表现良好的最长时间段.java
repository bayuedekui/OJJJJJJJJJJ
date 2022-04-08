package com.bayuedekui.presum;

public class lc1124_表现良好的最长时间段 {
    public int longestWPI(int[] hours) {
        // 采用转化法，将工作时间转化为1/0,1表示超过8小时。0表示未超过
        // 然后采用前缀和，取区间范围的求和，求和结果与（j-i+1）/2+1比较，需要大于等于才可以
        int len = hours.length;
        int[] preSum = new int[len + 1];

        for (int i = 0; i < len; i++) {
            hours[i] = hours[i] > 8 ? 1 : 0;
        }

        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + hours[i-1];
        }

        int max = 0;

        for (int i = 0; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if ((preSum[j] - preSum[i]) >= ((j - i) / 2 + 1)) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }
}

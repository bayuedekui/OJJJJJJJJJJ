package com.bayuedekui.algorithmsketch.dynamic;

public class lc583_两个字符串的删除操作 {
    public int minDistance(String word1, String word2) {
        //求两个子串的最长公共子序列长度，然后用word1长度-最长子序列长度+word2长度-最长子序列长度
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }

        int[][] dp = new int[len1+1][len2+1];
        //base case
        for (int i = 0; i < len1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < len2; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return len1 - dp[len1][len2] + len2 - dp[len1][len2];

    }
}

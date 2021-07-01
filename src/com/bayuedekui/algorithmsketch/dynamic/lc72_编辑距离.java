package com.bayuedekui.algorithmsketch.dynamic;

import java.util.HashMap;
import java.util.Map;

public class lc72_编辑距离 {
    //超时
    /*String w1;
    String w2;

    public int minDistance(String word1, String word2) {
        w1 = word1;
        w2 = word2;
        return dp(word1.length() - 1, word2.length() - 1);

    }

    //非缓存dp
    public int dp(int fir, int sec) {
        if (fir == -1) {
            return sec + 1;
        }
        if (sec == -1) {
            return fir + 1;
        }

        if (w1.charAt(fir) == w2.charAt(sec)) {
            return dp(fir - 1, sec - 1);
        } else {
            int del = dp(fir - 1, sec) + 1;
            int add = dp(fir, sec - 1) + 1;
            int modi = dp(fir - 1, sec - 1) + 1;
            return min(del, add, modi);
        }
    }w

    public int min(int fir, int sec, int thir) {
        return Math.min(Math.min(fir, sec), thir);
    }*/


    String w1;
    String w2;

    //有缓存的递归(属于自顶向下的动态规划)，可以过
    /*public int minDistince(String word1, String word2) {
        w1 = word1;
        w2 = word2;
        return dp(word1.length() - 1, word2.length() - 1);

    }

    Map<String, Integer> map = new HashMap<>();

    public int dp(int fir, int sec) {
        if (map.get(fir + "" + sec) != null) {
            return map.get(fir + "" + sec);
        }

        if (fir == -1) {
            return sec + 1;
        }
        if (sec == -1) {
            return fir + 1;
        }

        if (w1.charAt(fir) == w2.charAt(sec)) {
            map.put(fir + "" + sec, dp(fir - 1, sec - 1));
        } else {
            int del = dp(fir, sec - 1)+1;
            int add = dp(fir - 1, sec)+1;
            int modi = dp(fir - 1, sec - 1)+1;
            map.put(fir + "" + sec, min(del, add, modi));
        }
        return map.get(fir + "" + sec);
    }

    public int min(int fir, int sec, int thir) {
        return Math.min(Math.min(fir, sec), thir);
    }*/


    //自底向上的DP,dp[i][j]:i代表第一排字母，j代表第二排字母
    public int minDistince(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        //[0][...]或者[...][0]均是递增的
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        //二维数组行列计算值
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int del=dp[i][j-1]+1;
                    int add=dp[i-1][j]+1;
                    int modi=dp[i-1][j-1]+1;
                    dp[i][j] = min(del, add, modi);
                }
            }
        }


        return dp[m][n];
    }

    public int min(int fir, int sec, int thir) {
        return Math.min(Math.min(fir, sec), thir);
    }

}

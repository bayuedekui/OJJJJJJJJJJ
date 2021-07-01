package com.bayuedekui.algorithmsketch.dynamic;

import org.junit.Test;

import java.util.List;

public class lc712_两个字符串的最小ASCII删除和 {

    //和两个字符删除操作题类似，不过要记录删除的是哪个
    public int minimumDeleteSum(String s1, String s2) {
        //将不等于的找来放入list中
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 == 0) {
            return calcASCII(s2);
        }
        if (len2 == 0) {
            return calcASCII(s1);
        }


        //用dp[i][j]表示s1的i位置到s2的j位置的ascii码和
        int[][] dp = new int[len1 + 1][len2 + 1];
        // base case
        dp[0][0] = 0;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = calcASCII(s1.substring(0, i));
        }

        for (int j = 1; j <= len2; j++) {
            dp[0][j] = calcASCII(s2.substring(0, j));
        }


        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.codePointAt(i - 1), dp[i][j - 1] + s2.codePointAt(j - 1));
                }
            }
        }
        return dp[len1][len2];

    }


    public int calcASCII(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res += str.codePointAt(i);

        }
        return res;
    }

    @Test
    public void test() {
        String s1 = "sea";
        String s2 = "eat";
        System.out.println(minimumDeleteSum(s1, s2));
    }
}

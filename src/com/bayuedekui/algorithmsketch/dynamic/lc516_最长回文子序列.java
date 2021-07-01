package com.bayuedekui.algorithmsketch.dynamic;

public class lc516_最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        //dp[i][j]表示从i-->j的字符串回文最大长度
        //dp[i][j]=dp[i+1][j-1]+2,如果s.charAt(i+1)==s.charAt(j-1)
        //dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]),如果s.charAt(i+1)!=s.charAt(j-1)

        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int[][] dp = new int[len][len];
        for (int i = len-1; i >=0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];

    }
}

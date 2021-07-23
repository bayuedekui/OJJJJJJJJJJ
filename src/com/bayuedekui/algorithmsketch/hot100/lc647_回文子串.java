package com.bayuedekui.algorithmsketch.hot100;

public class lc647_回文子串 {
    public int countSubstrings(String s) {
        int len = s.length();
        // 选取回文中心，分为奇数回文串和偶数回文串两种情况进行遍历
        int res = 0;
        // 奇数回文串
        for (int i = 0; i < len; i++) {
            int left = i - 1;
            int right = i + 1;
            // 奇数个的时候中心肯定是回文的
            res++;
            while (left >= 0 && right <= len - 1 && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                res++;
            }
        }
        //偶数个回文串
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                res++;
                int left = i - 1;
                int right = i + 2;
                while (left >= 0 && right <= len - 1 && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    res++;
                }
            }
        }
        return res;

    }
}

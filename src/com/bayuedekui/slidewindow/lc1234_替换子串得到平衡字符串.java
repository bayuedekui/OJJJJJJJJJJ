package com.bayuedekui.slidewindow;

import org.junit.Test;

import java.util.*;

public class lc1234_替换子串得到平衡字符串 {
    // 这个时只能替换一个字串的写法
    public int balancedString(String s) {
        int len = s.length();
        int left = 0;
        int right = 0;
        int n = len / 4;
        int maxSub = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < len) {
            char c = s.charAt(right);
            right++;
            map.put(c, map.getOrDefault(c, 0) + 1);

            // 判断是否需要排出
            while (map.get(c) > n) {
                char d = s.charAt(left);
                left++;
                map.put(d, map.get(d) - 1);
            }
            maxSub = Math.max(maxSub, right - left);
        }
        return len - maxSub;

    }


    public int balancedString1(String s) {
        int len = s.length();
        int[] arr = new int[128];
        int n = len / 4;
        int right = 0;
        int res = 0;
        while (right < len) {
            arr[s.charAt(right)]++;
            if (arr[s.charAt(right)] > n) {
                res++;
            }
            right++;
        }
        return res;

    }


    @Test
    public void test() {
        System.out.println(balancedString1("QWER"));
    }
}

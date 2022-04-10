package com.bayuedekui.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class lc3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        // 采用滑动窗口
        int len = s.length();
        int left = 0;
        int right = 0;
        boolean valid = true;
        Map<Character, Integer> win = new HashMap<>();

        int res = 0;
        while (right < len) {
            char c = s.charAt(right);
            right++;

            win.put(c, win.getOrDefault(c, 0) + 1);
            // 有重复字符，需要缩小窗口
            while (win.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                win.put(d, win.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;

    }
}

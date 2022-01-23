package com.bayuedekui.labuladuo;

import java.util.HashMap;

public class lc76_最小覆盖子串 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        char[] ss = s.toCharArray();
        for (char c : ss) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < t.length()) {
            char c = t.charAt(right);
            right++;
            // 只有涉及到need中字串，才需要window记录
            if (need.get(c) != null) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c) == window.get(c)) {
                    valid++;
                }
            }

            // 因为要求最小字串，所有首先需要满足包含s,包含后才开始做小窗口
            while (valid == s.length()) {
                // 记录开始与结束位置
                if (right - left < len) {
                    start = left;
                    len = right - left;// 这边减完多了一个，后面用substring正好
                }
                char d = t.charAt(left);
                left++;

                if (need.get(d) != null) {
                    if (need.get(d) == window.get(d)) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }

        }
        return len == Integer.MAX_VALUE ? "" : t.substring(start, len);


    }
}

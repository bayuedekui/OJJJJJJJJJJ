package com.bayuedekui.labuladuo.again;

import org.junit.Test;

import java.util.HashMap;

public class lc567_字符串的排列 {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> win = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.get(c) != null) {
                win.put(c, win.getOrDefault(c, 0) + 1);
                if (win.get(c) == need.get(c)) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;

                if (need.get(d) != null) {
                    if (need.get(d) == win.get(d)) {
                        valid--;
                    }
                    win.put(d, win.get(d) - 1);
                }

            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(checkInclusion("eidbaooo", "ab"));
    }
}

package com.bayuedekui.labuladuo.again;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc438_找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> win = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need.get(c) != null) {
                win.put(c, win.getOrDefault(c, 0) + 1);
                if (win.get(c) == need.get(c)) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                // valid不是和p的长度相等的，而是和字母以及多应的次数都相等以及字母个数
                // 本题应该是need中不为0的数
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.get(d) != null) {
                    if (win.get(d) == need.get(d)) {
                        valid--;
                    }
                    win.put(d, win.get(d) - 1);
                }
            }
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(findAnagrams("baa", "aa"));
    }
}

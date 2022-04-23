package com.bayuedekui.slidewindow;

import org.junit.Test;

public class lc76_最小覆盖子串 {
    public String minWindow(String s, String t) {
        // 采用滑动窗口，统计t中各个字母出现的次数，然后窗口滑动过程中记录窗口
        // 中的在t中字母的出现次数，每当cur[x]=need[x]时valid++,valid初始为零
        // 然后保证字母都存在的时候缩小窗口，用新的l与r来记录之前的范围
        int[] need = new int[128];
        int[] cur = new int[128];
        int left = 0, right = 0;
        int slen = s.length();
        int tlen = t.length();
        for (int i = 0; i < tlen; i++) {
            need[t.charAt(i)]++;
        }
        // 统计t字符串中出现的字母个数
        int needCnt = 0;
        for (int i = 0; i < 128; i++) {
            if (need[i] > 0) {
                needCnt++;
            }
        }

        int valid = 0;
        int newl = -1;
        int newr = slen - 1;
        while (right < slen) {
            char c = s.charAt(right);
            right++;
            // 当字母是t中的时候
            if (need[c] != 0) {
                cur[c]++;
                // 当一个字符满足后valid++,目标是达到valid==needCnt
                if (cur[c] == need[c]) {
                    valid++;
                }
            }

            // 尝试进行缩小窗口
            while (left < right && valid == needCnt) {

                // 不能直接先left++,否则初始的left==0情况遗漏
                if ((newr - newl) >= (right - left)) {
                    newr = right;
                    newl = left;
                }
                char d = s.charAt(left);
                left++;

                if (need[d] != 0) {
                    cur[d]--;
                    if (cur[d] < need[d]) {
                        valid--;
                    }
                }
            }
        }

        return newl == -1 ? "" : s.substring(newl, newr);

    }

    @Test
    public void test() {
        System.out.println(minWindow("aaaabcdd", "abcdd"));
    }
}

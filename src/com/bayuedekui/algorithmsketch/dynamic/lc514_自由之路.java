package com.bayuedekui.algorithmsketch.dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class lc514_自由之路 {
    public int findRotateSteps(String ring, String key) {
        int rLen = ring.length();
        int kLen = key.length();
        for (int i = 0; i < rLen; i++) {
            map.put(i, ring.charAt(i));
        }

        mem = new int[rLen][kLen];
        return dp(ring, 0, key, 0);


    }

    Map<Integer, Character> map = new HashMap<>();
    int[][] mem;


    //采用自顶向下的dp
    public int dp(String ring, int rStart, String key, int kStart) {
        //当kStart=key.length()-1时，ring还要摇最后一个字符，所以只有kStart==key.length()时才算摇完
        if (kStart == key.length()) {
            return 0;
        }

        //备忘录
        if (mem[rStart][kStart] != 0) {
            return mem[rStart][kStart];
        }

        int rLen = ring.length();
        int res = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Character> s : map.entrySet()) {
            if (s.getValue() == key.charAt(kStart)) {
                int moveCnt = Math.abs(s.getKey() - rStart);
                //选择时顺时针还是逆时针
                moveCnt = Math.min(moveCnt, rLen - moveCnt);
                //将指针拨到s.getKey位置
                int subProblem = dp(ring, s.getKey(), key, kStart + 1);

                res = Math.min(res, 1 + moveCnt + subProblem);
            }

        }
        mem[rStart][kStart] = res;

        return res;
    }
}

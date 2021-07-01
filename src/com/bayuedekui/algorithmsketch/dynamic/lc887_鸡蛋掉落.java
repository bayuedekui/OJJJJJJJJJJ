package com.bayuedekui.algorithmsketch.dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class lc887_鸡蛋掉落 {
    public int superEggDrop(int k, int n) {
        return dp(k, n);

    }

    //采用自顶向下的dp
    Map<String, Integer> map = new HashMap<>();

    public int dp(int k, int n) {
        String key = k + "" + n;
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }

        if (map.get(key) != null) {
            return map.get(key);
        }

        int res = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            //考虑的是总共有多少层楼，所以一个是n-i,一个是i-1
            res = Math.min(res, Math.max(dp(k, n - i), dp(k - 1, i - 1)) + 1);
        }

        map.put(k + "" + n, res);

        return res;
    }
}

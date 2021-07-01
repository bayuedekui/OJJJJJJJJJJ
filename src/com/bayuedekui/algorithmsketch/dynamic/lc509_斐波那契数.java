package com.bayuedekui.algorithmsketch.dynamic;

import java.util.HashMap;
import java.util.Map;

public class lc509_斐波那契数 {

    //采用递归关系式+备忘录法---（也叫自顶向下法）
    Map<Integer, Integer> map = new HashMap<>();

    public int fib0(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (map.get(n) != null) {
            return map.get(n);
        }
        map.put(n, fib0(n - 2) + fib0(n - 1));
        return fib0(n - 2) + fib0(n - 1);
    }

    //自底向上的动态规划法
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }


}

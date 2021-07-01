package com.bayuedekui.algorithmsketch.dynamic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class lc322_零钱兑换 {
    //带备忘录的递归


    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (map.get(amount) != null) {
            return map.get(amount);
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int subSum = coinChange(coins, amount - coins[i]);
            if (subSum == -1) {
                continue;
            }
            res = Math.min(res, subSum + 1);
        }
        if (res != Integer.MAX_VALUE) {
            map.put(amount, res);
        } else {
            map.put(amount, -1);
        }
        return map.get(amount);

    }

    Map<Integer, Integer> map = new HashMap<>();

    public int dp(int[] coins, int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        if (map.get(n) != null) {
            return map.get(n);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subMoney = dp(coins, n - coins[i]);
            if (subMoney == -1) {
                continue;
            }
            res = Math.min(res, 1 + subMoney);
        }
        if (res == Integer.MAX_VALUE) {
            map.put(n, -1);
        } else {
            map.put(n, res);
        }
        return map.get(n);

    }


    @Test
    public void test() {
        int[] coins = new int[]{1, 2, 5};
        int amount = 12;
        System.out.println(coinChange(coins, amount));
    }
}

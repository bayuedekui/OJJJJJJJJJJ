package com.bayuedekui.algorithmsketch.dynamic;

import java.util.Arrays;

public class lc174_地下城游戏 {
    public int calculateMinimumHP_old(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        mem = new int[m][n];
        for (int[] r : mem) {
            Arrays.fill(r, -1);
        }
        return dp(dungeon, 0, 0);

    }

    int[][] mem;

    //采用自顶向下的dp,最终结果不依赖向上/向左的结果值，而是骑士在每一步要以最小的血量活着
    public int dp(int[][] dungeon, int m, int n) {
        //base case
        if (m == dungeon.length - 1 && n == dungeon[0].length - 1) {
            return dungeon[m][n] >= 0 ? 1 : -dungeon[m][n] + 1;
        }


        //例外特殊情况，当作异常处理
        if (m == dungeon.length || n == dungeon[0].length) {
            return Integer.MAX_VALUE;
        }

        //备忘录
        if (mem[m][n] != -1) {
            return mem[m][n];
        }

        int nxt = Math.min(dp(dungeon, m + 1, n), dp(dungeon, m, n + 1)) - dungeon[m][n];

        //如果剩下的血小于等于0，说明当前位置有血包/啥东西没有，所以结果只要骑士血量等于一就好了，
        //如果nxt大于零,说明当前有恶魔/为空，只要取nxt结果就行（既能满足之前的血量要求，又能满足下一个血量要求）
        mem[m][n] = nxt <= 0 ? 1 : nxt;

        return mem[m][n];
    }


    //采用自底向上的DP
    public int calculateMinimumHP(int[][] dungeon) {
        //dp[i][j]表示当前位置骑士所需的最小血量
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m + 1][n + 1];

        //base case
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        //base case,dp[m-1][n-1]值取决于dp[m][n-1],dp[m-1][n]相当于已经到最后了，最后的下边值和右边值为1就可以了
        dp[m][n - 1] = dp[m - 1][n] = 1;


        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int nxt = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(nxt - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

}

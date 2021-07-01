package com.bayuedekui.pointoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 剑指Offer13_机器人的运动范围 {

    public int movingCount(int m, int n, int k) {
        boolean[][] board = new boolean[m][n];
        return dfs(board, 0, 0, k);

    }

    //采用dfs的方法
    public int dfs(boolean[][] board, int i, int j, int k) {
        //如果出了边界+不符合条件则返回零
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || sum(i) + sum(j) > k || board[i][j] == true) {
            return 0;
        }
        board[i][j] = true;
        //这边可以进行改进，因为从顶点出发，所以只能是向右或者向下出发
//        return 1 + dfs(board, i + 1, j, k) + dfs(board, i - 1, j, k) + dfs(board, i, j + 1, k) + dfs(board, i, j - 1, k);
        return 1 + dfs(board, i + 1, j, k) + dfs(board, i, j + 1, k);

    }


    //采用bfs方法
    public int movingCount_bfs(int m, int n, int k) {
        //记录是否访问
        boolean[][] vis = new boolean[m][n];
        //初始化队列，用来装广度遍历的内容
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0, 0});
        //将符合条件的左边放入结果中，然后通过List.length得到结果
        ArrayList<int[]> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int sum = sum(tmp[0]) + sum(tmp[1]);
            if (tmp[0] >= vis.length || tmp[1] >= vis[0].length || sum > k || vis[tmp[0]][tmp[1]] == true) {
                continue;
            }
            res.add(tmp);
            vis[tmp[0]][tmp[1]] = true;
            //下面和右边的进入队列，达到广度思想的含义
            queue.add(new int[]{tmp[0]+1,tmp[1]});
            queue.add(new int[]{tmp[0],tmp[1]+1});

        }
        return res.size();

    }


    //实现按照每一位求和
    public int sum(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x = x / 10;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(movingCount_bfs(2, 3, 1));
    }
}

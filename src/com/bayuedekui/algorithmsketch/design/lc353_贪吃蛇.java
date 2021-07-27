package com.bayuedekui.algorithmsketch.design;

import java.util.LinkedList;

public class lc353_贪吃蛇 {
    // 盘
    int[][] arr;
    // 使用linkedlist表示蛇的身体，每次采用offerFrist与pollLast
    LinkedList<String> list = new LinkedList();


    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public lc353_贪吃蛇(int width, int height, int[][] food) {
        arr = new int[height][width];
        for (int i = 0; i < food.length; i++) {
            arr[food[i][0]][food[i][1]] = 1;
        }
        list.add(0 + "" + 0);

    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        int[] dir = new int[2];
        switch (direction) {
            case "R":
                dir[0] = 0;
                dir[1] = 1;
                break;
            case "L":
                dir[0] = 0;
                dir[1] = -1;
                break;
            case "U":
                dir[0] = -1;
                dir[1] = 0;
                break;
            case "D":
                dir[0] = 1;
                dir[1] = 0;
                break;
        }
        String head = list.peekFirst();
        int nxtRow = Integer.parseInt(head.charAt(0) + "") + dir[0];
        int nxtCol = Integer.parseInt(head.charAt(1) + "") + dir[1];
        String next = nxtRow + "" + nxtCol;

        // 游戏结束
        if (list.contains(next) || (nxtRow < 0 || nxtRow >= arr.length) || (nxtCol < 0 | nxtCol >= arr[0].length)) {
            return -1;
        }

        // 没有吃到，返回0，同时头增加一个，尾去除
        if (arr[nxtRow][nxtCol] != 1) {
            list.offerFirst(next);
            list.pollLast();
            return 0;
        }

        // 吃到，返回1，同时头变成最新
        if (arr[nxtRow][nxtCol] == 1) {
            list.offerFirst(next);
            return 1;
        }

        return -1;
    }
}

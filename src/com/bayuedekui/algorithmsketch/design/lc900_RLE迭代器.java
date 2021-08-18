package com.bayuedekui.algorithmsketch.design;

import javax.xml.stream.events.EndDocument;
import java.util.*;

public class lc900_RLE迭代器 {
    // 超时
    /*Deque<Integer> deque;

    public lc900_RLE迭代器(int[] encoding) {
        deque = new LinkedList<>();
        for (int i = 0; i < encoding.length - 1; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < encoding[i]; j++) {
                    deque.offerLast(encoding[i + 1]);
                }
            }
        }
        System.out.println(deque);
    }

    public int next(int n) {
        int size = deque.size();
        if (size < n) {
            return -1;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                res = deque.pollFirst();
            } else {
                deque.pollFirst();
            }
        }
        return res;
    }*/
    Deque<Integer> value;
    Deque<Integer> times;

    public lc900_RLE迭代器(int[] encoding) {
        value = new LinkedList<>();
        times = new LinkedList<>();
        for (int i = 0; i < encoding.length - 1; i++) {
            if (i % 2 == 0 && encoding[i] != 0) {
                value.offerLast(encoding[i + 1]);
                times.offerLast(encoding[i]);
            }
        }
    }


    /**
     * // 这边搞错了，导致到了第五个用例的时候就过不了，返回-1的情况是先挨着删除，删除到最后没得删除了才返回-1
     * while (values.hasNext()) {
     * sum += values.next();
     * }
     * if (sum < n) {
     * System.out.println(deque);
     * System.out.println(map);
     * return -1;
     * <p>
     * } else {
     *
     * @param n
     * @return
     */
    public int next(int n) {
        int res = 0;
        // 进行map和deque的操作
        while (n != 0) {
            Integer tmp = value.peekFirst();
            if (tmp == null) {
                return -1;
            }
            int time = times.peekFirst();
            if (time > n) {
                times.pollFirst();
                times.offerFirst(time - n);
                n = 0;
                res = tmp;
            } else if (time == n) {
                times.pollFirst();
                value.pollFirst();
                n = 0;
                res = tmp;
            } else {
                times.pollFirst();
                value.pollFirst();
                n -= time;
            }
        }
        return res;
    }
}

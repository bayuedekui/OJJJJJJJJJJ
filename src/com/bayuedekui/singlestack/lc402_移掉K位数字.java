package com.bayuedekui.singlestack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Stack;

public class lc402_移掉K位数字 {
    public String removeKdigits(String num, int k) {
        // 采用栈存储要进来的数字，如果栈顶比要进来的大，则退出栈顶，k--,直至k==0
        int len = num.length();
        if (len == k) {
            return "0";
        }
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char ch = num.charAt(i);
            while (!deque.isEmpty() && deque.peekLast() > ch && k != 0) {
                k--;
                deque.pollLast();
            }
            // 这样操作会导致112被处理成12，其实应该处理成11
            /*if (!deque.isEmpty() && ch >= deque.peekLast() && k != 0) {
                // 可以删除，同时没有栈顶元素小，直接去除
                k--;
                continue;
            }*/
            deque.offerLast(ch);
        }

        // 如果k!=0,将栈顶的元素退出即可
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        return removeHead(deque);
    }

    public String removeHead(Deque<Character> deque) {
        StringBuffer sb = new StringBuffer();
        while (!deque.isEmpty()) {
            if (deque.peekFirst() == '0') {
                deque.pollFirst();
            } else {
                break;
            }
        }
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        return sb.toString().length() == 0 ? "0" : sb.toString();
    }
}

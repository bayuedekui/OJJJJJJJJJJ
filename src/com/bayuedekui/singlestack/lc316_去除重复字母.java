package com.bayuedekui.singlestack;

import java.util.Stack;

public class lc316_去除重复字母 {
    public String removeDuplicateLetters(String s) {
        // 采用单调栈，stackArr记录栈中已经有的数，numsArr记录每个字符的出现个数
        // 当栈顶元素小于即将入栈的元素，并且栈中没有，且栈顶元素后续还存在，则可以替换栈顶，将原色放入进来
        int[] numsArr = new int[26];
        int[] stackArr = new int[26];
        for (int i=0; i < s.length(); i++) {
            numsArr[s.charAt(i) - 'a']++;
        }
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 栈顶大于即将进来c,栈顶元素后续还有（如果没有就不能弹出），同时栈内没有即将进来c
            while (!stack.isEmpty() && stack.peek() > c && numsArr[stack.peek() - 'a'] > 1 && stackArr[c - 'a'] == 0) {
                numsArr[stack.peek() - 'a']--;
                stackArr[stack.peek() - 'a']--;
                stack.pop();
            }
            // 即将进来c
            if (stackArr[c - 'a'] == 0) {
                stack.push(c);
                stackArr[c - 'a'] = 1;
            } else {
                // 栈中已经有了和c相等的，所以直接丢弃
                numsArr[c - 'a']--;
            }
        }
        // 将栈转化为字符串
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();

    }
}

package com.bayuedekui.algorithmsketch.design;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc1286_字母组合迭代器 {
    Deque<String> deque = new LinkedList<>();


    public lc1286_字母组合迭代器(String characters, int combinationLength) {
        dfs(0, combinationLength, new StringBuilder(), characters);
        System.out.println(deque);

    }

    public String next() {
        return deque.pollFirst();
    }

    public boolean hasNext() {
        return deque.isEmpty();
    }

    //采用dfs回溯法进行，字符串的回溯
    public void dfs(int start, int len, StringBuilder sb, String chara) {
        if (sb.length() == len) {
            deque.offerLast(sb.toString());
            return;
        }
        for (int i = start; i < chara.length(); i++) {
            dfs(i + 1, len, sb.append(chara.charAt(i)), chara);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

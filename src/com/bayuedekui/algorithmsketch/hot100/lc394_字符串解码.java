package com.bayuedekui.algorithmsketch.hot100;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc394_字符串解码 {
    int cur;

    public String decodeString(String s) {
        // 采用Linklist代替栈
        // 遇到数字和【和字母都入队列
        // 遇到】，进行出队列操作，直到【，
        // 然后将数字也出栈，然后构造好解析完毕的字符串入栈
        LinkedList<String> list = new LinkedList<>();
        cur = 0;
        while (cur < s.length()) {
            char ch = s.charAt(cur);
            if (Character.isDigit(ch)) {
                // 获取字串S中的数字
                String digit = getDigit(s);
                list.offerLast(digit);
            } else if (ch == '[' || Character.isLetter(ch)) {
                list.offerLast(String.valueOf(s.charAt(cur++)));
            } else {
                // 当遇到】，进行弹出处理
                cur++;
                // 用新的Linkedlist进行存放---子【】串
                LinkedList<String> tmpList = new LinkedList<>();
                while (!"[".equals(list.peekLast())) {
                    tmpList.offerLast(list.pollLast());
                }
                // revers相应list
                Collections.reverse(tmpList);
                // 左括号出栈
                list.pollLast();
                // 再poll出来的是相应的数字
                int k = Integer.parseInt(list.pollLast());
                //将tmplist转化为string
                String tmpRes = parseString(tmpList);

                StringBuffer sbRes = new StringBuffer();
                while (k-- > 0) {
                    sbRes.append(tmpRes);
                }
                list.add(sbRes.toString());
            }
        }
        return parseString(list);
    }

    // 将linkedlist中字串转化为字符串
    public String parseString(List<String> list){
        StringBuffer res = new StringBuffer();
        for(String str:list){
            res.append(str);
        }
        return res.toString();
    }

    // 获取list中数字开头的所有数字，如23abc返回23
    public String getDigit(String s) {
        StringBuffer sb = new StringBuffer();
        // 将连续的数字全部返回
        while (Character.isDigit(s.charAt(cur))) {
            sb.append(s.charAt(cur++));
        }
        return sb.toString();
    }
}

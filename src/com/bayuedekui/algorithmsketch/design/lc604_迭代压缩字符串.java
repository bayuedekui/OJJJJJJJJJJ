package com.bayuedekui.algorithmsketch.design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class lc604_迭代压缩字符串 {

    /*604. 迭代压缩字符串
对于一个压缩字符串，设计一个数据结构，它支持如下两种操作： next 和 hasNext。

给定的压缩字符串格式为：每个字母后面紧跟一个正整数，这个整数表示该字母在解压后的字符串里连续出现的次数。

next() - 如果压缩字符串仍然有字母未被解压，则返回下一个字母，否则返回一个空格。
hasNext() - 判断是否还有字母仍然没被解压。

注意：

请记得将你的类在 StringIterator 中 初始化 ，因为静态变量或类变量在多组测试数据中不会被自动清空。更多细节请访问 这里 。

示例：

StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

iterator.next(); // 返回 'L'
iterator.next(); // 返回 'e'
iterator.next(); // 返回 'e'
iterator.next(); // 返回 't'
iterator.next(); // 返回 'C'
iterator.next(); // 返回 'o'
iterator.next(); // 返回 'd'
iterator.hasNext(); // 返回 true
iterator.next(); // 返回 'e'
iterator.hasNext(); // 返回 false
iterator.next(); // 返回 ' '*/
    //超时
    Deque<Character> deque = new LinkedList<>();
/*
    public lc604_迭代压缩字符串(String compressedString) {
        char[] chars = compressedString.toCharArray();
        Deque<Character> dequeChar = new LinkedList<>();
        Deque<Integer> dequeInt = new LinkedList<>();
        int flag = 0;
        while (flag < chars.length) {
            if (!Character.isDigit(chars[flag])) {
                dequeChar.offerLast(chars[flag]);
                flag++;
            } else {
                StringBuilder sb = new StringBuilder();
                int tmp = 0;
                for (int i = flag; i < chars.length; i++) {
                    if (Character.isDigit(chars[i])) {
                        sb.append(chars[i]);
                        tmp = i;
                    } else {
                        break;
                    }
                }
                flag = tmp + 1;


                dequeInt.offerLast(Integer.parseInt(sb.toString()));
            }

        }

        System.out.println(dequeInt);
        System.out.println(dequeChar);

        while (!dequeChar.isEmpty()) {
            int times = dequeInt.pollFirst();
            char cha = dequeChar.pollFirst();
            for (int i = 0; i < times; i++) {
                deque.offerLast(cha);
            }
        }
        System.out.println(deque);
    }

    public char next() {
        return deque.isEmpty() ? ' ' : deque.pollFirst();
    }

    public boolean hasNext() {
        return !deque.isEmpty();

    }*/

    Deque<Character> dequeChar = new LinkedList<>();
    Deque<Integer> dequeInt = new LinkedList<>();

    public lc604_迭代压缩字符串(String compressedString) {
        char[] chars = compressedString.toCharArray();

        int flag = 0;
        while (flag < chars.length) {
            if (!Character.isDigit(chars[flag])) {
                dequeChar.offerLast(chars[flag]);
                flag++;
            } else {
                StringBuilder sb = new StringBuilder();
                int tmp = 0;
                for (int i = flag; i < chars.length; i++) {
                    if (Character.isDigit(chars[i])) {
                        sb.append(chars[i]);
                        tmp = i;
                    } else {
                        break;
                    }
                }
                flag = tmp + 1;


                dequeInt.offerLast(Integer.parseInt(sb.toString()));
            }

        }

        System.out.println(dequeInt);
        System.out.println(dequeChar);

    }

    public char next() {
        if(dequeChar.isEmpty()){
            return ' ';
        }else{
            char cha = dequeChar.pollFirst();
            char res = cha;
            int times = dequeInt.pollFirst();
            times--;
            if (times != 0) {
                dequeChar.offerFirst(cha);
                dequeInt.offerFirst(times);
            }
            return res;
        }

    }

    public boolean hasNext() {
        return !dequeChar.isEmpty();

    }
}

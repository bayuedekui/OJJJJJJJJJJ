package com.bayuedekui.algorithmsketch.design;

import java.util.Deque;
import java.util.LinkedList;

public class lc1628_设计带解析函数的表达式树 {
    /**
     * This is the interface for the expression tree Node.
     * You should not remove it, and you can define some classes to implement it.
     */

    abstract class Node {
        public abstract int evaluate();
        // define your fields here
    }

    ;


    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input
     * and returns the expression tree represnting it as a Node.
     */

    class TreeBuilder {
        Node buildTree(String[] postfix) {
            // 当作栈用
            Deque<NewNode> deque = new LinkedList<>();
            for (int i = 0; i < postfix.length; i++) {
                NewNode node = new NewNode(postfix[i]);
                if (postfix[i].equals("+") || postfix[i].equals("-") || postfix[i].equals("*") || postfix[i].equals("/")) {
                    node.right = deque.poll();
                    node.left = deque.poll();
                }
                deque.offer(node);
            }
            return deque.poll();
        }
    }

    ;


    /**
     * Your TreeBuilder object will be instantiated and called as such:
     * TreeBuilder obj = new TreeBuilder();
     * Node expTree = obj.buildTree(postfix);
     * int ans = expTree.evaluate();
     */
    class NewNode extends Node {
        String value;
        NewNode left;
        NewNode right;

        NewNode(String val) {
            this.value = val;
        }


        @Override
        public int evaluate() {
            switch (value) {
                case "+":
                    return left.evaluate() + right.evaluate();
                case "-":
                    return left.evaluate() - right.evaluate();
                case "*":
                    return left.evaluate() * right.evaluate();
                case "/":
                    return left.evaluate() / right.evaluate();
                default:
                    return Integer.parseInt(value);
            }
        }
    }
}

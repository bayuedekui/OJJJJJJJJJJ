package com.bayuedekui.algorithmsketch.tree.middle;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class lc117_填充每个节点的下一个右侧节点指针II {
    public Node connect(Node node) {
        if (node == null) {
            return null;
        }
        if (node != null) {
            node.next = null;
        }

        traceBack(node.left, node.right);

    }

    public void traceBack(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }

        left.next = right;

        //同一父节点的子节点
        traceBack(left.left, left.right);
        traceBack(right.left, right.right);

        //兄弟节点（不同父节点）的子节点
        traceBack(left.right, right.left);

    }
}

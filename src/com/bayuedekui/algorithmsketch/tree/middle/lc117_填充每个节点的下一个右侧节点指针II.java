package com.bayuedekui.algorithmsketch.tree.middle;

class NNode {
    public int val;
    public NNode left;
    public NNode right;
    public NNode next;

    public NNode() {
    }

    public NNode(int _val) {
        val = _val;
    }

    public NNode(int _val, NNode _left, NNode _right, NNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class lc117_填充每个节点的下一个右侧节点指针II {
    public NNode connect(NNode node) {
        if (node == null) {
            return null;
        }
        if (node != null) {
            node.next = null;
        }

        traceBack(node.left, node.right);

        return node;
    }

    public void traceBack(NNode left, NNode right) {
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


    public NNode connect1(NNode node) {
        if (node == null) {
            return null;
        }

        if (node != null) {
            node.next = null;
        }

        traceBack1(node.left, node.right);

        return node;
    }

    public void traceBack1(NNode left, NNode right) {
        if (left == null || right == null) {
            return;
        }

        left.next = right;

        // 同一父节点
        traceBack1(left.left, left.right);
        traceBack1(right.left, right.right);

        // 不同父节点
        if (left.right != null && right.left != null) {
            traceBack1(left.right, right.left);
        }
        if (left.right != null && right.left == null) {
            traceBack1(left.right, right.right);
        }
        if (left.right == null && right.left != null) {
            traceBack1(left.left, right.left);
        }
        if (left.right == null && right.left == null) {
            traceBack1(left.left, right.right);
        }


    }
}

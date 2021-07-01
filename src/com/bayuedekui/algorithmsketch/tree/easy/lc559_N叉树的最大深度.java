package com.bayuedekui.algorithmsketch.tree.easy;

import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class lc559_N叉树的最大深度 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children.isEmpty()) {
            return 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(maxDepth(root.children.get(i)),max);
        }

        return max + 1;

    }


}

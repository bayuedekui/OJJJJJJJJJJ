package com.bayuedekui.algorithmsketch.tree.middle;


import java.util.*;

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

public class lc429_N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> que = new LinkedList<>();
        que.offerLast(root);

        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            System.out.println(que);
            for (int i = 0; i < size; i++) {
                Node tmp = que.pollFirst();
                list.add(tmp.val);
                que.addAll(tmp.children);
            }
            res.add(list);
        }

        return res;
    }

}

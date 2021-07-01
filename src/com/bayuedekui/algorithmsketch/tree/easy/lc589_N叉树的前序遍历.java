package com.bayuedekui.algorithmsketch.tree.easy;

import java.util.ArrayList;
import java.util.List;

public class lc589_N叉树的前序遍历 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        dlr(root);
        return res;
    }

    public void dlr(Node node) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        for (int i = 0; i < node.children.size(); i++) {
            dlr(node.children.get(i));
        }
    }
}

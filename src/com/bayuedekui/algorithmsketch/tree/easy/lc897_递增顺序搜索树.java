package com.bayuedekui.algorithmsketch.tree.easy;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class lc897_递增顺序搜索树 {
    public TreeNode increasingBST(TreeNode root) {
        ldr(root);
        TreeNode res = new TreeNode(-1);
        TreeNode tmp = res;
        for (int i = 0; i < list.size()-1; i++) {
            tmp.right = new TreeNode(list.get(i));
            tmp = tmp.right;
        }
        return res.right;

    }

    List<Integer> list = new ArrayList<>();

    public void ldr(TreeNode root) {
        if (root == null) {
            return;
        }
        ldr(root.left);
        list.add(root.val);
        ldr(root.right);
    }
}

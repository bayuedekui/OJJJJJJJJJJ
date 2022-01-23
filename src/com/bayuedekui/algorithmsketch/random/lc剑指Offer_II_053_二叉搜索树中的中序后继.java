package com.bayuedekui.algorithmsketch.random;

public class lc剑指Offer_II_053_二叉搜索树中的中序后继 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode res = null;
        while (cur != null) {
            if (cur.val > p.val) {
                // 当前有可能是p的中序后继
                res = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return res;

    }
}

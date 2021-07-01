package com.bayuedekui.algorithmsketch.tree.middle;

public class lc104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int max = Integer.MIN_VALUE;
        if (root.left != null) {
            max = Math.max(maxDepth(root.left), max);
        }
        if (root.right != null) {
            max = Math.max(maxDepth(root.right), max);
        }

        return max + 1;

    }
}

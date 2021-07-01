package com.bayuedekui.algorithmsketch.tree.middle;

public class lc543_二叉树的直径 {
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res - 1;
    }

    int res = Integer.MIN_VALUE;

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left + right + 1);

        return Math.max(left, right) + 1;

    }

}

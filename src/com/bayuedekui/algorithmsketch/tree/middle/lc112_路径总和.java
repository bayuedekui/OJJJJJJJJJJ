package com.bayuedekui.algorithmsketch.tree.middle;

public class lc112_路径总和 {

    //踩用递归
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum==root.val;

        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }
}

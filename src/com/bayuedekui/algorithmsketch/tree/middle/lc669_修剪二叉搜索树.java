package com.bayuedekui.algorithmsketch.tree.middle;

public class lc669_修剪二叉搜索树 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 二叉搜索树的特性，如果root.val小于left,则root==root.right
        // 如果root.val大于right,则root=root.left
        // 如果在【left,right】之间，则重复递归root.left=trimBST(root.left),root.right=trimBST(root.right)
        if (root == null) {
            return root;
        }
        if (root.val < low) {
            root = root.right;
            root = trimBST(root, low, high);
        } else if (root.val > high) {
            root = root.left;
            root = trimBST(root, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }

        return root;
    }
}

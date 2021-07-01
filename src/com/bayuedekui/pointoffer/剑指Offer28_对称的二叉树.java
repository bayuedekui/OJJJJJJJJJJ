package com.bayuedekui.pointoffer;

public class 剑指Offer28_对称的二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);

    }

    public boolean recur(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A.val != B.val || A == null || B == null) {
            return false;
        }
        return recur(A.left, B.right) && recur(A.right, B.left);
    }*/

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return traceBack(root.left, root.right) && traceBack(root.right, root.left);
    }

    public boolean traceBack(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null || A.val != B.val) {
            return false;
        }
        return traceBack(A.left, B.right) && traceBack(A.right, B.right);
    }
}

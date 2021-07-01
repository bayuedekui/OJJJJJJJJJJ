package com.bayuedekui.pointoffer;

public class 剑指Offer26_树的子结构 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    public boolean recur(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return recur(a.left, b.left) && recur(a.right, b.right);

    }*/


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        return traceBack(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    public boolean traceBack(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null || A.val != B.val) {
            return false;
        }
        return traceBack(A.left, B.left) && traceBack(A.right, B.right);

    }
}

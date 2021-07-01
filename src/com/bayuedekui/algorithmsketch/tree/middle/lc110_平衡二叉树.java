package com.bayuedekui.algorithmsketch.tree.middle;


public class lc110_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);


    }

    public int height(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return Math.max(height(root.left), height(root.right)) + 1;

    }

}

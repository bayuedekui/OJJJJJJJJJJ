package com.bayuedekui.algorithmsketch.tree.middle;

public class    lc111_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        if(root.left==null&&root.right==null){
            return 1;
        }

        int min = Integer.MAX_VALUE;
        if(root.left!=null){
            min = Math.min(minDepth(root.left), min);
        }
        if(root.right!=null){
            min = Math.min(minDepth(root.right), min);
        }

        return min;

    }

}

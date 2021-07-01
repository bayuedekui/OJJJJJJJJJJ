package com.bayuedekui.pointoffer;

public class 剑指Offer27_二叉树的镜像 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }*/

    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        //递归交换树的左右子树
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);

        return root;
    }
}

package com.bayuedekui.algorithmsketch.tree.middle;

public class lc563_二叉树的坡度 {
    int res = 0;

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        subSum = 0;
        int left = getSubTreeSum(root.left);
        subSum = 0;
        int right = getSubTreeSum(root.right);
        res += Math.abs(left - right);


        findTilt(root.left);
        findTilt(root.right);

        return res;
    }


    int subSum = 0;

    //求一个树所有节点的和
    public int getSubTreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        subSum += root.val;
        getSubTreeSum(root.left);
        getSubTreeSum(root.right);
        return subSum;
    }
}

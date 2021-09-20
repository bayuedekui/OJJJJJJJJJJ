package com.bayuedekui.algorithmsketch.design;


import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class lc1261_在受污染的二叉树中查找元素 {
    TreeNode treeNode = new TreeNode(0);
    List<Integer> list = new ArrayList<>();


    public lc1261_在受污染的二叉树中查找元素(TreeNode root) {
        //先还原二叉树
        treeNode=root;
        treeNode.val = 0;
        list.add(0);
        dfs(treeNode);
    }

    public void dfs(TreeNode root) {
        if (root.left != null) {
            root.left.val = 2 * root.val + 1;
            list.add(root.left.val);
            dfs(root.left);
        }
        if(root.right!=null){
            root.right.val=2*root.val+2;
            list.add(root.right.val);
            dfs(root.right);
        }
    }


    public boolean find(int target) {
        return list.contains(target);
    }


}

package com.bayuedekui.algorithmsketch.tree.middle;

import java.util.HashMap;
import java.util.Map;

public class lc662_二叉树最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
        // 取一个map用来记录每一层深度最左端的位置，pos表示每个节点的位置，2*pos表示左子树位置，2*pos+1表示右子树位置
        if (root==null) {
            return 0;
        }
        dfs(root,0,0);
        return res;
    }

    int res=Integer.MIN_VALUE;
    Map<Integer, Integer> left = new HashMap<>();

    public void dfs(TreeNode root,int depth,int pos){
        if(root==null){
            return;
        }
        // 如果没有值，就将pos作为value值赋值给map中的key
        left.computeIfAbsent(depth,key->pos);
        res=Math.max(res,pos-left.get(depth)+1);
        dfs(root.left,depth+1,2*pos);
        dfs(root.right,depth+1,2*pos+1);
    }
}

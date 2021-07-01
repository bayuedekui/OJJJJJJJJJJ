package com.bayuedekui.algorithmsketch.tree.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class lc993_二叉树的堂兄弟节点 {

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 1);
        System.out.println(map);
        //map中key不同，val同
        Set<Integer> trees = map.keySet();
        if(trees.size()!=2){
            return false;
        }

        Integer tmp = null;
        for(Integer tree:trees){
            if(tmp==null){
                tmp=tree;
            }else{
                return map.get(tmp) != map.get(tree);
            }
        }
        return true;

    }

    Map<Integer, Integer> map = new HashMap<>();

    //获取节点的父节点和深度信息
    public void dfs(TreeNode root, int x, int y, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        if ((root.left != null && root.left.val == x) || (root.right != null && root.right.val == x)) {
            map.put(root.val, depth);
        }
        if ((root.left != null && root.left.val == y) || (root.right != null && root.right.val == y)) {
            map.put(root.val, depth);
        }

        dfs(root.left, x, y, depth + 1);
        dfs(root.right, x, y, depth + 1);
    }

}

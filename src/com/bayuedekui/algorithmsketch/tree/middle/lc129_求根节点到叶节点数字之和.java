package com.bayuedekui.algorithmsketch.tree.middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc129_求根节点到叶节点数字之和 {
    public int sumNumbers(TreeNode root) {
        dfs(root);
        int res=0;
        for(Deque<Integer> path:list){
            System.out.println(path);
            res += calcSum(path);
        }
        return res;

    }

    Deque<Integer> path = new LinkedList<>();
    List<Deque<Integer>> list = new ArrayList<>();

    //采用dfs将所有的路径计算出来
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        path.offerLast(root.val);

        //到子节点就停止，将根节点到子节点路径记录下来
        if (root.left == null && root.right == null) {
            list.add(new LinkedList<>(path));
        }

        dfs(root.left);
        dfs(root.right);

        path.pollLast();
    }


    //计算一个字符串数字和
    public int calcSum(Deque<Integer> path) {
        int size = path.size()-1;
        int res = 0;
        while (!path.isEmpty()) {
            res += path.pollFirst() * Math.pow(10, size);
            size--;
        }
        return res;
    }
}

package com.bayuedekui.algorithmsketch.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

public class lc112_路径总和 {
    //采用递归
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }


    //采用广度优先遍历
    public boolean bfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> node = new LinkedList<>();
        Queue<Integer> val = new LinkedList<>();

        node.offer(root);
        val.offer(root.val);

        while (!node.isEmpty()) {
            TreeNode now = node.poll();
            int tmp = val.poll();
            if (now.left == null && now.right == null) {
                if (tmp == targetSum) {
                    return true;
                }
                continue;
            }

            if (now.left != null) {
                node.offer(now.left);
                val.offer(now.left.val + tmp);
            }

            if(now.right!=null){
                node.offer(now.right);
                val.offer(now.right.val + tmp);
            }

        }

        return false;
    }
}

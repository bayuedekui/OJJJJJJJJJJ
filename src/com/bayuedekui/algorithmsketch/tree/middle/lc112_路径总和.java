package com.bayuedekui.algorithmsketch.tree.middle;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class lc112_路径总和 {

    //采用递归,深度遍历
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    // 广度遍历
    public boolean hasPathSumBFS(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> node = new LinkedList<>();
        Queue<Integer> val = new LinkedList<>();

        node.offer(root);
        val.offer(root.val);

        while (!node.isEmpty()) {
            TreeNode tmpN = node.poll();
            int tmpV = val.poll();
            if (tmpN.left == null && tmpN.right == null) {
                if (tmpV == targetSum) {
                    return true;
                }
            }

            if (tmpN.left != null) {
                node.offer(tmpN.left);
                val.offer(tmpN.left.val + tmpV);
            }

            if (tmpN.right != null) {
                node.offer(tmpN.right);
                val.offer(tmpN.right.val + tmpV);
            }

        }
        return false;

    }

    @Test
    public void test(){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        hasPathSumBFS(tree, 2);
    }
}

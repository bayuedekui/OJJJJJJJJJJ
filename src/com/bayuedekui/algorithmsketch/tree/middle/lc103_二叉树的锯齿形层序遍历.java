package com.bayuedekui.algorithmsketch.tree.middle;

import java.util.*;

public class lc103_二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean startLeft = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            Deque<Integer> deque = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tree = queue.poll();
                if (startLeft) {
                    deque.offerLast(tree.val);
                } else {
                    deque.offerFirst(tree.val);
                }

                if (tree.left != null) {
                    queue.add(tree.left);
                }
                if (tree.right != null) {
                    queue.add(tree.right);
                }


            }
            res.add(new ArrayList<>(deque));
            startLeft = !startLeft;

        }
        return res;
    }

}

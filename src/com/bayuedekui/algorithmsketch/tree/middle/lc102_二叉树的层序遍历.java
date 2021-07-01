package com.bayuedekui.algorithmsketch.tree.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc102_二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        //采用队列，先根节点进入，然后左右子树进入queue
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        //声明队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                tmp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }


}

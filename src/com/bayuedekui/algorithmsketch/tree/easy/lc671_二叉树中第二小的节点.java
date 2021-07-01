package com.bayuedekui.algorithmsketch.tree.easy;

import java.util.*;

public class lc671_二叉树中第二小的节点 {
    public int findSecondMinimumValue(TreeNode root) {
        ldr(root);
        Set<Integer> keys = map.keySet();
        if (keys.size() == 1) {
            return -1;
        }
        List<Integer> res = new ArrayList<>();
        for (Integer i : keys) {
            res.add(i);
        }

        Collections.sort(res);
        return res.get(1);


    }


    Map<Integer, Integer> map = new HashMap<>();

    public void ldr(TreeNode root) {
        if (root == null) {
            return;
        }
        ldr(root.left);
        map.put(root.val, 1);
        ldr(root.right);
    }
}

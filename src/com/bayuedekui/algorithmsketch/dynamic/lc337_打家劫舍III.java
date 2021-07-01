package com.bayuedekui.algorithmsketch.dynamic;

import java.util.HashMap;
import java.util.Map;

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

public class lc337_打家劫舍III {
    public int rob(TreeNode root) {
        return dp(root);
    }

    //自顶向下的dp
    Map<TreeNode, Integer> map = new HashMap<>();

    public int dp(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (map.get(root) != null) {
            return map.get(root);
        }

        //如果抢了当前，那么只能只能抢下左左，下左右，下右左，下右右
        //抢了当前
        int goRob = root.val + (root.left != null ? dp(root.left.left) + dp(root.left.right) : 0)
                + (root.right != null ? dp(root.right.left) + dp(root.right.right) : 0);

        //不抢当前
        int denyRob = dp(root.left) + dp(root.right);

        int res = Math.max(goRob, denyRob);
        map.put(root, res);
        return res;
    }

}

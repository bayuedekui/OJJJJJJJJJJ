package com.bayuedekui.algorithmsketch.tree.middle;

public class lc687_最长同值路径 {
    public int longestUnivaluePath(TreeNode root) {
        // dfs法：先递归算出左右子树的连续数字的个数，然后判断根节点是否相同，相同则left/right进行++，
        // 否则就直接为零
        dfs(root);
        return res;
    }

    int res=0;
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.left != null && root.val == root.left.val) {
            left++;
        } else {
            left = 0;
        }

        if (root.right != null && root.val == root.right.val) {
            right++;
        } else {
            right = 0;
        }
        res = Math.max(res, left + right);

        return Math.max(left, right);
    }
}

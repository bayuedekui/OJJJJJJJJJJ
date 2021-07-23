package com.bayuedekui.algorithmsketch.tree.middle;

public class lc面试题04_12_求和路径 {
    public int pathSum(TreeNode root, int sum) {
        // 采用dfs,一旦总和达到sum,则cnt++,然后分为根节点递归，左右子树分别递归
        if (root == null) {
            return 0;
        }
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return cnt;

    }

    int cnt = 0;

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            cnt++;
        }

        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}

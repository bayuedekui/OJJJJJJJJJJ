package com.bayuedekui.algorithmsketch.tree.middle;

public class lc572_另一个树的子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSub(root, subRoot)) {
            return true;
        }
        if (root.left != null) {
            if (isSubtree(root.left, subRoot)) {
                return true;
            }
        }
        if (root.right != null) {
            if (isSubtree(root.right, subRoot)) {
                return true;
            }
        }

        return false;

    }


    public boolean isSub(TreeNode node, TreeNode subNode) {
        if (node == null && subNode == null) {
            return true;
        }
        if (node == null || subNode == null) {
            return false;
        }

        if (node.val != subNode.val) {
            return false;
        }
        return isSub(node.left, subNode.left) && isSub(node.right, subNode.right);
    }
}

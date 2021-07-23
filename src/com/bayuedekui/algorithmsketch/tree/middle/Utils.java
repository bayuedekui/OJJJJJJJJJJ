package com.bayuedekui.algorithmsketch.tree.middle;

import java.util.Deque;

public class Utils {

    public TreeNode build(Deque<String> que) {
        if (que.isEmpty()) {
            return null;
        }
        String fir = que.pollFirst();
        if (fir.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(fir));
        root.left = build(que);
        root.right = build(que);
        return root;
    }
}

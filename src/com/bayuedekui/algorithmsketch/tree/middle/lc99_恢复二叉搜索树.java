package com.bayuedekui.algorithmsketch.tree.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc99_恢复二叉搜索树 {

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        // 先用ldr的方式找出排序的结果
        ldr(root);

        // 找出要替换的位置
        int[] swap = findSwap();
        System.out.println(swap[0] + "---" + swap[1]);

        // 遍历树，将需要替换的地方替换了
        changVal(root, 2, swap);


    }

    // 更换树中的关键值
    public void changVal(TreeNode root, int cnt, int[] swap) {
        if (root != null) {
            if (root.val == swap[0] || root.val == swap[1]) {
                root.val = root.val == swap[0] ? swap[1] : swap[0];
                // 只有发生了交换，才会做减法
                if (--cnt == 0) {
                    return;
                }
            }
        }

        if (root != null) {
            changVal(root.left, cnt, swap);
            changVal(root.right, cnt, swap);
        }


    }


    // 寻找出list中不升序的地方
    public int[] findSwap() {
        int[] res = new int[2];
        boolean flag = false;
        for (int j = list.size() - 1; j >= 1; j--) {
            for (int i = 0; i < j; i++) {
                if (list.get(i) > list.get(j)) {
                    res[0] = list.get(i);
                    res[1] = list.get(j);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        return res;
    }


    List<Integer> list = new ArrayList<>();

    public void ldr(TreeNode root) {
        if (root == null) {
            return;
        }
        ldr(root.left);
        list.add(root.val);
        ldr(root.right);

    }


}

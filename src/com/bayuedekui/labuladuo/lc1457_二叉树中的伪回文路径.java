package com.bayuedekui.labuladuo;


import java.util.*;

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

public class lc1457_二叉树中的伪回文路径 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> tmp = new LinkedList<>();

    public int pseudoPalindromicPaths(TreeNode root) {
        // 找出二叉树的所有路径
        traceBack(root);
        int cnt = 0;
        // 基于所有的路径找出是否回文
        for (List<Integer> r : res) {
            if (isHuiwen(r)) {
                cnt++;
            }
        }
        return cnt;
    }

    public boolean isHuiwen(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        // 将所有的数放入map中计数
        for (int i : list) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int size = list.size();
        // 如果size为奇数，只能又一个奇数个字符，剩下的为偶数个字符
        if (size % 2 == 1) {
            int flag = 0;
            Iterator<Integer> values = map.values().iterator();
            while (values.hasNext()) {
                if (values.next() % 2 != 0) {
                    flag++;
                }
                if (flag > 1) {
                    System.out.println(list+"==>false");
                    return false;
                }
            }
            System.out.println(list+"==>true");
        }

        // 如果size为偶数，那所有的都要为偶数个字符
        if (size % 2 == 0) {
            int flag = 0;
            Iterator<Integer> values = map.values().iterator();
            while (values.hasNext()) {
                if (values.next() % 2 != 0) {
                    flag++;
                }
                if (flag != 0) {
                    System.out.println(list+"==>false");
                    return false;
                }
            }
            System.out.println(list+"==>true");
        }
        return true;
    }

    // 递归找出所有路径
    public void traceBack(TreeNode root) {
        if (root == null) {
            return;
        }

        tmp.add(root.val);
        if (root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < tmp.size(); i++) {
                list.add(tmp.get(i));
            }
            res.add(list);
        }

        traceBack(root.left);
        traceBack(root.right);

        tmp.removeLast();
    }


}


class lc257_二叉树的所有路径 {
    List<String> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {


    }

    public void traceback(TreeNode root) {
        if (root == null) {

        }

    }
}

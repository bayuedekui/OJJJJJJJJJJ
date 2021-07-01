package com.bayuedekui.algorithmsketch.tree.middle;

import java.util.*;

public class lc113_路径总和II {


    /*Map<TreeNode, TreeNode> map = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();

    //采用广度遍历
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> node = new LinkedList<>();
        Queue<Integer> val = new LinkedList<>();

        node.offer(root);
        val.offer(root.val);


        while (!node.isEmpty()) {
            TreeNode now = node.poll();
            Integer tmp = val.poll();
            if (now.left == null && now.right == null) {
                if (tmp == targetSum) {
                   findPath(now);
                }
            }

            if (now.left != null) {
                //记录每个节点的父节点
                map.put(now.left, now);
                node.offer(now.left);
                val.offer(tmp + now.left.val);
            }

            if (now.right != null) {
                //记录每个节点的父节点
                map.put(now.right, now);
                node.offer(now.right);
                val.offer(tmp + now.right.val);
            }
        }
        return res;

    }

    //找每个叶子节点对应的父节点，进而找出一条符合条件的路径
    public void findPath(TreeNode leaf) {
        List<Integer> list = new ArrayList<>();
        while (leaf != null) {
            list.add(leaf.val);
            leaf =map.get(leaf);
        }
        //本来是从叶子到根节点，需要reverse一下
        Collections.reverse(list);

        res.add(new LinkedList<>(list));

    }*/


    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        dfs(root,targetSum);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> deque = new LinkedList<>();

    //采用dfs
    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        deque.offerLast(root.val);
        sum -= root.val;

        if (root.left == null && root.right == null && sum == 0) {
            res.add(new LinkedList<>(deque));
        }

        dfs(root.left, sum);
        dfs(root.right, sum);

        //退出到上一层，再进行到下一层
        deque.pollLast();

    }
}

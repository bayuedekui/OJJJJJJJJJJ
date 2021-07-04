package com.bayuedekui.algorithmsketch.tree.middle;

import java.util.*;

public class lc113_路径总和II {

    // 采用bfs遍历
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


    // 采用dfs
    /*public List<List<Integer>> pathSum(TreeNode root, int targetSum){
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

    }*/


    // 采用dfs
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> que = new LinkedList<>();

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        // 像路径中添加路径
        que.offerLast(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                res.add(new LinkedList<>(que));
            }
        }

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);

        // 退到上一层进行下面的遍历
        que.pollLast();
    }


    // 采用bfs
    public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        // 先用bfs找出符合条件的所有叶子节点，然后通过叶子节点找出一条父节点的路
        if (root == null) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();

        Queue<TreeNode> queTree = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queTree.offer(root);
        queVal.offer(root.val);


        while (!queTree.isEmpty()) {
            TreeNode tmpTree = queTree.poll();
            Integer val = queVal.poll();
            if (tmpTree.left == null && tmpTree.right == null) {
                if (val == targetSum) {
                    // 该叶子节点时符合条件的
                    res.add(findParent(map, tmpTree, root));
                }

            }

            if (tmpTree.left != null) {
                queTree.offer(tmpTree.left);
                queVal.offer(val + tmpTree.left.val);
                map.put(tmpTree.left, tmpTree);//将父节点存入
            }

            if (tmpTree.right != null) {
                queTree.offer(tmpTree.right);
                queVal.offer(val + tmpTree.right.val);  //将父节点存入
                map.put(tmpTree.right, tmpTree);
            }

        }

        return res;
    }


    public List<Integer> findParent(Map<TreeNode, TreeNode> map, TreeNode leaf, TreeNode root) {
        List<Integer> path = new ArrayList<>();

        while (map.get(leaf) != null) {
            path.add(leaf.val);
            leaf = map.get(leaf);
        }
        path.add(root.val);

        Collections.reverse(path);

        return path;
    }


}

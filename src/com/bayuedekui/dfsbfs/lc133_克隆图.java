package com.bayuedekui.dfsbfs;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import java.util.*;

public class lc133_克隆图 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // 采用map记录key（表示入参的节点），value表示自己新建出来已经成功clone的节点
    Map<Node, Node> visited = new HashMap<>();

    // 采用dfs
    public Node cloneGraph(Node node) {
        // 如果node为空，则返回空
        if (node == null) {
            return node;
        }

        // 如果visist中已经存在
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 如果还未创建，需要创建
        Node cloneNode = new Node(node.val, new ArrayList<>());
        // 创建完成需要塞入visited中进行记录
        visited.put(node, cloneNode);

        // 处理邻居节点，使用递归dfs
        for (Node neighbor : node.neighbors) {
            // 需要增加邻居节点，如果邻居节点没有克隆，那也需要走一遍克隆流程
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        // 返回克隆节点
        return cloneNode;
    }


    // 采用bfs
    public Node cloneGraph2(Node node) {
        // 记录是否克隆过
        Map<Node, Node> visit = new HashMap<>();
        // 记录访问记录
        Deque<Node> deque = new LinkedList<>();

        if (node == null) {
            return node;
        }

        Node cloneNode = new Node(node.val, new ArrayList<>());
        visit.put(node, cloneNode);
        deque.offerLast(node);

        while (!deque.isEmpty()) {
            Node tmp = deque.pollFirst();

            // 访问邻居节点
            for (Node neigh : tmp.neighbors) {
                // 判断邻居节点是否被克隆
                if (!visit.containsKey(neigh)) {
                    // 进行邻居节点的克隆
                    visit.put(neigh, new Node(neigh.val, new ArrayList<>()));
                    // 未被克隆过的需要走一遍本身以及邻居节点的克隆过程，如果已经客隆过了，就无需再走一遍流程
                    deque.offerLast(neigh);
                }
                visit.get(tmp).neighbors.add(visit.get(neigh));
            }

        }
        return visit.get(node);

    }

}

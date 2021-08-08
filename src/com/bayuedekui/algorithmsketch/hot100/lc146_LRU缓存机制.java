package com.bayuedekui.algorithmsketch.hot100;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.Map;

public class lc146_LRU缓存机制 {
    class NewLinkedNode {
        int key;
        int value;
        NewLinkedNode pre;
        NewLinkedNode next;

        NewLinkedNode() {
        }

        NewLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int size = 0;
    int capacity = 0;
    NewLinkedNode head, tail;
    Map<Integer, NewLinkedNode> map = new HashMap<>();

    public lc146_LRU缓存机制(int capacity) {
        this.capacity = capacity;
        head = new NewLinkedNode();
        tail = new NewLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        NewLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }

        // 将该对应节点移到节点最顶头
        moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        NewLinkedNode node = map.get(key);
        if (node == null) {
            // 创建一个新的node
            NewLinkedNode newNode = new NewLinkedNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            // 插入数加1
            ++size;
            // 如果超过最大范围
            if (size > capacity) {
                // 删除结尾
                NewLinkedNode delNode = deleteTail();
                map.remove(delNode.key);
                --size;
            }
        } else {
            //当已经有这个节点，更新节点值+则将该节点移到头部
            node.value = value;
            moveToHead(node);
        }


    }

    // 将已经存在的节点移动到最前头
    public void moveToHead(NewLinkedNode node) {
        // 先删除该节点
        deleteNode(node);
        // 再插入头节点
        addToHead(node);
    }

    public void deleteNode(NewLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(NewLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public NewLinkedNode deleteTail() {
        NewLinkedNode end = tail.pre;
        deleteNode(end);
        return end;
    }
}

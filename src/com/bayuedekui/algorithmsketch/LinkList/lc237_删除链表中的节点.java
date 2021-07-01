package com.bayuedekui.algorithmsketch.LinkList;

public class lc237_删除链表中的节点 {
    public void deleteNode1(ListNode node, int val) {
        ListNode backupList = new ListNode(-7);
        backupList.next = node;
        ListNode tmp = backupList;
        while (node != null) {
            if (node.val == val) {
                tmp.next = node.next;
            }else{
                tmp=tmp.next;
            }
            node = node.next;
        }
    }

    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next = node.next.next;
    }

}

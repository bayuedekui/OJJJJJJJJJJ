package com.bayuedekui.pointoffer;

public class 剑指Offer22_链表中倒数第k个节点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode shahow=head;
        //计算head的长度
        int len=0;
        while(shahow!=null){
            len++;
            shahow = shahow.next;
        }
        int i=0;
        while(i<len-k){
            head = head.next;
            i++;
        }
        return head;
    }
}

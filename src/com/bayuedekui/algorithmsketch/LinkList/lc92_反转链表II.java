package com.bayuedekui.algorithmsketch.LinkList;

public class lc92_反转链表II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==1){
            return reversePointNode(head,right);
        }
        head.next = reverseBetween(head.next, left - 1, right);
        return head;

    }

    //反转整个链表
    public ListNode reverseAllList(ListNode head){
        if(head==null){
            return head;
        }
        ListNode last = reverseAllList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    ListNode terminal=null;
    //反转开头到前n个节点
    public ListNode reversePointNode(ListNode head,int n){
        if (n==1){
            terminal=head.next;
            return head;
        }
        ListNode last = reversePointNode(head.next, n - 1);
        head.next.next=head;
        head.next=terminal;
        return last;
    }


}

package com.bayuedekui.labuladuo;

public class lc160_相交链表 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 将两个链表接到一起，如果相交，就会有相等的，不相交最后式null
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            if(p1==null){
                p1 = headB;
            }else{
                p1 = p1.next;
            }

            if(p2==null){
                p2 = headA;
            }else{
                p2 = p2.next;
            }
        }
        return p1;

    }
}

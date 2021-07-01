package com.bayuedekui.algorithmsketch.LinkList;

import org.junit.Test;

public class lc876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode slow,fast;
        slow=head;
        fast=head;
        while(fast.next!=null && fast.next.next != null){
            slow=slow.next;
            fast = fast.next.next;
        }
        if(fast.next!=null){
            slow=slow.next;
        }
        return slow;
    }

    @Test
    public void test(){
        int[] arr = new int[]{1, 2, 3, 4,5};
        System.out.println(middleNode(Utils.reverseArrToListNode(arr)).val);
    }
}

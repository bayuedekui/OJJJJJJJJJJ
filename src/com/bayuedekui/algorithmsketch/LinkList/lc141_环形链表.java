package com.bayuedekui.algorithmsketch.LinkList;

import org.junit.Test;

public class lc141_环形链表 {
    /*public boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        boolean res = false;
        while (head != null) {
            if(list.contains(head)){
                res = true;
                break;
            }
            list.add(head);
            head = head.next;

        }
        return res;
    }*/


    public boolean hasCycle(ListNode head){
        if(head==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(head!=null){
            if(fast==null||fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }
        return true;
    }

    @Test
    public void test(){

    }
}



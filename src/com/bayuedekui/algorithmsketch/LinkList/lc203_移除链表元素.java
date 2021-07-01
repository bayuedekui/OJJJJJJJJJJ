package com.bayuedekui.algorithmsketch.LinkList;

import org.junit.Test;

public class lc203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        ListNode headList = new ListNode(-7);
        headList.next=head;
        ListNode tmp = headList;
        while (head != null) {
            if (head.val == val) {
                tmp.next=head.next;
            }else{
                tmp = tmp.next;
            }

            head = head.next;

        }
        return headList.next;

    }

    @Test
    public void test(){
        int[] arr = new int[]{6, 6, 6,6, 6, 6,6};
        Utils.printListNode(removeElements(Utils.reverseArrToListNode(arr),6));
    }
}

package com.bayuedekui.algorithmsketch.LinkList;

import org.junit.Test;

public class lc328_奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode odd = new ListNode(-7);
        ListNode resOdd = odd;
        ListNode even = new ListNode(-6);
        ListNode resEven = even;
        int i = 1;
        while (head != null) {
            if (i % 2 != 0) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            i++;
            head = head.next;
        }
        odd.next = resEven.next;
        even.next=null;
        return resOdd.next;
    }

    @Test
    public void test() {
        int[] arr = new int[]{2, 1, 3, 5, 6, 4, 7};
        Utils.printListNode(oddEvenList(Utils.reverseArrToListNode(arr)));
    }
}

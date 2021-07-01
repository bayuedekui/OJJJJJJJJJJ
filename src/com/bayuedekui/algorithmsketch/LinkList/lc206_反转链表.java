package com.bayuedekui.algorithmsketch.LinkList;

import org.junit.Test;

public class lc206_反转链表 {
    //采用递归方式
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }

    //采用交换节点的方式
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre, cur, nxt;
        cur = head;
        pre = null;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 3, 4};
        Utils.printListNode(reverseList(Utils.reverseArrToListNode(arr)));
    }
}

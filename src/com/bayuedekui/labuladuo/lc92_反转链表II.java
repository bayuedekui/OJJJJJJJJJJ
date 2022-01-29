package com.bayuedekui.labuladuo;

public class lc92_反转链表II {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // base case
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    // 采用递归方式，反转前k个链表
    ListNode successor;

    public ListNode reverseN(ListNode head, int k) {
        if (k == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, k - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}

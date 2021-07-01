package com.bayuedekui.algorithmsketch.LinkList;

import org.junit.Test;

public class lc1290_二进制链表转整数 {
    public int getDecimalValue(ListNode head) {
        //先将链表反转
        ListNode newHead = reverse(head);

        int res = 0;
        int two = 1;
        while (newHead != null) {
            res += (int) (newHead.val * Math.pow(2d, two - 1));
            two++;
            newHead = newHead.next;
        }

        //然后用反转的每个数字*2^(n-1)
        return res;
    }

    //翻转链表
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre, cur, nxt;
        pre = null;
        cur = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public ListNode reverseTraceback(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverseTraceback(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }

    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        Utils.printListNode(reverseTraceback(Utils.reverseArrToListNode(arr)));
    }
}

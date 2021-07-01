package com.bayuedekui.algorithmsketch.LinkList;

import org.junit.Test;

public class lc1721_交换链表中的节点 {
    public ListNode swapNodes(ListNode head, int k) {
        //采用特殊的快慢指针走法，融合了数学的思路
        //设置哑节点
        ListNode headList = new ListNode(-7);
        headList.next = head;
        ListNode pre, slow, fast;
        pre = headList;
        slow = headList;
        fast = headList;
        for (int i = 0; i < k; i++) {
            pre = pre.next;
            fast = fast.next;
        }

        //当fast走到最后时，slow正好走到倒数第K个节点（数学思维）
        while (fast != null) {
            slow=slow.next;
            fast = fast.next;
        }

        //交换pre节点和slow节点的值
        int tmp=pre.val;
        pre.val=slow.val;
        slow.val=tmp;
        return headList.next;

    }

    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6,7};
        int k=4;
        Utils.printListNode(swapNodes(Utils.reverseArrToListNode(arr),k));
    }
}

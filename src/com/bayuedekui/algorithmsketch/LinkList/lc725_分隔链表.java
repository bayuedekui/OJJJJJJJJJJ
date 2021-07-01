package com.bayuedekui.algorithmsketch.LinkList;

public class lc725_分隔链表 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode head = root;
        //遍历列表，查看链表的长度
        int t = 0;
        while (head != null) {
            t++;
            head = head.next;
        }
        int len = t / k;
        int extra = t % k;

        head = root;
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k; i++) {
            ListNode headList = new ListNode(-7);
            ListNode tmp = headList;
            for (int j = 0; j < len + (i < extra ? 1 : 0); j++) {
                tmp.next = new ListNode(head.val);
                tmp = tmp.next;
                if (head != null) {
                    head = head.next;
                }
            }
            res[i] = headList.next;
        }
        return res;
    }
}

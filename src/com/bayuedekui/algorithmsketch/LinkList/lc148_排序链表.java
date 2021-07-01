package com.bayuedekui.algorithmsketch.LinkList;

import org.junit.Test;

public class lc148_排序链表 {
    //采用外接第三方list,然后进行排序然后重建，此方法效率低下


    public ListNode sortList(ListNode head) {
        if(head==null){
            return head;
        }
        //采用插入排序的思路
        ListNode backUpList = new ListNode(-7);
        backUpList.next = head;
        ListNode sortedList = head;
        ListNode cur = sortedList.next;
        while (cur != null) {
            if (sortedList.val <= cur.val) {
                sortedList = sortedList.next;
            } else {
                //如果不同的话将，已经排序的进行重新排序
                ListNode first = backUpList;
                while (first.next.val <= cur.val) {
                    first = first.next;
                }
                sortedList.next = cur.next;
                cur.next = first.next;
                first.next = cur;
            }
            cur = sortedList.next;
        }
        return backUpList.next;

    }

    @Test
    public void test() {
        int[] arr = new int[]{4, 3, 2, 1};
        Utils.printListNode(sortList(Utils.reverseArrToListNode(arr)));
    }
}

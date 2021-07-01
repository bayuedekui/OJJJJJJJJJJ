package com.bayuedekui.pointoffer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class 剑指Offer25_合并两个排序的链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        while(l1!=null){
            list.add(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            list.add(l2.val);
            l2=l2.next;
        }
        Collections.sort(list);
        ListNode res = new ListNode(-1);
        ListNode tmp=res;
        for(int i=0;i<list.size();i++){
            tmp.next = new ListNode(list.get(i));
            tmp = tmp.next;
        }
        return res.next;

    }
}

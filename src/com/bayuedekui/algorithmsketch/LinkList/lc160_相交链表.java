package com.bayuedekui.algorithmsketch.LinkList;

import java.util.ArrayList;
import java.util.List;

public class lc160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while (headA != null) {
            list.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if(list.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}

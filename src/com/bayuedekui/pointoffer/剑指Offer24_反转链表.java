package com.bayuedekui.pointoffer;

import java.util.List;
import java.util.Stack;

public class 剑指Offer24_反转链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //效率低的方法
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode shadow = head;
        while(shadow!=null){
            stack.add(shadow.val);
            shadow = shadow.next;
        }
        ListNode res = new ListNode(-1);
        ListNode tmp=res;
        while(!stack.isEmpty()){
            tmp.next = new ListNode(stack.pop());
            tmp = tmp.next;
        }
        return res.next;
    }

    //原地切换指针法()
    public ListNode reverseList1(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode tmp=cur.next;
            cur.next = pre;
            pre=cur;
            cur=tmp;
        }
        return pre;
    }

}

package com.bayuedekui.algorithmsketch.LinkList;

import java.util.ArrayList;
import java.util.List;

public class lc143_重排链表 {
    //效率不够高
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int i=0, j=list.size()-1;
        while(i<j){
            if(i==j){
                break;
            }
            list.get(i).next = list.get(j);
            i++;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next=null;
    }

    public void reorderList1(ListNode head){

    }
    //快慢指针找到中间节点
    public ListNode getMiddle(ListNode head){
        if(head==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //将制定节点反转
    public ListNode reverse(ListNode head){
        if(head==null){
            return head;
        }
        ListNode last=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
    //合并左边ListNode和右边翻转过的链表
    public void merge(ListNode head,ListNode mid){
        ListNode nxt=mid.next;

        while(nxt!=null){
            head.next = nxt;
            head=head.next;
            nxt.next=head;
            nxt=nxt.next;
        }
    }

}

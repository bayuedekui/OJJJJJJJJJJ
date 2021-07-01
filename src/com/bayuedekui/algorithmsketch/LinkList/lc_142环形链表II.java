package com.bayuedekui.algorithmsketch.LinkList;

import java.util.ArrayList;
import java.util.List;

public class lc_142环形链表II {
    //暴力法子
    public ListNode detectCycle(ListNode head) {
        //采用快慢指针不能确保返回的就是第一个节点，采用list存楚的方法
        List<ListNode> list = new ArrayList<>();
        while(head!=null){
            if(list.contains(head)){
                return head;
            }
            list.add(head);
            head = head.next;
        }
        return null;
    }

    //双指针加上数学的方法，a=c+(n-1)(b+c),简单来说就是头指针出发，与快慢指针相遇点总会在初始环中遇到
    public ListNode detectCycle2(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null){
            slow=slow.next;
            if(fast.next!=null){
                fast=fast.next.next;
            }else{
                return null;
            }
           if(slow==fast){
               ListNode tmp=head;
               while(tmp!=slow){
                    tmp=tmp.next;
                    slow=slow.next;
               }
               return tmp;
           }
        }
        return null;
    }
}

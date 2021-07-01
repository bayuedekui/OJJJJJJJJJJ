package com.bayuedekui.algorithmsketch.LinkList;

import java.util.ArrayList;
import java.util.List;

public class lc817_链表组件 {
    public int numComponents(ListNode head, int[] G) {
        //将数组变为list
        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < G.length; i++) {
            arrList.add(G[i]);
        }
        int res = 0;
        boolean flag = false;
        while(head!=null){
            if(arrList.contains(head.val)){
                while (head != null && arrList.contains(head.val)) {
                    flag = true;
                    head = head.next;
                }
            }else{
                flag = false;
                head = head.next;
            }

            if(flag){
                res++;
            }
        }

        return res;
    }
}

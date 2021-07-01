package com.bayuedekui.algorithmsketch.LinkList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class lc1019_链表中的下一个更大节点 {
    public int[] nextLargerNodes(ListNode head) {
        if(head==null){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            ListNode tmp=head;
            int curVal = tmp.val;
            while (head.next != null && curVal >= head.next.val) {
                head = head.next;
            }
            if (head.next != null) {
                list.add(head.next.val);
            }else{
                list.add(0);
            }
            head = tmp.next;
        }

        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = new int[]{2,7,4,3,5};
        nextLargerNodes(Utils.reverseArrToListNode(arr));
    }
}

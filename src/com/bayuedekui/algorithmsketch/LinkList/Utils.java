package com.bayuedekui.algorithmsketch.LinkList;

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode listNode) {
        this.val = val;
        this.next = listNode;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Utils {
    // 数组转化成链表
    public static ListNode listNode = new ListNode(-1);
    public static ListNode res = listNode;

    public static ListNode reverseArrToListNode(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            listNode.next = new ListNode(arr[i]);
            listNode = listNode.next;
        }
        return res.next;
    }

    public static void printListNode(ListNode head){
        while(head!=null){
            System.out.print(head.val+"-");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        ListNode listNode = reverseArrToListNode(arr);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

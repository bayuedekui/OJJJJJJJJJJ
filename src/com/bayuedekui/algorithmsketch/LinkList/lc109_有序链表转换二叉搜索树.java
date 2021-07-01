package com.bayuedekui.algorithmsketch.LinkList;


public class lc109_有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildBSTTree(head, null);

    }

    //采用快慢指针找出链表中间节点
    public ListNode getMedia(ListNode start,ListNode end) {
        ListNode slow, fast;
        slow = start;
        fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //采用递归法构建二叉搜索树
    public TreeNode buildBSTTree(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }
        ListNode mid = getMedia(start,end);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildBSTTree(start, mid);
        root.right = buildBSTTree(mid.next, end);
        return root;
    }
}


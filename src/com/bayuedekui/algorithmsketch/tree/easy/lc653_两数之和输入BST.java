package com.bayuedekui.algorithmsketch.tree.easy;


import java.util.ArrayList;
import java.util.List;

public class lc653_两数之和输入BST {
    public boolean findTarget(TreeNode root, int k) {
        //采用BST的ldr遍历，然后采用左右指针来做
        ldr(root);
        int start=0;
        int end = list.size() - 1;
        while(start<end){
            if(list.get(start)+list.get(end)==k){
                return true;
            }else if(list.get(start)+list.get(end)<k){
                start++;
            }else{
                end--;
            }
        }
        return false;

    }

    List<Integer> list = new ArrayList<>();

    public void ldr(TreeNode root) {
        if (root == null) {
            return;
        }
        ldr(root.left);
        list.add(root.val);
        ldr(root.right);

    }
}

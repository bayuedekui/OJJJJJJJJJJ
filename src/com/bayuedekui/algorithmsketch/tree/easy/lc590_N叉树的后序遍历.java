package com.bayuedekui.algorithmsketch.tree.easy;

import java.util.ArrayList;
import java.util.List;

public class lc590_N叉树的后序遍历 {

    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        lrd(root);
        return res;
    }

    public void lrd(Node node){
        if(node==null){
            return;
        }
        for(int i=0;i<node.children.size();i++){
            lrd(node.children.get(i));
        }
        res.add(node.val);
    }

}

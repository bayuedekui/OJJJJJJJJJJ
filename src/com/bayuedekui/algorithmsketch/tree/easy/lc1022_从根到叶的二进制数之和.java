package com.bayuedekui.algorithmsketch.tree.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class lc1022_从根到叶的二进制数之和 {
    public int sumRootToLeaf(TreeNode root) {
        List<String> paths = new ArrayList<>();

        traceBack(root, "", paths);
        System.out.println(paths);
        int sum = 0;
        for (int i = 0; i < paths.size(); i++) {
            sum += calcSum(paths.get(i));
        }
        return sum;
    }


    //采用回退法dfs

    public void traceBack(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer sb = new StringBuffer(path);
            sb.append(root.val);
            if(root.left==null&&root.right==null){
                paths.add(sb.toString());
            }else{
                traceBack(root.left,sb.toString(),paths);
                traceBack(root.right,sb.toString(),paths);
            }
        }

    }

    public int calcSum(String str) {
        int res = 0;
        int base = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            String i1 = String.valueOf(str.charAt(i));
            res += Integer.parseInt(i1) * base;
            base *= 2;
        }
        return res;
    }


    @Test
    public void test(){
        System.out.println(calcSum("100"));
    }


    //一定要把回退的掌握
    public void traceBack2(TreeNode treeNode) {

    }


}

package com.bayuedekui.pointoffer;

import org.junit.Test;

public class 剑指Offer17_打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        //根据n构造最大位数的值
        int max = 0;
        for (int i = 0; i < n; i++) {
            max += (int) (9 * Math.pow(10, i));
        }

        int[] res = new int[max];
        for (int i = 1; i <= max; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    @Test
    public void test(){
        int[] ha = printNumbers(2);
        for(int i=0;i<ha.length;i++){
            System.out.println(ha[i]);
        }
    }
}

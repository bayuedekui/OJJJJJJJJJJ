package com.bayuedekui.pointoffer;

import org.junit.Test;

public class 剑指Offer15_二进制中1的个数 {
    public int hammingWeight(int n) {
        int res=0;
        while(n!=0){
            res += n & 1;
            n = n >>> 1;
        }
        return res;
    }


    @Test
    public void test(){
        System.out.println((int) 1001);
    }
}

package com.bayuedekui.algorithmsketch.random;

import org.junit.Test;

import java.math.BigInteger;

public class lc172_阶乘后的零 {
    // 用这种方式溢出
    /*public int trailingZeroes(int n) {
        double sum = 1;
        for (int i = n; i > 0; i--) {
            sum *= i;
        }
        System.out.println(sum);
        String tmp = String.valueOf(sum);
        int res = 0;
        for (int i = tmp.length() - 1; i >= 0; i--) {
            if (tmp.charAt(tmp.length() - 1) == '0' && tmp.charAt(i) == '0') {
                res++;
            }else{
                break;
            }
        }
        return res;
    }*/

    public int trailingZeroes(int n) {
        BigInteger bigInteger = BigInteger.ONE;
        // 求阶乘
        for (int i = 2; i <= n; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        int res = 0;
        while (!bigInteger.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            res++;
            bigInteger = bigInteger.mod(BigInteger.TEN);
        }
        return res;
    }

    public int trailingZeroes1(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = i;
            while(tmp>0){
                if(tmp%5==0){
                    res++;
                    tmp=tmp/5;
                }else{
                    break;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(trailingZeroes(100));
    }
}

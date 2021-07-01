package com.bayuedekui.pointoffer;

import org.junit.Test;

public class 剑指Offer16_数值的整数次方 {
    public double myPow(double x, int n) {
        double res = 1;
        if (n == 0) {
            return res;
        } else if (n > 0) {
            for (int i = 1; i <= n; i++) {
                res *= x;
            }
        } else {
            x = 1 / x;
            for (int i = 1; i <= n; i++) {
                res *= x;
            }

        }
        return res;
    }

    @Test
    public void test(){
        double x=4;
        System.out.println(1/8d);
    }
}

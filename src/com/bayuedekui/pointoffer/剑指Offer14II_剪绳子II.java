package com.bayuedekui.pointoffer;

import org.junit.Test;

public class 剑指Offer14II_剪绳子II {
    public int cuttingRope(int n) {
        if (n == 4) return 4;
        if (n < 4) {
            return n - 1;
        }
        long res = 1;
        while (n > 4) {
            res = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) res * n % 1000000007;




    }


    @Test
    public void test() {
        System.out.println(cuttingRope(10));
    }
}

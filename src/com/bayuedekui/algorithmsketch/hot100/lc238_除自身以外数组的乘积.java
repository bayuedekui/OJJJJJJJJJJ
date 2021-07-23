package com.bayuedekui.algorithmsketch.hot100;

public class lc238_除自身以外数组的乘积 {

    //超时
    /*public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = calc(nums, i);
        }
        return res;

    }

    public int calc(int[] nums, int except) {
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i != except) {
                res *= nums[i];
            }
        }
        return res;
    }*/

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        int[] left = new int[len];
        int[] right = new int[len];

        //left数组放i左边的数的乘积
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i-1];
        }

        //right数组表示i右边的数的乘积
        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;

    }
}

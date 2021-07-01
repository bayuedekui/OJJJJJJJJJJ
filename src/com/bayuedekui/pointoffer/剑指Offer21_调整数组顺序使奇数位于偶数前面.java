package com.bayuedekui.pointoffer;

import java.util.ArrayList;
import java.util.List;

public class 剑指Offer21_调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 0) {
                evens.add(nums[i]);
            } else {
                odds.add(nums[i]);
            }
        }
        int resLen = odds.size() + evens.size();
        int[] res = new int[resLen];
        for (int i = 0; i < resLen; i++) {
            if(i<odds.size()){
                res[i] = odds.get(i);
            }else{
                res[i] = evens.get(i - odds.size());
            }
        }
        return res;
    }
}

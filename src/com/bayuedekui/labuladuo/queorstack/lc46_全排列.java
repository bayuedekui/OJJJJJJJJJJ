package com.bayuedekui.labuladuo.queorstack;

import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

public class lc46_全排列 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        traceback(nums, tmp);
        return res;
    }

    public void traceback(int[] nums, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(nums[i])) {
                continue;
            }
            tmp.add(nums[i]);
            traceback(nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}

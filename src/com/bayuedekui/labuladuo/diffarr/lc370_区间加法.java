package com.bayuedekui.labuladuo.diffarr;

import org.junit.Assert;

import java.security.DigestInputStream;

public class lc370_区间加法 {
    public int[] getMopdifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        Difference diff = new Difference(res);
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int val = updates[i][2];
            diff.increment(start, end, val);
        }
        return diff.result();
    }

    class Difference {
        private int[] diff;

        public Difference(int[] nums) {
            assert nums.length > 0;
            diff = new int[nums.length];
            diff[0] = nums[0];
            // 进行差分数组的构建
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i] - 1;
            }
        }

        public void increment(int start, int end, int n) {
            // 相当于diff[start]+=1,diff[end+1]-=3
            diff[start] += n;
            if (end + 1 < diff.length) {
                diff[end + 1] -= n;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            // 根据diff来还原res数组
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }

    }
}

package com.bayuedekui.algorithmsketch.huawei;

public class lc303_区域和检索数组不可变 {
    int[] arr;

    public lc303_区域和检索数组不可变(int[] nums) {
        int len = nums.length;
        // arr记录nums中的前缀和，arr[1]表示下表为1的左边所有数的和
        // 在求sumRange（left,right）时，只需要arr[right+1]-arr[left]即可
        arr = new int[len + 1];
        for (int i = 0; i < len; i++) {
            arr[i + 1] = arr[i] + nums[i];
        }

    }

    public int sumRange(int left, int right) {
        return arr[right + 1] - arr[left];
    }
}

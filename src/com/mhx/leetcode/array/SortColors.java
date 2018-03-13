package com.mhx.leetcode.array;

import java.util.Arrays;

/**
 * @author MHX
 * @date 2018/3/13
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int[] counts =  new int [3];
        for (int num : nums) {
            counts[num]++;
        }
        int index = 0;
        for (int i = 0; i < counts[0]; ++i) {
            nums[index++] = 0;
        }
        for (int i = 0; i < counts[1]; ++i) {
            nums[index++] = 1;
        }
        for (int i = 0; i < counts[2]; ++i) {
            nums[index++] = 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 2, 2, 2, 1, 1, 0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

package com.mhx.leetcode.array;

/**
 * 209
 * @author MHX
 * @date 2018/3/14
 */
public class MinimumSizeSubarraySum {

    /**
     * Use two pointers
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int low = 0;
        int high = -1;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        while (low < nums.length) {
            if (sum < s && high + 1 < nums.length) {
                sum += nums[++high];
            } else {
                sum -= nums[low++];
            }
            if (sum >= s) {
                minLength = Math.min(minLength, high - low + 1);
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }
        return minLength;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(7, nums));
    }
}

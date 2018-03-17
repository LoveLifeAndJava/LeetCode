package com.mhx.leetcode.array;

import java.util.Arrays;

/**
 * 167
 * @author MHX
 * @date 2018/3/13
 */
public class TwoSumII {

    /**
     * use binary search to find target - numbers[i]
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] results = new int[2];
        for (int i = 0; i < numbers.length; ++i) {
            int low = i;
            int high = numbers.length;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (numbers[mid] == target - numbers[i]) {
                    results[0] = i + 1;
                    results[1] = mid + 1;
                    return results;
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return results;
    }

    /**
     * use two pointers: low and high to find target
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSumTwoPointers(int[] numbers, int target) {
        int[] results = new int[2];
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            if (numbers[low] + numbers[high] == target) {
                results[0] = low + 1;
                results[1] = high + 1;
                return results;
            } else if (numbers[low] + numbers[high] > target) {
                --high;
            } else {
                ++low;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        TwoSumII twoSumII = new TwoSumII();
        System.out.println(Arrays.toString(twoSumII.twoSumTwoPointers(numbers, 9)));
    }
}

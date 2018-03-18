package com.mhx.leetcode.set;

import java.util.HashMap;
import java.util.Map;

/**
 * 1
 * @author MHX
 * @date 2018/3/18
 */
public class TwoSum {
    /**
     * The problem guarantees only one solution.
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // if found, returns directly, or else if will be overwritten by the same key
            if (record.containsKey(complement)) {
                int[] res = {i, record.get(complement)};
                return res;
            }
            record.put(nums[i], i);
        }
        throw new IllegalStateException("the input has no solution");
    }

    public static void main(String[] args) {

    }
}

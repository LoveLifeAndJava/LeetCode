package com.mhx.leetcode.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 220
 *
 * @author MHX
 * @date 2018/3/20
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        if (k <= 0) {
            return false;
        }

        TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // the next element nums[i] should be:
            // abs(nums[i] - x) <= t -> nums[i] - t <= x <= nums[i] + t
            // (x is the element in the set)
            if (record.ceiling((long) nums[i] - t) != null
                    && record.ceiling((long) nums[i] - t) <= (long) nums[i] + t) {
                return true;
            }

            record.add((long) nums[i]);
            if (record.size() == k + 1) {
                // delete the leftmost element of the window
                // ensure the size of elements is k during the loop
                record.remove((long) nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}

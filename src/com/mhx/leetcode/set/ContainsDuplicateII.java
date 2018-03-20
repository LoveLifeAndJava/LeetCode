package com.mhx.leetcode.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 219
 *
 * @author MHX
 * @date 2018/3/20
 */
public class ContainsDuplicateII {
    /**
     * Change to problem to 'find the answer in [low, low + k]'
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicateMyVersion(int[] nums, int k) {
        if (k == 0) {
            return false;
        }

        int low = 0;
        int high = low + k;

        // Actually, only need to control the size of set == k + 1
        Set<Integer> elements = new HashSet<>();
        for (int i = 0; i <= high && i < nums.length; i++) {
            if (elements.contains(nums[i])) {
                return true;
            }
            elements.add(nums[i]);
        }

        while (high < nums.length) {
            if (high + 1 < nums.length) {
                elements.remove(nums[low++]);
                if (elements.contains(nums[high + 1])) {
                    return true;
                }
                elements.add(nums[++high]);
            } else {
                break;
            }
        }

        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null || nums.length <= 1) {
            return false;
        }

        if (k <= 0) {
            return false;
        }

        Set<Integer> record = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            }

            record.add(nums[i]);
            if (record.size() == k + 1) {
                // delete the leftmost element of the window
                // ensure the size of elements is k during the loop
                record.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII containsDuplicate = new ContainsDuplicateII();
        int[] nums1 = {-1, -1};
        System.out.println(containsDuplicate.containsNearbyDuplicate(nums1, 1));
        int[] nums2 = {1, 2, 1};
        System.out.println(containsDuplicate.containsNearbyDuplicate(nums2, 1));
    }
}

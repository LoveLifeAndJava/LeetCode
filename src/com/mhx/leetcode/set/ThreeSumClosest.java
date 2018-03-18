package com.mhx.leetcode.set;

import java.util.*;

/**
 * @author MHX
 * @date 2018/3/18
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        TreeMap<Integer, Integer> minSumMap = new TreeMap<>(Comparator.naturalOrder());
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; ++i) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                // Only need to put the relation mappings into the TreeMap, TreeMap will handle everything.
                minSumMap.put(Math.abs(nums[low] + nums[high] + nums[i] - target), nums[low] + nums[high] + nums[i]);
                if (nums[low] + nums[high] + nums[i] == target) {
                    return target;
                } else if (nums[low] + nums[high] + nums[i] < target) {
                    ++low;
                } else {
                    --high;
                }
            }
        }
        return minSumMap.firstEntry().getValue();
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
//        int[] arr1 = {-1, 2, 1, -4};
//        System.out.println(threeSumClosest.threeSumClosest(arr1, 1));
        int[] arr2 = {1, 1, 1, 0};
        System.out.println(threeSumClosest.threeSumClosest(arr2, -100));
    }
}

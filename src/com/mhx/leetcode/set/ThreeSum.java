package com.mhx.leetcode.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15
 * @author MHX
 * @date 2018/3/18
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for (int target = 0; target <= nums.length - 3; ++target) {
            // skip the same target element, target == 0 needs to be processed first.
            if (target > 0 && nums[target] == nums[target - 1]) {
                continue;
            }
            int low = target + 1;
            int high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] == -nums[target]) {
                    // skip the same high element
                    while (high - 1 > low && nums[high] == nums[high - 1]) {
                        --high;
                    }
                    // skip the same low element
                    while (low + 1 < high && nums[low] == nums[low + 1]) {
                        ++low;
                    }
                    List<Integer> result = Arrays.asList(nums[low], nums[high], nums[target]);
                    results.add(result);
                    ++low;
                    --high;
                } else if (nums[low] + nums[high] < -nums[target]) {
                    ++low;
                } else {
                    --high;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] arr1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum.threeSum(arr1));
    }
}

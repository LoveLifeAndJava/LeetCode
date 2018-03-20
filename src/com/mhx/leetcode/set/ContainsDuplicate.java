package com.mhx.leetcode.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 217
 *
 * @author MHX
 * @date 2018/3/20
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        for (int num : nums) {
            if (!distinct.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

package com.mhx.leetcode.set;

import java.util.*;

/**
 * 350
 * @author MHX
 * @date 2018/3/17
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.get(num) == null ? 1 : map1.get(num) + 1);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums2) {
            map2.put(num, map2.get(num) == null ? 1 : map2.get(num) + 1);
        }

        List<Integer> results = new ArrayList<>();
        map1.forEach((num, times) -> {
            if (map2.containsKey(num)) {
                for (int i = 0; i < Math.min(map1.get(num), map2.get(num)); ++i) {
                    results.add(num);
                }
            }
        });

        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersectSimple(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.get(num) == null ? 1 : map1.get(num) + 1);
        }

        List<Integer> results = new ArrayList<>();
        for (int num : nums2) {
            if (map1.containsKey(num) && map1.get(num) > 0) {
                results.add(num);
                map1.put(num, map1.get(num) - 1);
            }
        }

        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2};
        System.out.println(Arrays.toString(intersectionOfTwoArraysII.intersectSimple(nums1, nums2)));
    }
}

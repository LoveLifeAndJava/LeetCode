package com.mhx.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438
 * Use two pointers (slide window) to save the problem
 * @author MHX
 * @date 2018/3/17
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexes = new ArrayList<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < p.length(); ++i) {
            targetMap.put(p.charAt(i), targetMap.containsKey(p.charAt(i)) ? targetMap.get(p.charAt(i)) + 1 : 1);
        }
        Map<Character, Integer> saveMap = new HashMap<>(targetMap);

        int low = 0;
        int high = -1;
        int count = 0;
        while (low < s.length()) {
            if (high + 1 < s.length() && targetMap.containsKey(s.charAt(high + 1))) {
                if (targetMap.get(s.charAt(high + 1)) > 0) {
                    targetMap.put(s.charAt(high + 1), targetMap.get(s.charAt(++high)) - 1);
                    ++count;
                } else {
                    targetMap.put(s.charAt(low), targetMap.get(s.charAt(low++)) + 1);
                    --count;
                }
            } else {
                // reinitialize low, high, count and targetMap
                ++high;
                low = high + 1;
                count = 0;
                targetMap = new HashMap<>(saveMap);
            }

            if (count == p.length()) {
                indexes.add(low);
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
        System.out.println(findAllAnagramsInAString.findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAllAnagramsInAString.findAnagrams("abab", "ab"));
    }
}

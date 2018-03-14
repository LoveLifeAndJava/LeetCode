package com.mhx.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author MHX
 * @date 2018/3/15
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> distinct = new HashSet<>();
        int low = 0;
        int high = -1;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        // chars[low...high]
        while (low < s.length()) {
            if (high + 1 < s.length() && !distinct.contains(chars[high + 1])) {
                distinct.add(chars[++high]);
            } else {
                maxLength = Math.max(maxLength, distinct.size());
                distinct.remove(chars[low++]);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(lswrc.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lswrc.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lswrc.lengthOfLongestSubstring("pwwkew"));
    }
}

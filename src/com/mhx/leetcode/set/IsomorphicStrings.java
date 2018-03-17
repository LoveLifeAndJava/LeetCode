package com.mhx.leetcode.set;

import java.util.HashMap;
import java.util.Map;

/**
 * 205
 * @author MHX
 * @date 2018/3/17
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();
        for (Integer i = 0; i < s.length(); ++i) {
            if (map1.put(char1[i], i) != map2.put(char2[i], i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("egg", "add"));
        System.out.println(isomorphicStrings.isIsomorphic("foo", "bar"));
        System.out.println(isomorphicStrings.isIsomorphic("paper", "title"));
        System.out.println(isomorphicStrings.isIsomorphic("", ""));
    }
}

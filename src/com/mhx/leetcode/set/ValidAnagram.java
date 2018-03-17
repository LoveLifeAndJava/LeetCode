package com.mhx.leetcode.set;

import java.util.HashMap;
import java.util.Map;

/**
 * 242
 * @author MHX
 * @date 2018/3/17
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : s.toCharArray()) {
            map1.put(c, map1.get(c) == null ? 1 : map1.get(c) + 1);
        }
        for (char c : t.toCharArray()) {
            if (map1.containsKey(c) && map1.get(c) > 0) {
                map1.put(c, map1.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
        System.out.println(validAnagram.isAnagram("rat", "car"));
    }
}

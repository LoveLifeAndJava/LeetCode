package com.mhx.leetcode.string;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author MHX
 * @date 2017/12/24
 */
public class FirstUniqueCharacterInAString {
    /**
     * My Version
     *
     * @param s the given string
     * @return the index of the first non-repeating character
     */
    public int firstUniqChar(String s) {
        if ("".equals(s)) {
            return -1;
        }
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        String[] sList = s.split("");
        if (sList.length == 1) {
            return 0;
        }
        for (String str : sList) {
            map.put(str, map.get(str) == null ? 1 : map.get(str) + 1);
        }
        String uniqChar = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                uniqChar = entry.getKey();
                break;
            }
        }
        if (uniqChar == null) {
            return -1;
        }
        for (int i = 0; i < sList.length; i++) {
            if (uniqChar.equals(sList[i])) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Simple Version
     *
     * @param s the given string
     * @return the index of the first non-repeating character
     */
    public int firstUniqCharSimple(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                map.remove(s.charAt(i));
            } else {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }
}

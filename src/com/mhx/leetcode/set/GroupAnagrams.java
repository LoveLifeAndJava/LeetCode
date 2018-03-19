package com.mhx.leetcode.set;

import java.util.*;

/**
 * 49
 * @author MHX
 * @date 2018/3/19
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<>(Arrays.asList(str)));
            }
        }
        List<List<String>> results = new ArrayList<>();
        for (List<String> anagrams : map.values()) {
            results.add(anagrams);
        }
        // we can use 'new ArrayList<>(map.values())' to shorten the code
        return results;
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }
}

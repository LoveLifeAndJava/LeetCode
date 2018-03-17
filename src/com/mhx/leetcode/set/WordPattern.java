package com.mhx.leetcode.set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 290
 * @author MHX
 * @date 2018/3/17
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> patternMap = new HashMap<>();
        Set<String> distinct = new HashSet<>();
        char[] patterns = pattern.toCharArray();
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        for (int i = 0; i < words.length; ++i) {
            if (!patternMap.containsKey(patterns[i])) {
                patternMap.put(patterns[i], words[i]);
                if (distinct.contains(words[i])) {
                    return false;
                }
                distinct.add(words[i]);
            } else {
                if (!patternMap.get(patterns[i]).equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Two tricks here:
     * 1.keys 'a' and "a" are different, use the same map to store different types of keys.
     * (Not a good practice, we should always use maps or sets to store the same types of keys.)
     * 2.We can directly use == to compare Integer because the integers put into the map have the same addresses.
     * if we use for (int i = 0; i < n; ++i), it will not work correctly because of auto boxing to Integer.
     * (Integers with same value have different addresses.)
     *
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPatternSimple(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map index = new HashMap();
        for (Integer i = 0; i < words.length; ++i) {
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern.wordPattern("abba", "dog dog dog dog"));
        System.out.println(wordPattern.wordPattern("aaa", "aa aa aa aa"));
        System.out.println(wordPattern.wordPatternSimple("aba", "a b b"));
    }
}

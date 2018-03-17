package com.mhx.leetcode.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 14
 * @author MHX
 * @date 2018/3/4
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        int maxPrefixLength = strs[0].length();
        boolean hasCommon = false;
        int i;
        for (i = 0; i < maxPrefixLength; ++i) {
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].startsWith(strs[0].substring(0, i + 1))) {
                    hasCommon = true;
                } else {
                    if (hasCommon) {
                        return strs[0].substring(0, i);
                    } else {
                        return "";
                    }
                }
            }
        }

        return hasCommon ? strs[0].substring(0, i) : "";
    }

    public String longestCommonPrefixSimple(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"a", "ab", "abcd", "abdc", "abd"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"abb", "abc"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"a", "b"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"a"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"c", "acc", "ccc"}));
        System.out.println("========================================");
        System.out.println(longestCommonPrefix.longestCommonPrefixSimple(new String[]{"a", "ab", "abcd", "abdc", "abd"}));
        System.out.println(longestCommonPrefix.longestCommonPrefixSimple(new String[]{"abb", "abc"}));
        System.out.println(longestCommonPrefix.longestCommonPrefixSimple(new String[]{"a", "b"}));
        System.out.println(longestCommonPrefix.longestCommonPrefixSimple(new String[]{"a"}));
        System.out.println(longestCommonPrefix.longestCommonPrefixSimple(new String[]{"c", "acc", "ccc"}));

    }
}

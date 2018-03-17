package com.mhx.leetcode.string;

/**
 * 28
 * @author MHX
 * @date 2018/3/4
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println(implementStrStr.strStr("hello", "ll"));
        System.out.println(implementStrStr.strStr("aaaaa", "bba"));
    }
}

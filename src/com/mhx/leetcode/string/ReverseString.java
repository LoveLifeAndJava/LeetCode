package com.mhx.leetcode.string;

/**
 * @author MHX
 * @date 2017/12/24
 */
public class ReverseString {
    /**
     * My Version
     * @param s
     * @return
     */
    public static String reverseString(String s) {
        StringBuilder reversedString = new StringBuilder();
        String[] sList = s.split("");
        if (sList.length == 1) {
            return s;
        }
        for (int i = sList.length - 1; i >= 0; --i) {
            reversedString.append(sList[i]);
        }
        return reversedString.toString();
    }

    /**
     * Simple Version
     * @param s
     * @return
     */
    public static String reverseStringSimple(String s) {
        StringBuilder reversedString = new StringBuilder(s);
        return reversedString.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("leetcode"));
        System.out.println(reverseStringSimple("leetcode"));
    }

}

package com.mhx.leetcode.string;

/**
 * @author MHX
 * @date 2017/12/24
 */
public class ReverseString {
    /**
     * My Version
     *
     * @param s
     * @return
     */
    public String reverseString(String s) {
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
     *
     * @param s
     * @return
     */
    public String reverseStringSimple(String s) {
        StringBuilder reversedString = new StringBuilder(s);
        return reversedString.reverse().toString();
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseString("leetcode"));
        System.out.println(reverseString.reverseStringSimple("leetcode"));
    }

}

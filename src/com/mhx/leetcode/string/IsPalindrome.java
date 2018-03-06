package com.mhx.leetcode.string;

/**
 * @author MHX
 * @date 2018/3/5
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder ascendingStr = new StringBuilder();
        for (Character e : s.toCharArray()) {
            // Method 1: replaceAll("[^A-Za-z0-9]", "").toLowerCase();
            // Method 2: Character.isLetterOrDigit(e)
            if ((e >= 'a' && e <= 'z') || (e >= '0' && e <= '9')) {
                ascendingStr.append(e);
            }
        }
        return new StringBuilder(ascendingStr).reverse().toString().equals(ascendingStr.toString());
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(""));
        System.out.println(isPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome.isPalindrome("race a car"));
        System.out.println(isPalindrome.isPalindrome("0P"));
    }
}

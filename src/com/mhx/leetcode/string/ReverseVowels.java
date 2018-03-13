package com.mhx.leetcode.string;

/**
 * @author MHX
 * @date 2018/3/14
 */
public class ReverseVowels {

    /**
     * use two pointers: low and high to reverse vowels
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            while (!isVowels(Character.toLowerCase(chars[low])) && low < high) {
                ++low;
            }
            while (!isVowels(Character.toLowerCase(chars[high])) && low < high) {
                --high;
            }

            swap(chars, low, high);
            ++low;
            --high;
        }
        return String.valueOf(chars);
    }

    private boolean isVowels(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        System.out.println(reverseVowels.reverseVowels("hello"));
        System.out.println(reverseVowels.reverseVowels("leetcode"));
        System.out.println(reverseVowels.reverseVowels("aA"));
    }
}

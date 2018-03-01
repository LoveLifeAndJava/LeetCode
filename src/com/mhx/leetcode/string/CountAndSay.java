package com.mhx.leetcode.string;

/**
 * @author MHX
 * @date 2018/3/2
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String nextCountAndSayNumber = String.valueOf(1);
        for (int i = 1; i < n; i++) {
            nextCountAndSayNumber = getNextCountAndSayNumber(nextCountAndSayNumber);
        }
        return nextCountAndSayNumber;
    }

    private String getNextCountAndSayNumber(String currentNumStr) {
        Character lastElement = null;
        int count = 1;
        Character currentChar = null;
        StringBuilder next = new StringBuilder();
        for (int i = 0; i < currentNumStr.length(); i++) {
            currentChar = currentNumStr.charAt(i);
            if (lastElement != null) {
                if (!lastElement.equals(currentChar)) {
                    next.append(count)
                            .append(lastElement);
                    count = 1;
                } else {
                    ++count;
                }
            }
            lastElement = currentChar;
        }
        next.append(count)
                .append(currentChar);
        return next.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(6));
        System.out.println(countAndSay.getNextCountAndSayNumber("111221"));
    }
}

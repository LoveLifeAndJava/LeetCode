package com.mhx.leetcode.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 202
 * @author MHX
 * @date 2018/3/17
 */
public class HappyNumber {
    Set<Integer> distinct = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int result = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            result += Math.pow(c - '0', 2);
        }
        if (distinct.contains(result)) {
            return false;
        }
        distinct.add(result);
        return isHappy(result);
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(19));
    }
}

package com.mhx.leetcode.string;

import java.util.Stack;

/**
 * 20
 * @author MHX
 * @date 2018/3/4
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        // Optimize: if the length of s is odd, then return false directly
        if (chars.length % 2 != 0) {
            return false;
        }
        for (char c : chars) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                    break;
            }
        }
        // in case of condition '(('
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("([)]"));
        System.out.println(validParentheses.isValid("[()]"));
        System.out.println(validParentheses.isValid("([)"));
        System.out.println(validParentheses.isValid("(([]){})"));
        System.out.println(validParentheses.isValid("(("));
    }
}

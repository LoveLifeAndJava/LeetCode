package com.mhx.leetcode.stack;

import java.util.Stack;

/**
 * 150
 *
 * @author MHX
 * @date 2018/3/25
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int result = 0;
        for (String token : tokens) {
            if (!"+".equals(token) && !"-".equals(token) && !"*".equals(token) && !"/".equals(token)) {
                stack.push(token);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                if ("+".equals(token)) {
                    result = num1 + num2;
                } else if ("-".equals(token)) {
                    result = num1 - num2;
                } else if ("*".equals(token)) {
                    result = num1 * num2;
                } else {
                    result = num1 / num2;
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation eval = new EvaluateReversePolishNotation();
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(eval.evalRPN(tokens1));
        System.out.println(eval.evalRPN(tokens2));
    }
}

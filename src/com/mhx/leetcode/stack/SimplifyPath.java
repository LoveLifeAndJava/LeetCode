package com.mhx.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 71
 *
 * @author MHX
 * @date 2018/3/25
 */
public class SimplifyPath {

    public String simplifyPathMyVersion(String path) {
        Stack<String> stack = new Stack<>();
        for (String folder : path.split("/")) {
            if (".".equals(folder) || "".equals(folder)) {
                continue;
            }
            if ("..".equals(folder)) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(folder);
            }
        }
        Stack<String> results = new Stack<>();
        while (stack.size() > 0) {
            results.push(stack.pop());
        }
        StringBuilder result = new StringBuilder();
        while (results.size() > 0) {
            result.append("/").append(results.pop());
        }
        if ("".equals(result.toString())) {
            return "/";
        }
        return result.toString();
    }

    /**
     * Use deque to simplify the code.
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String folder : path.split("/")) {
            if ("..".equals(folder)) {
                if (stack.size() != 0) {
                    stack.pop();
                }
            } else if (!".".equals(folder) && !"".equals(folder)) {
                stack.push(folder);
            }
        }
        StringBuilder result = new StringBuilder();
        while (stack.size() > 0) {
            result.append("/").append(stack.pollLast());
        }
        return "".equals(result.toString()) ? "/" : result.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath.simplifyPath("/home/"));
        System.out.println(simplifyPath.simplifyPath("/.."));
        System.out.println(simplifyPath.simplifyPath("/"));
        System.out.println(simplifyPath.simplifyPath("/."));
        System.out.println(simplifyPath.simplifyPath("/..."));
        System.out.println(simplifyPath.simplifyPath("/abc/..."));
        System.out.println(simplifyPath.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
    }
}

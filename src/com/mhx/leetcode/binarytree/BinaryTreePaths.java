package com.mhx.leetcode.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 257
 *
 * @author MHX
 * @date 2018/3/27
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        if (root.left == null && root.right == null) {
            return Arrays.asList(String.valueOf(root.val));
        }
        List<String> leftPaths = binaryTreePaths(root.left).stream().map(path -> root.val + "->" + path).collect(Collectors.toList());
        List<String> rightPaths = binaryTreePaths(root.right).stream().map(path -> root.val + "->" + path).collect(Collectors.toList());
        leftPaths.addAll(rightPaths);
        return leftPaths;
    }
}

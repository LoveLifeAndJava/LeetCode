package com.mhx.leetcode.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 129
 *
 * @author MHX
 * @date 2018/3/27
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        List<String> allPaths = sumNumbersHelper(root);
        for (String path : allPaths) {
            sum += Integer.parseInt(path);
        }
        return sum;
    }

    public List<String> sumNumbersHelper(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            return Arrays.asList(String.valueOf(root.val));
        }
        List<String> leftPaths = sumNumbersHelper(root.left).stream().map(path -> root.val + path).collect(Collectors.toList());
        List<String> rightPaths = sumNumbersHelper(root.right).stream().map(path -> root.val + path).collect(Collectors.toList());
        leftPaths.addAll(rightPaths);
        return leftPaths;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        System.out.println(sumRootToLeafNumbers.sumNumbers(treeNode));
    }
}

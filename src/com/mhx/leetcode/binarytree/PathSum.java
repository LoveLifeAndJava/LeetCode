package com.mhx.leetcode.binarytree;

/**
 * 112
 *
 * @author MHX
 * @date 2018/3/27
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

package com.mhx.leetcode.binarytree;

/**
 * 226
 *
 * @author MHX
 * @date 2018/3/26
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {

    }
}

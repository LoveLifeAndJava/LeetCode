package com.mhx.leetcode.binarytree;

/**
 * 111
 *
 * @author MHX
 * @date 2018/3/26
 */
public class MinimunDepthOfBinaryTree {
    public int minDepthMyVersion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = minDepthMyVersion(root.left);
        int rightDepth = minDepthMyVersion(root.right);
        if (leftDepth == 0) {
            return rightDepth + 1;
        }
        if (rightDepth == 0) {
            return leftDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (leftDepth == 0 || rightDepth == 0) {
            return leftDepth + rightDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        System.out.println(new MinimunDepthOfBinaryTree().minDepth(treeNode));
    }
}

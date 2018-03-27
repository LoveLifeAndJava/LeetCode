package com.mhx.leetcode.binarytree;

/**
 * 222
 *
 * @author MHX
 * @date 2018/3/26
 */
public class CountCompleteTreeNodes {
    /**
     * time limit exceeded
     *
     * @param root
     * @return
     */
    public int countNodesMyVersion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countNodesMyVersion(root.left) + countNodesMyVersion(root.right) + 1;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if (leftDepth == rightDepth) {
            // Time exceeded when using Math.pow(2, n)
            return (1 << leftDepth) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private int leftDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            ++depth;
            node = node.left;
        }
        return depth;
    }

    private int rightDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            ++depth;
            node = node.right;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        System.out.println(new CountCompleteTreeNodes().countNodes(treeNode));
    }
}

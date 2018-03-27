package com.mhx.leetcode.binarytree;

/**
 * 235
 *
 * @author MHX
 * @date 2018/3/27
 */
public class LowestCommonAncestorOfABinarySearchTree {
    /**
     * The problem indicates p and q exist in the TreeNode
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        System.out.println(new LowestCommonAncestorOfABinarySearchTree().lowestCommonAncestor(treeNode, treeNode, treeNode.left));
    }
}

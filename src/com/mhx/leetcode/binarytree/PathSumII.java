package com.mhx.leetcode.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 113
 *
 * @author MHX
 * @date 2018/3/27
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        if (sum == root.val && root.left == null && root.right == null) {
            LinkedList<Integer> result = new LinkedList<>();
            result.add(root.val);
            results.add(result);
            return results;
        }
        LinkedList<List<Integer>> leftNodes = pathSum(root.left, sum - root.val).stream().map(list -> {
            list.add(0, root.val);
            return list;
        }).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<List<Integer>> rightNodes = pathSum(root.right, sum - root.val).stream().map(list -> {
            list.add(0, root.val);
            return list;
        }).collect(Collectors.toCollection(LinkedList::new));
        leftNodes.addAll(rightNodes);
        return leftNodes;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.left.left.left = new TreeNode(7);

        treeNode.right = new TreeNode(8);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.left = new TreeNode(5);
        treeNode.right.right.right = new TreeNode(1);

        PathSumII pathSumII = new PathSumII();
        System.out.println(pathSumII.pathSum(treeNode, 22));
    }

}

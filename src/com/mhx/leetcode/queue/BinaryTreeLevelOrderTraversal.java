package com.mhx.leetcode.queue;

import com.mhx.leetcode.binarytree.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102
 *
 * @author MHX
 * @date 2018/3/25
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> subResults = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode poll = queue.poll();
                subResults.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            results.add(subResults);
        }
        return results;
    }

    /**
     * Using pairs to solve the problem
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderUsingPairs(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        // Pair<TreeNode, the level of the TreeNode>
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> poll = queue.poll();
            TreeNode node = poll.getKey();
            int level = poll.getValue();

            // if the level hasn't been added, add the level
            if (level == results.size()) {
                results.add(new LinkedList<>());
            }
            results.get(level).add(node.val);

            if (node.left != null) {
                queue.add(new Pair<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, level + 1));
            }
        }
        return results;
    }

    public static void main(String[] args) {

    }
}

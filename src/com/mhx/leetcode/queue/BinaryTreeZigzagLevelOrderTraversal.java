package com.mhx.leetcode.queue;

import com.mhx.leetcode.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103
 *
 * @author MHX
 * @date 2018/3/25
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> subResults = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode poll = queue.poll();
                if (level % 2 == 0) {
                    subResults.add(poll.val);
                } else {
                    subResults.addFirst(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            results.add(subResults);
            ++level;
        }

        return results;
    }

    public static void main(String[] args) {

    }
}

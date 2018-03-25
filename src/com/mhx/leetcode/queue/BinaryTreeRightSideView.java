package com.mhx.leetcode.queue;

import com.mhx.leetcode.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199
 *
 * @author MHX
 * @date 2018/3/25
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return results;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelElementsNum = queue.size();
            for (int i = 0; i < levelElementsNum; ++i) {
                TreeNode poll = queue.poll();
                // from right
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                // to left
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                // get the rightmost node of each level
                if (i == 0) {
                    results.add(poll.val);
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {

    }
}

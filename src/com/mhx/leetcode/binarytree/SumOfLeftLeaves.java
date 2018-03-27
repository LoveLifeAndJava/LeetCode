package com.mhx.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404
 *
 * @author MHX
 * @date 2018/3/27
 */
public class SumOfLeftLeaves {
    /**
     * recursive way
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesHelper(root, null);
    }

    public int sumOfLeftLeavesHelper(TreeNode root, String type) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && "left".equals(type)) {
            return root.val;
        }
        return sumOfLeftLeavesHelper(root.left, "left") + sumOfLeftLeavesHelper(root.right, "right");
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeavesBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null && poll.left.left == null && poll.left.right == null) {
                sum += poll.left.val;
            }
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return sum;
    }
}

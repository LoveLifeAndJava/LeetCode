package com.mhx.leetcode.binarytree;

/**
 * 437
 *
 * @author MHX
 * @date 2018/3/27
 */
public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        result += findPaths(root, sum);
        result += pathSum(root.left, sum);
        result += pathSum(root.right, sum);
        return result;
    }


    private int findPaths(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.val == sum) {
            result += 1;
        }
        result += findPaths(root.left, sum - root.val) + findPaths(root.right, sum - root.val);
        return result;
    }

}

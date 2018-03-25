package com.mhx.leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145
 *
 * @author MHX
 * @date 2018/3/25
 */
public class BinaryTreePostorderTraversal {
    /**
     * Using recursion
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalRecursion(TreeNode root) {
        List<Integer> orders = new LinkedList<>();
        if (root != null) {
            orders.addAll(postorderTraversalRecursion(root.left));
            orders.addAll(postorderTraversalRecursion(root.right));
            orders.add(root.val);
        }
        return orders;
    }

    /**
     * Using stack to simulate recursion
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> orders = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                orders.addFirst(pop.val);
                stack.push(pop.left);
                stack.push(pop.right);
            }
        }
        return orders;
    }

    /**
     * Using stack to simulate the system's stack recursive call
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalSimulateSystemStack(TreeNode root) {
        LinkedList<Integer> orders = new LinkedList<>();
        Deque<Command> stack = new LinkedList<>();
        stack.push(new Command(root, Command.Operation.HANDLE));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.treeNode != null) {
                if (command.operation.equals(Command.Operation.HANDLE)) {
                    stack.push(new Command(command.treeNode, Command.Operation.PRINT));
                    stack.push(new Command(command.treeNode.right, Command.Operation.HANDLE));
                    stack.push(new Command(command.treeNode.left, Command.Operation.HANDLE));
                } else {
                    orders.add(command.treeNode.val);
                }
            }
        }
        return orders;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(new BinaryTreePostorderTraversal().postorderTraversalRecursion(treeNode));

        TreeNode treeNode2 = new TreeNode(3);
        treeNode2.right = new TreeNode(1);
        treeNode2.right.left = new TreeNode(2);
        System.out.println(new BinaryTreePostorderTraversal().postorderTraversalSimulateSystemStack(treeNode2));
    }
}

package com.mhx.leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static com.mhx.leetcode.binarytree.Command.Operation;

/**
 * 144
 *
 * @author MHX
 * @date 2018/3/25
 */
public class BinaryTreePreorderTraversal {
    /**
     * Using recursion
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalRecursion(TreeNode root) {
        List<Integer> orders = new LinkedList<>();
        if (root != null) {
            orders.add(root.val);
            orders.addAll(preorderTraversalRecursion(root.left));
            orders.addAll(preorderTraversalRecursion(root.right));
        }
        return orders;
    }

    /**
     * Using stack to simulate recursion
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> orders = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                orders.add(pop.val);
                stack.push(pop.right);
                stack.push(pop.left);
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
    public List<Integer> preorderTraversalSimulateSystemStack(TreeNode root) {
        List<Integer> orders = new LinkedList<>();
        Deque<Command> stack = new LinkedList<>();
        stack.push(new Command(root, Operation.HANDLE));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.treeNode != null) {
                if (command.operation.equals(Operation.HANDLE)) {
                    stack.push(new Command(command.treeNode.right, Operation.HANDLE));
                    stack.push(new Command(command.treeNode.left, Operation.HANDLE));
                    stack.push(new Command(command.treeNode, Operation.PRINT));
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
        System.out.println(new BinaryTreePreorderTraversal().preorderTraversalSimulateSystemStack(treeNode));
    }
}

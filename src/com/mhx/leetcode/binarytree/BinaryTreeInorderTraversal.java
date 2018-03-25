package com.mhx.leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94
 *
 * @author MHX
 * @date 2018/3/25
 */
public class BinaryTreeInorderTraversal {
    /**
     * Using recursion
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> orders = new LinkedList<>();
        if (root != null) {
            orders.addAll(inorderTraversalRecursion(root.left));
            orders.add(root.val);
            orders.addAll(inorderTraversalRecursion(root.right));
        }
        return orders;
    }

    /**
     * Using stack to simulate recursion
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> orders = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            orders.add(cur.val);
            cur = cur.right;
        }
        return orders;
    }

    /**
     * Using stack to simulate the system's stack recursive call
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalSimulateSystemStack(TreeNode root) {
        LinkedList<Integer> orders = new LinkedList<>();
        Deque<Command> stack = new LinkedList<>();
        stack.push(new Command(root, Command.Operation.HANDLE));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.treeNode != null) {
                if (command.operation.equals(Command.Operation.HANDLE)) {
                    stack.push(new Command(command.treeNode.right, Command.Operation.HANDLE));
                    stack.push(new Command(command.treeNode, Command.Operation.PRINT));
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
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(treeNode));
    }
}

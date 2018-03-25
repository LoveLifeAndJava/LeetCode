package com.mhx.leetcode.binarytree;

/**
 * @author MHX
 * @date 2018/3/25
 */
public class Command {

    TreeNode treeNode;
    Operation operation;

    public Command(TreeNode treeNode, Operation operation) {
        this.treeNode = treeNode;
        this.operation = operation;
    }

    enum Operation {
        /**
         * 处理节点
         */
        HANDLE,

        /**
         * 打印节点
         */
        PRINT;
    }
}

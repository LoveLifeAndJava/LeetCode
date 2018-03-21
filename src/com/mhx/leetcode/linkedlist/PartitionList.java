package com.mhx.leetcode.linkedlist;

/**
 * 86
 *
 * @author MHX
 * @date 2018/3/21
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode tempLeft = left;
        ListNode tempRight = right;

        while (head != null) {
            if (head.val < x) {
                tempLeft.next = head;
                tempLeft = head;
            } else {
                tempRight.next = head;
                tempRight = head;
            }
            head = head.next;
        }
        tempLeft.next = right.next;
        tempRight.next = null;

        return left.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        PartitionList partitionList = new PartitionList();
        ListNode partitionedList = partitionList.partition(head, 3);
        System.out.println(partitionedList.printList());
    }
}

package com.mhx.leetcode.linkedlist;

/**
 * 143
 *
 * @author MHX
 * @date 2018/3/23
 */
public class ReorderList {
    /**
     * find the mid element first, and then reverse the right half
     * then do the iteration: select node from left and right one by one
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        int i;
        ListNode cur = head;
        for (i = 0; cur != null; ++i) {
            cur = cur.next;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode left = head;
        ListNode right = reverseList(slow.next);

        while (left != slow) {
            ListNode leftNext = left.next;
            ListNode rightNext = right.next;
            left.next = right;
            right.next = leftNext;
            left = leftNext;
            right = rightNext;
        }
        // only odd-node list needs to set the next node of mid to null
        if (i % 2 != 0) {
            slow.next = null;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(head);

        System.out.println(head.printList());
    }
}

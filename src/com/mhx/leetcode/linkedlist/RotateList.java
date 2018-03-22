package com.mhx.leetcode.linkedlist;

/**
 * 61
 *
 * @author MHX
 * @date 2018/3/22
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        int i = 0;
        for (; fast.next != null; ++i) {
            fast = fast.next;
        }
        for (int j = 0; j < i - k % i; ++j) {
            slow = slow.next;
        }

        /* will fail!
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = dummyHead.next;
        return newHead;*/

        fast.next = dummyHead.next;
        dummyHead.next = slow.next;
        slow.next = null;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(new RotateList().rotateRight(head, 0) == head);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println(new RotateList().rotateRight(head2, 2) == head2);
    }
}

package com.mhx.leetcode.linkedlist;

/**
 * 24
 *
 * @author MHX
 * @date 2018/3/22
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode post = node2.next;
            p.next = node2;
            node2.next = node1;
            node1.next = post;
            p = node1;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        System.out.println(swapNodesInPairs.swapPairs(head).printList());
    }
}

package com.mhx.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 82
 * Different from 83
 *
 * @author MHX
 * @date 2018/3/22
 */
public class RemoveDuplicatesFromSortedListII {

    /**
     * delete all duplicates nodes
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead.next;
        Set<Integer> elements = new HashSet<>();
        Set<Integer> removeElements = new HashSet<>();
        while (cur != null) {
            if (!elements.add(cur.val)) {
                removeElements.add(cur.val);
            }
            cur = cur.next;
        }
        cur = dummyHead;
        while (cur.next != null) {
            if (removeElements.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        RemoveDuplicatesFromSortedListII rdfslII = new RemoveDuplicatesFromSortedListII();
        ListNode listNode = rdfslII.deleteDuplicates(head);
        System.out.println(listNode.printList());

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(3);

        ListNode listNode2 = rdfslII.deleteDuplicates(head2);
        System.out.println(listNode2.printList());
    }
}

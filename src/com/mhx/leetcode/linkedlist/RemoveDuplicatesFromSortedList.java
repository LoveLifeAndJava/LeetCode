package com.mhx.leetcode.linkedlist;

/**
 * 83
 *
 * @author MHX
 * @date 2018/3/21
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * make sure value will only appear once, not delete all the duplicate nodes
     * this is easier than 82
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode saveHead = head;
        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return saveHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        RemoveDuplicatesFromSortedList rdfsl = new RemoveDuplicatesFromSortedList();
        ListNode distinctHead = rdfsl.deleteDuplicates(head);
        System.out.println(distinctHead.printList());
    }
}

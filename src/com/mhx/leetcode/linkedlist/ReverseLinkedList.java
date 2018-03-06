package com.mhx.leetcode.linkedlist;

/**
 * @author MHX
 * @date 2018/3/6
 */
public class ReverseLinkedList {

    /**
     * Use 3 pointers: pre, p, post to reverse the LinkedList
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode post;
        pre.next = null;
        while (p != null) {
            post = p.next;
            p.next = pre;
            pre = p;
            p = post;
        }
        return pre;
    }

    /**
     * Using the head-inserting method to create a new reversed LinkedList
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            ListNode temp = p.next;
            p.next = head;
            head = p;
            p = temp;
        }
        return head;
    }

    /**
     * Reverse the LinkedList recursively
     * @return
     */
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode headOfSubList = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return headOfSubList;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        System.out.println(head.printList());
        ListNode reversedListNode = reverseLinkedList.reverseList1(head);
        System.out.println(reversedListNode.printList());
        System.out.println(reverseLinkedList.reverseList2(reversedListNode).printList());
    }
}

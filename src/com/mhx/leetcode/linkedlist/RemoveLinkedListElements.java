package com.mhx.leetcode.linkedlist;

/**
 * 203
 *
 * @author MHX
 * @date 2018/3/22
 */
public class RemoveLinkedListElements {

    /**
     * Insert valid node into dummyHead
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (head != null) {
            if (head.val != val) {
                cur.next = head;
                cur = head;
            }
            head = head.next;
        }
        cur.next = null; // important!
        return dummyHead.next;
    }

    /**
     * Delete the node in the list directly
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsNormal(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
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
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
        ListNode listNode = removeLinkedListElements.removeElementsNormal(head, 6);
        System.out.println(listNode.printList());
    }
}

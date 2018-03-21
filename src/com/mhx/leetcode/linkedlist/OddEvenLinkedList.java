package com.mhx.leetcode.linkedlist;

/**
 * 328
 *
 * @author MHX
 * @date 2018/3/21
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode tempOddHead = oddHead;
        ListNode tempEvenHead = evenHead;
        int i = 1;
        while (head != null) {
            if (i % 2 == 0) {
                tempEvenHead.next = head;
                tempEvenHead = head;
            } else {
                tempOddHead.next = head;
                tempOddHead = head;
            }
            head = head.next;
            ++i;
        }
        tempEvenHead.next = null;
        tempOddHead.next = evenHead.next;
        return oddHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        OddEvenLinkedList oell = new OddEvenLinkedList();
        ListNode listNode = oell.oddEvenList(head);
        System.out.println(listNode.printList());
    }
}

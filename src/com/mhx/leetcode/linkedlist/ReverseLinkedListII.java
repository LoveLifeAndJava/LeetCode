package com.mhx.leetcode.linkedlist;

/**
 * @author MHX
 * @date 2018/3/21
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 1;
        ListNode cur = head;
        ListNode first = null;
        ListNode beforeFirst = null;
        ListNode afterLast = null;
        while (cur != null) {
            if (i == m) {
                first = cur;
            } else if (i + 1 == m) {
                beforeFirst = cur;
            } else if (i - 1 == n) {
                afterLast = cur;
            }
            cur = cur.next;
            ++i;
        }
        ListNode headOfReversedSubList = reverseList(first, afterLast);
        if (first != null) {
            first.next = afterLast;
        }
        if (beforeFirst != null) {
            beforeFirst.next = headOfReversedSubList;
        } else {
            // in case of the head is changed
            return headOfReversedSubList;
        }
        return head;
    }

    private ListNode reverseList(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != tail) {
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
        head.next.next.next.next = new ListNode(5);
        System.out.println(head.printList());

        ListNode reversedList = new ReverseLinkedListII().reverseBetween(head, 2, 4);
        System.out.println(reversedList.printList());

        System.out.println("===================================");

        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(5);
        System.out.println(head2.printList());

        ListNode reversedList2 = new ReverseLinkedListII().reverseBetween(head2, 1, 2);
        System.out.println(reversedList2.printList());
    }
}

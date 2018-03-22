package com.mhx.leetcode.linkedlist;

/**
 * 19
 *
 * @author MHX
 * @date 2018/3/22
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEndMyVersion(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        int length = 0;
        while (cur.next != null) {
            ++length;
            cur = cur.next;
        }
        cur = dummyHead;
        for (int i = 0; i <= length; ++i) {
            if (i + 1 == length - n + 1) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * Use two pointers p, q: the distance between p and q is n
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = p;
        for (int i = -1; i < n; i++) {
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RemoveNthNodeFromEndOfList rnnfeol = new RemoveNthNodeFromEndOfList();
        System.out.println(rnnfeol.removeNthFromEnd(head, 2).printList());

        ListNode head2 = new ListNode(1);
        System.out.println(rnnfeol.removeNthFromEnd(head2, 1) == null);
    }
}

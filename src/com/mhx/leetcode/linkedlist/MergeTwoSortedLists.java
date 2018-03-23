package com.mhx.leetcode.linkedlist;

/**
 * 21
 *
 * @author MHX
 * @date 2018/3/22
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        while (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }

        while (l2 != null) {
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }

        /**
         * while loop above can be optimized!
             if (l1 != null) {
                cur.next = l1;
             }
             if (l2 != null) {
                cur.next = l2;
             }
         */

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode mergedList = mergeTwoSortedLists.mergeTwoLists(l1, l2);

        System.out.println(mergedList.printList());
    }
}

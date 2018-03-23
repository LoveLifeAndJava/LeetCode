package com.mhx.leetcode.linkedlist;

/**
 * 234
 *
 * @author MHX
 * @date 2018/3/24
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = reverseList(slow.next);
        while (right != null) {
            if (right.val == head.val) {
                right = right.next;
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
    }

    public static void main(String[] args) {

    }
}

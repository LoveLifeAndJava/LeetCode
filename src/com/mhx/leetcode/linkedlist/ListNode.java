package com.mhx.leetcode.linkedlist;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public String printList() {
        ListNode next = this.next;
        String result = val + " -> ";
        while (next != null) {
            result += next.val + " -> ";
            next = next.next;
        }
        return result;
    }
}
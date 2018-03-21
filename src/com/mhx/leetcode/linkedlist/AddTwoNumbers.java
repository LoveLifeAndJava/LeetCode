package com.mhx.leetcode.linkedlist;

/**
 * 2
 *
 * @author MHX
 * @date 2018/3/21
 */
public class AddTwoNumbers {
    /**
     * When the number is very large, it will be exceeded.
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersFirstVersion(ListNode l1, ListNode l2) {
        ListNode tempL1 = l1;
        ListNode tempL2 = l2;
        StringBuilder num1Str = new StringBuilder();
        while (tempL1 != null) {
            num1Str.append(tempL1.val);
            tempL1 = tempL1.next;
        }
        StringBuilder num2Str = new StringBuilder();
        while (tempL2 != null) {
            num2Str.append(tempL2.val);
            tempL2 = tempL2.next;
        }
        StringBuilder sum = new StringBuilder(String.valueOf(Integer.parseInt(num1Str.reverse().toString()) + Integer.parseInt(num2Str.reverse().toString())));
        ListNode newHead = new ListNode(0);
        ListNode tempHead = newHead;
        for (char c : sum.reverse().toString().toCharArray()) {
            tempHead.next = new ListNode(c - '0');
            tempHead = tempHead.next;
        }
        return newHead.next;
    }

    /**
     * Just add two numbers from left to right, it's actually very easy.
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return head.next;
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
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(listNode.printList());
    }
}

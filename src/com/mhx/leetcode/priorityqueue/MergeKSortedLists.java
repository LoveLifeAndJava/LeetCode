package com.mhx.leetcode.priorityqueue;

import com.mhx.leetcode.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23
 *
 * @author MHX
 * @date 2018/3/26
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode node : lists) {
            while (node != null) {
                priorityQueue.offer(node);
                node = node.next;
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (!priorityQueue.isEmpty()) {
            ListNode curNode = priorityQueue.poll();
            cur.next = curNode;
            cur = cur.next;
            if (priorityQueue.isEmpty()) {
                cur.next = null;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}

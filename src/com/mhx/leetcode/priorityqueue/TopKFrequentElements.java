package com.mhx.leetcode.priorityqueue;

import java.util.*;

/**
 * 347
 *
 * @author MHX
 * @date 2018/3/26
 */
public class TopKFrequentElements {
    /**
     * min heap stores integer
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequentMyVersion(int[] nums, int k) {
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        for (int num : nums) {
            elementCountMap.put(num, elementCountMap.getOrDefault(num, 0) + 1);
        }
        // min heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(Comparator.comparingInt(elementCountMap::get));
        for (int num : nums) {
            if (!priorityQueue.contains(num)) {
                if (priorityQueue.size() == k) {
                    Integer peek = priorityQueue.peek();
                    if (elementCountMap.get(peek) < elementCountMap.get(num)) {
                        priorityQueue.poll();
                        priorityQueue.offer(num);
                    }
                } else {
                    priorityQueue.offer(num);
                }
            }
        }
        LinkedList<Integer> results = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            results.add(priorityQueue.poll());
        }
        return results;
    }

    /**
     * min heap stores Map.Entry directly
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        for (int num : nums) {
            elementCountMap.put(num, elementCountMap.getOrDefault(num, 0) + 1);
        }
        // min heap
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
            if (priorityQueue.size() == k) {
                Map.Entry<Integer, Integer> peek = priorityQueue.peek();
                if (peek.getValue() < entry.getValue()) {
                    priorityQueue.poll();
                    priorityQueue.offer(entry);
                }
            } else {
                priorityQueue.offer(entry);
            }
        }
        LinkedList<Integer> results = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            results.add(priorityQueue.poll().getKey());
        }
        return results;
    }

}

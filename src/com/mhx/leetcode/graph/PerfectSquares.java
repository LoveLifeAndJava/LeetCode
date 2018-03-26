package com.mhx.leetcode.graph;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 279
 *
 * @author MHX
 * @date 2018/3/25
 */
public class PerfectSquares {
    public int numSquares(int n) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(n, 0));
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> poll = queue.poll();
            int num = poll.getKey();
            int step = poll.getValue();

            if (num == 0) {
                return step;
            }

            for (int i = 1; num - i * i >= 0; ++i) {
                if (!visited[num - i * i]) {
                    queue.offer(new Pair<>(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }
        }
        throw new IllegalStateException("Impossible to reach here.");
    }

    public static void main(String[] args) {

    }
}

package com.mhx.leetcode.graph;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 127
 *
 * @author MHX
 * @date 2018/3/26
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Boolean> visitedMap = new HashMap<>();
        for (String word : wordList) {
            visitedMap.put(word, false);
        }
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));
        wordList.remove(beginWord);
        while (!queue.isEmpty()) {
            Pair<String, Integer> poll = queue.poll();
            String word = poll.getKey();
            int step = poll.getValue();

            if (endWord.equals(word)) {
                return step;
            }

            for (String w : getNeighbors(word, wordList)) {
                if (!visitedMap.get(w)) {
                    queue.offer(new Pair<>(w, step + 1));
                    visitedMap.put(w, true);
                    wordList.remove(w);
                }
            }
        }
        return 0;
    }

    private List<String> getNeighbors(String word, List<String> wordList) {
        return wordList.stream().filter(w -> isNeighbor(w, word)).collect(Collectors.toList());
    }

    private boolean isNeighbor(String word1, String word2) {
        int count = 0;
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        for (int i = 0; i < chars1.length; ++i) {
            if (chars1[i] != chars2[i]) {
                ++count;
            }
        }
        return count == 1;
    }
}

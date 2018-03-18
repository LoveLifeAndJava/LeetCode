package com.mhx.leetcode.set;

import java.util.HashMap;
import java.util.Map;

/**
 * 454
 * @author MHX
 * @date 2018/3/19
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> cdSumCountMap = new HashMap<>();
        for (int i = 0; i < C.length; ++i) {
            for (int j = 0; j < D.length; ++j) {
                int sum = C[i] + D[j];
                cdSumCountMap.put(sum, cdSumCountMap.containsKey(sum) ? cdSumCountMap.get(sum) + 1 : 1);
            }
        }
        int count = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < B.length; ++j) {
                if (cdSumCountMap.containsKey(-A[i] - B[j])) {
                    count += cdSumCountMap.get(-A[i] - B[j]);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        FourSumII fourSumII = new FourSumII();
        System.out.println(fourSumII.fourSumCount(A, B, C, D));
    }
}

package com.mhx.leetcode.set;

import java.util.HashMap;
import java.util.Map;

/**
 * 447
 *
 * @author MHX
 * @date 2018/3/19
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<Integer, Integer> distanceNumMap = new HashMap<>();
            for (int j = 0; j < points.length; ++j) {
                if (i != j) {
                    int dis = distance(points[i], points[j]);
                    distanceNumMap.put(dis, distanceNumMap.containsKey(dis) ? distanceNumMap.get(dis) + 1 : 1);
                }
            }
            result += distanceNumMap.values().stream().mapToInt(count -> count * (count - 1)).sum();
        }
        return result;
    }

    private int distance(int[] i, int[] j) {
        return (int) Math.pow((i[0] - j[0]), 2) + (int) Math.pow((i[1] - j[1]), 2);
    }

    public static void main(String[] args) {
        NumberOfBoomerangs numberOfBoomerangs = new NumberOfBoomerangs();
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs.numberOfBoomerangs(points));
    }
}

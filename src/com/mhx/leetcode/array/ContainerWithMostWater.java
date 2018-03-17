package com.mhx.leetcode.array;

/**
 * 11
 * @author MHX
 * @date 2018/3/14
 */
public class ContainerWithMostWater {

    /**
     * use two pointers to find the max area
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int maxArea = 0;
        while (low < high) {
            maxArea = Math.max(maxArea, Math.min(height[low], height[high]) * (high - low));
            if (height[low] < height[high]) {
                ++low;
            } else if (height[low] > height[high]) {
                --high;
            } else {
                if (low + 1 < high) {
                    ++low;
                } else {
                    return maxArea;
                }
            }
        }
        return maxArea;
    }

    public int maxAreaSimple(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int maxArea = 0;
        while (low < high) {
            maxArea = Math.max(maxArea, Math.min(height[low], height[high]) * (high - low));
            if (height[low] < height[high]) {
                ++low;
            } else {
                --high;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

        int[] heights = {1, 3, 2, 5, 25, 24, 5};
        // 24
        System.out.println(containerWithMostWater.maxArea(heights));
        System.out.println(containerWithMostWater.maxAreaSimple(heights));
    }
}

package com.git.wuqf;

import java.util.Arrays;
import java.util.Comparator;

public class Solution452 {

    public static void main(String[] args) {
//        int[][] x = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] x = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
//        int[][] x = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        Solution452 s = new Solution452();
        int minArrowShots = s.findMinArrowShots(x);
        System.out.println(minArrowShots);
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        Long minEnd = Long.MAX_VALUE;
        int arrow = 1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > minEnd) {
                minEnd = Long.MAX_VALUE;
                arrow++;
            }
            minEnd = points[i][1] < minEnd ? points[i][1] : minEnd;
        }
        return arrow;
    }
}

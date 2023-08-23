package com.git.wuqf;

import java.util.*;

class Solution253 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}, {-1, 20}};
        //int[][] intervals = new int[][]{{7, 10}, {2, 4}};

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            pq.offer(intervals[i][1]);
            while (pq.peek() < intervals[i][0]) {
                pq.poll();
            }
            max = max > pq.size() ? max : pq.size();
        }
        System.out.println(max);
    }
}

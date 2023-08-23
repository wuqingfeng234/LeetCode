package com.git.wuqf;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1046 {
    public static void main(String[] args) {
        //int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        int[] stones = new int[]{7, 6, 7, 6, 9};

        Solution1046 solution1046 = new Solution1046();
        int i = solution1046.lastStoneWeight(stones);
        System.out.println(i);
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a != b) {
                pq.offer(a - b);
            }
        }
        if (pq.size() > 0) {
            return pq.poll();
        }
        return 0;
    }
}

package com.git.wuqf;

import java.util.PriorityQueue;

public class SolutionLCR059 {

    int k = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public SolutionLCR059(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}

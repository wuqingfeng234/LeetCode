package com.git.wuqf;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution1464 {

    public static void main(String[] args) {
        int[] nums = {3, 7};
        Solution1464 s = new Solution1464();
        int i = s.maxProduct(nums);
        System.out.println(i);
    }

    PriorityQueue<Integer> pq;
    public int maxProduct(int[] nums) {
        pq = new PriorityQueue<>();
        Arrays.stream(nums).forEach(num -> add(num));
        return (pq.poll() - 1) * (pq.poll() - 1);
    }


    private void add(int num) {
        pq.add(num);
        if (pq.size() > 2) {
            pq.poll();
        }
    }
}

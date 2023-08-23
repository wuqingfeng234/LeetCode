package com.git.wuqf;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution2099 {

    public static void main(String[] args) {
        int[] x = {3, 4, 3, 3, 4};
        int p = 3;
        Solution2099 s = new Solution2099();
        int[] ints = s.maxSubsequence(x, p);
        Arrays.stream(ints).forEach(System.out::println);
    }

    PriorityQueue<int[]> pq;

    public int[] maxSubsequence(int[] nums, int k) {
        pq = new PriorityQueue<>(Comparator.comparingInt(value -> value[1]));
        for (int i = 0; i < nums.length; i++) {
            add(new int[]{i, nums[i]}, k);
        }
        int[][] mt = new int[k][2];
        for (int i = 0; i < k; i++) {
            mt[i] = pq.poll();
        }
        Arrays.sort(mt, Comparator.comparingInt(o -> o[0]));
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = mt[i][1];
        }
        return ans;
    }

    private void add(int[] num, int k) {
        pq.offer(num);
        if (pq.size() > k) {
            pq.poll();
        }
    }


}

package com.git.wuqf;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution1337 {

    public static void main(String[] args) {
        int[][] x = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        Solution1337 s = new Solution1337();
        int[] ints = s.kWeakestRows(x, 3);
        Arrays.stream(ints).forEach(System.out::println);
    }

    PriorityQueue<int[][]> pq;

    public int[] kWeakestRows(int[][] mat, int k) {
        pq = new PriorityQueue<>(Comparator.comparingInt((int[][] a) -> -Arrays.stream(a[0]).sum()).thenComparingInt(a -> -a[1][0]));
        for (int i = 0; i < mat.length; i++) {
            add(mat[i], i, k);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[k - i - 1] = pq.poll()[1][0];
        }
        return ans;
    }

    private void add(int[] m, int index, int k) {
        int[][] e = new int[][]{m, new int[]{index}};
        pq.add(e);
        if (pq.size() > k) {
            pq.poll();
        }
    }
}

package com.git.wuqf.unionfind;

import java.util.LinkedList;
import java.util.List;

public class Solution305 {

    public static void main(String[] args) {
        int m = 3, n = 3;
        int[][] x = {{0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2}, {0, 0}, {1, 1}};
        Solution305 solution305 = new Solution305();
        List<Integer> integers = solution305.numIslands2(m, n, x);
        System.out.println("x");
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new LinkedList<>();
        UnionFind unionFind = new UnionFind(m, n);
        for (int[] position : positions) {
            ans.add(unionFind.connect(position[0], position[1]));
        }
        return ans;
    }

    class UnionFind {
        int[] parent;
        int[] size;
        final int row;
        final int col;
        int sets;

        public UnionFind(int row, int col) {
            this.row = row;
            this.col = col;
            parent = new int[row * col];
            size = new int[row * col];
            sets = 0;
        }

        public Integer connect(int r, int c) {
            int index = index(r, c);
            if (size[index] == 0) {
                parent[index] = index;
                size[index] = 1;
                sets++;
                union(r - 1, c, r, c);
                union(r + 1, c, r, c);
                union(r, c - 1, r, c);
                union(r, c + 1, r, c);
            }
            return sets;
        }

        private void union(int r1, int c1, int r2, int c2) {
            if (r1 < 0 || r1 >= row || r2 < 0 || r2 >= row || c1 < 0 || c1 >= col || c2 < 0 || c2 >= col) {
                return;
            }
            int i1 = index(r1, c1);
            int i2 = index(r2, c2);
            if (size[i1] == 0 || size[i2] == 0) {
                return;
            }
            int f1 = find(i1);
            int f2 = find(i2);
            if (f1 != f2) {
                if (size[f1] >= size[f2]) {
                    size[f1] += size[f2];
                    parent[f2] = f1;
                } else {
                    size[f2] += size[f1];
                    parent[f1] = f2;
                }
                sets--;
            }
        }

        private int find(int i) {
            int[] help = new int[row * col];
            int hi = 0;
            while (i != parent[i]) {
                help[hi++] = i;
                i = parent[i];
            }
            for (int j = hi - 1; j >= 0; j--) {
                parent[help[hi]] = i;
            }
            return i;
        }

        private int index(int r, int c) {
            return r * col + c;
        }
    }
}

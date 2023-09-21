package com.git.wuqf.unionfind;

public class Solution547 {
    public static void main(String[] args) {
        int[][] x={{1,1,0},{1,1,0},{0,0,1}};
        Solution547 solution547=new Solution547();
        int circleNum = solution547.findCircleNum(x);
        System.out.println(circleNum);
    }
    public int findCircleNum(int[][] isConnected) {
        UnionFind unionFind = new UnionFind(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.sets;
    }

    class UnionFind {
        int[] parent;
        int[] size;
        int sets;
        int length;

        public UnionFind(int length) {
            this.length = length;
            parent = new int[length];
            size = new int[length];
            for (int i = 0; i < length; i++) {
                parent[i] = i;
                size[i] = 1;
                sets = length;
            }
        }

        public int findHead(int i) {
            int[] help = new int[length];
            int hi = 0;
            while (i != parent[i]) {
                i = parent[i];
                help[hi++] = i;
            }
            for (int j = hi - 1; j >= 0; j--) {
                parent[help[j]] = i;
            }
            return i;
        }

        public void union(int i, int j) {
            int ih = findHead(i);
            int jh = findHead(j);
            if (ih != jh) {
                if (size[ih] >= size[jh]) {
                    parent[jh] = ih;
                    size[ih] += size[jh];
                } else {
                    parent[ih] = jh;
                    size[jh] += size[ih];
                }
                sets--;
            }
        }
    }
}

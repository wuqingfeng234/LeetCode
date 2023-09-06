package com.git.wuqf;

import java.util.ArrayList;
import java.util.List;

public class Solution705 {

    public static void main(String[] args) {
        Solution705 solution705 = new Solution705();
        solution705.add(1);
        solution705.add(2);
        boolean contains = solution705.contains(1);
        solution705.remove(2);
        System.out.println(contains);
    }

    int[] keys;

    public Solution705() {
        keys = new int[40000];
    }

    public void add(int key) {
        int bucket = key / 32;
        int p = key % 32;
        keys[bucket] = keys[bucket] | (1 << p);
    }

    public void remove(int key) {
        int bucket = key / 32;
        int p = key % 32;
        keys[bucket] = keys[bucket] & ~(1 << p);
    }

    public boolean contains(int key) {
        int bucket = key / 32;
        int p = key % 32;
        int v = (keys[bucket] >> p) & 1;
        return v == 1;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
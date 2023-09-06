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


    boolean[] keys;

    public Solution705() {
        keys = new boolean[1000001];
    }

    public void add(int key) {
        keys[key] = true;
    }

    public void remove(int key) {
        keys[key] = false;
    }

    public boolean contains(int key) {
        return keys[key];
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
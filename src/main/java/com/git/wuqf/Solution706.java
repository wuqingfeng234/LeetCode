package com.git.wuqf;

public class Solution706 {
    public static void main(String[] args) {

    }

    Integer[] map;

    public Solution706() {
        map = new Integer[1000001];
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        if (map[key] != null) {
            return map[key];
        }
        return -1;
    }

    public void remove(int key) {
        map[key] = null;
    }
}

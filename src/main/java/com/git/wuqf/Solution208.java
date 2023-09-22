package com.git.wuqf;


//["Trie","insert","search","search","startsWith","insert","search"]
//[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
public class Solution208 {

    public static void main(String[] args) {
        Solution208 solution208 = new Solution208();
        solution208.insert("apple");
        boolean apple = solution208.search("apple");
        boolean app = solution208.search("app");
        boolean app1 = solution208.startsWith("app");
        solution208.insert("app");
        boolean app2 = solution208.search("app");
        System.out.println("x");
    }

    private Node root;

    public Solution208() {
        root = new Node();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        char[] chs = word.toCharArray();
        Node node = root;
        node.pass++;
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new Node();
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node cur = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (cur.nexts[index] == null || cur.nexts[index].pass <= 0) {
                return false;
            }
            cur = cur.nexts[index];
        }
        if (cur == null || cur.end <= 0) {
            return false;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node cur = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (cur.nexts[index] == null || cur.nexts[index].pass <= 0) {
                return false;
            }
            cur = cur.nexts[index];
        }
        return true;
    }

    class Node {
        int pass;
        int end;
        Node[] nexts;

        Node() {
            pass = 0;
            end = 0;
            nexts = new Node[26];
        }
    }
}

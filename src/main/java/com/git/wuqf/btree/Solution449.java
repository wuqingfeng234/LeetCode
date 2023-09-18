package com.git.wuqf.btree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution449 {

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        t2.left = t1;
        t2.right = t3;
        Solution449 solution449 = new Solution449();
        String serialize = solution449.serialize(t2);
        TreeNode deserialize = solution449.deserialize(serialize);
        System.out.println("x");
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<Integer> list = new LinkedList<>();
        preserialize(root, list);
        return queue2String(list);

    }

    private void preserialize(TreeNode root, Queue<Integer> list) {
        if (root == null) {
            list.add(null);
        } else {
            list.add(root.val);
            preserialize(root.left, list);
            preserialize(root.right, list);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        Queue<Integer> queue = string2Quque(data);
        return predesialize(queue);
    }

    private TreeNode predesialize(Queue<Integer> source) {
        Integer poll = source.poll();
        if (poll == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(poll);
        treeNode.left = predesialize(source);
        treeNode.right = predesialize(source);
        return treeNode;
    }


    private String queue2String(Queue<Integer> queue) {
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll != null) {
                sb.append(poll.intValue());
            }
            sb.append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private Queue<Integer> string2Quque(String s) {
        Queue<Integer> queue = new LinkedList<>();
        String[] split = s.split(",");
        for (int i = 0; i < split.length; i++) {
            String v = split[i];
            if (v.isEmpty()) {
                queue.add(null);
            } else {
                queue.add(Integer.valueOf(v));
            }
        }
        return queue;
    }
}

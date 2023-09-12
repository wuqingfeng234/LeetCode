package com.git.wuqf.btree;

import java.util.LinkedList;
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
        if (root == null) {
            return null;
        }
        Queue<TreeNode> help = new LinkedList<>();
        Queue<Integer> ans = new LinkedList<>();
        help.add(root);
        ans.add(root.val);
        while (!help.isEmpty()) {
            TreeNode poll = help.poll();
            TreeNode left = poll.left;
            if (left != null) {
                help.add(left);
                ans.add(left.val);
            } else {
                ans.add(null);
            }
            TreeNode right = poll.right;
            if (right != null) {
                help.add(right);
                ans.add(right.val);
            } else {
                ans.add(null);
            }
        }
        return queue2String(ans);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return new TreeNode();
        }
        Queue<Integer> queue = string2Quque(data);
        Integer value = queue.poll();
        if (value == null) {
            return null;
        }
        Queue<TreeNode> help = new LinkedList<>();
        TreeNode head = new TreeNode(value);
        help.add(head);
        while (!help.isEmpty()) {
            TreeNode poll = help.poll();
            Integer leftValue = queue.poll();
            if (leftValue != null) {
                poll.left = new TreeNode(leftValue);
                help.add(poll.left);
            }
            Integer rightValue = queue.poll();
            if (rightValue != null) {
                poll.right = new TreeNode(rightValue);
                help.add(poll.right);
            }
        }
        return head;
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

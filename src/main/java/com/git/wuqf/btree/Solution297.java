package com.git.wuqf.btree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution297 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = null;
        t1.right = t2;
        t2.left = t3;
        Solution297 solution297 = new Solution297();
        Queue serialize = solution297.serialize(t1);
        System.out.println("x");
    }

    // Encodes a tree to a single string.
    public Queue serialize(TreeNode root) {
        Queue<Integer> ans = new LinkedList<>();
        levels(root, ans);
        return ans;
    }

    private void levels(TreeNode root, Queue<Integer> ans) {
        if (root != null) {
            Queue<TreeNode> help = new LinkedList<>();
            help.add(root);
            ans.add(root.val);
            while (!help.isEmpty()) {
                TreeNode poll = help.poll();
                if (poll.left != null) {
                    help.add(poll.left);
                    ans.add(poll.left.val);
                } else {
                    ans.add(null);
                }
                if (poll.right != null) {
                    help.add(poll.right);
                    ans.add(poll.right.val);
                } else {
                    ans.add(null);
                }
            }
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return null;
        }
        return leveld(queue);
    }

    private TreeNode leveld(Queue<Integer> levelList) {
        Integer poll = levelList.poll();
        TreeNode head = generateNode(poll.intValue());
        if (head == null) {
            return null;
        }
        Queue<TreeNode> help = new LinkedList<>();
        help.add(head);
        while (!help.isEmpty()) {
            TreeNode treeNode = help.poll();
            Integer left = levelList.poll();
            if (left != null) {
                treeNode.left = generateNode(left);
                help.add(treeNode.left);
            }
            Integer right = levelList.poll();
            if (right != null) {
                treeNode.right = generateNode(right);
                help.add(treeNode.right);
            }
        }
        return head;
    }

    private TreeNode generateNode(Integer val) {
        if (val == null) {
            return null;
        } else {
            return new TreeNode(val);
        }
    }


}

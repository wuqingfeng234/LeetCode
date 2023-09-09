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
        pres(root, ans);
        return ans;
    }

    private void pres(TreeNode cur, Queue<Integer> queue) {
        if (cur == null) {
            queue.add(null);
        } else {
            queue.add(cur.val);
            pres(cur.left, queue);
            pres(cur.right, queue);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return null;
        }
        return pred(queue);
    }

    private TreeNode pred(Queue<Integer> queue) {
        Integer poll = queue.poll();
        if (poll == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(poll.intValue());
        treeNode.left = pred(queue);
        treeNode.right = pred(queue);
        return treeNode;
    }

}

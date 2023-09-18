package com.git.wuqf.btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> help = new LinkedList<>();
        boolean order = true;
        help.add(root);
        while (!help.isEmpty()) {
            int size = help.size();
            LinkedList<Integer> a = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = help.poll();
                if (order) {
                    a.add(poll.val);
                } else {
                    a.addFirst(poll.val);
                }
                TreeNode left = poll.left;
                if (left != null) {
                    help.add(left);
                }
                TreeNode right = poll.right;
                if (right != null) {
                    help.add(right);
                }
            }
            order = !order;
            ans.add(a);
        }
        return ans;
    }
}

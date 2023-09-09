package com.git.wuqf.btree;

import java.util.*;

public class Solution104 {


    public List<List<Integer>> levelOrder(TreeNode head) {
        List<List<Integer>> ans = new ArrayList<>();
        if (head == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                level.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}

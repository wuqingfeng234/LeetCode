package com.git.wuqf.btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionO32 {

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);

        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);

        t3.left=t9;
        t3.right=t20;
        t20.left=t15;
        t20.right=t7;
        SolutionO32 solutionO32=new SolutionO32();
        List<List<Integer>> lists = solutionO32.levelOrder(t3);
        System.out.println("x");
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> help = new LinkedList<>();
        help.add(root);
        boolean order = true;
        while (!help.isEmpty()) {
            int size = help.size();
            LinkedList<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = help.poll();
                if (order) {
                    levelList.add(poll.val);
                } else {
                    levelList.addFirst(poll.val);
                }

                if (poll.left != null) {
                    help.add(poll.left);
                }
                if (poll.right != null) {
                    help.add(poll.right);
                }
            }
            order = !order;
            ans.add(levelList);
        }
        return ans;
    }
}

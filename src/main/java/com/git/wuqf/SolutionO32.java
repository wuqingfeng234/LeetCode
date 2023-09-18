//package com.git.wuqf.btree;
//
//import com.git.wuqf.btree.TreeNode;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class SolutionO32 {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> ans = new LinkedList<>();
//        if (root == null) {
//            return ans;
//        }
//        Queue<TreeNode> help = new LinkedList<TreeNode>();
//        help.add(root);
//        boolean order = true;
//        while (!help.isEmpty()) {
//            int size = help.size();
//            LinkedList<Integer> levelList = new LinkedList<>();
//            for (int i = 0; i < size; i++) {
//                TreeNode poll = help.poll();
//                if (order) {
//                    levelList.add(poll);
//                } else {
//                    levelList.addFirst(poll.val);
//                }
//
//                if (poll.left != null) {
//                    help.add(poll.left);
//                }
//                if (poll.right != null) {
//                    help.add(poll.left);
//                }
//            }
//            order = !order;
//            ans.add(levelList);
//        }
//        return ans;
//    }
//}

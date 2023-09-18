//package com.git.wuqf.btree;
//
//import java.util.*;
//
//public class Solution662 {
//    public static void main(String[] args) {
//        TreeNode t0= new TreeNode(0);
//
//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t5 = new TreeNode(5);
//
//        TreeNode t10 = new TreeNode(10);
//        TreeNode t11 = new TreeNode(11);
//
//        t0.left=t1;
//        t0.right=t2;
//
//        t1.right=t4;
//        t2.left=t5;
//
//        t4.right=t10;
//        t5.left=t11;
//
//        Solution662 solution662=new Solution662();
//        int i = solution662.widthOfBinaryTree(t0);
//        System.out.println(i);
//    }
//    public int widthOfBinaryTree(TreeNode root) {
//        int ans = 1;
//
//        Queue<Map<TreeNode, Integer>> help = new ArrayList<>();
//        LinkedList<Integer> x=new ArrayList<>();
//        help.add(Map.of(root, 0));
//        while (!help.isEmpty()) {
//            int size = help.size();
//            int minIdx = Integer.MAX_VALUE;
//            int maxIdx = 1;
//            for (int i = 0; i < size; i++) {
//                Map<TreeNode, Integer> poll = help.poll();
//                TreeNode treeNode = getKey(poll);
//                Integer index = getValue(poll);
//
//                TreeNode left = treeNode.left;
//                if (left != null) {
//                    int leftIdx = index * 2 + 1;
//                    help.add(Map.of(left, leftIdx));
//                    minIdx = Math.min(leftIdx, minIdx);
//                    maxIdx = Math.max(leftIdx, maxIdx);
//                }
//                TreeNode right = treeNode.right;
//                if (right != null) {
//                    int rightIdx = index * 2 + 2;
//                    help.add(Map.of(right, index * 2 + 2));
//                    minIdx = Math.min(rightIdx, minIdx);
//                    maxIdx = Math.max(rightIdx, maxIdx);
//                }
//            }
//            ans = ans > (maxIdx - minIdx + 1) ? ans : (maxIdx - minIdx + 1);
//        }
//        return ans;
//    }
//
//    private TreeNode getKey(Map<TreeNode, Integer> element) {
//        for (TreeNode treeNode : element.keySet()) {
//            return treeNode;
//        }
//        return null;
//    }
//
//    private Integer getValue(Map<TreeNode, Integer> element) {
//        for (Integer value : element.values()) {
//            return value;
//        }
//        return null;
//    }
//}

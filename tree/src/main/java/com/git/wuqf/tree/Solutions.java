package com.git.wuqf.tree;

public class Solutions {
    public static void main(String[] args) {
        TreeNode tn3 = new TreeNode(3, null);
        TreeNode tn9 = new TreeNode(9, tn3);
        TreeNode tn20 = new TreeNode(20, tn3);
        TreeNode tn15 = new TreeNode(15, tn20);
        TreeNode tn7 = new TreeNode(7, tn20);

        tn3.left = tn9;
        tn3.right = tn20;
        tn20.left = tn15;
        tn20.right = tn7;

        int sum = sumOfLeftLeaves(tn3);
        System.out.println(sum);
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        root.sumLeft(root);
        return root.sum;
    }
}


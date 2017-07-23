package com.git.wuqf.tree;


public class Solutions {
    public static void main(String[] args) {
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn9 = new TreeNode(9);
        TreeNode tn20 = new TreeNode(20);
        TreeNode tn15 = new TreeNode(15);
        TreeNode tn7 = new TreeNode(7);

        tn3.left = tn9;
        tn3.right = tn20;
        tn20.left = tn15;
        tn20.right = tn7;

        int sum = sumOfLeftLeaves(tn3);
        System.out.println(sum);
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        return sumLeft(root, 0);

    }

    public static boolean hasChildred(TreeNode node) {
        if (node.left != null || node.right != null) {
            return true;
        }
        return false;
    }

    public static boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node.left != null || node.right != null) {
            return false;
        }
        return true;
    }

    public static boolean willContinue(TreeNode node) {
        if (node != null) {
            if (node.left != null && hasChildred(node.left)) {
                return true;
            }
            if (node.right != null && hasChildred(node.right)) {
                return true;
            }
        }
        return false;
    }

    static int sumLeft(TreeNode node, int sum) {
        if (willContinue(node)) {
            sum += sumLeft(node.left, sum) + sumLeft(node.right, sum);

        }
        if (node!=null&&node.left != null && isLeaf(node.left)) {
            sum += node.left.val;
        }
        return sum;
    }

}


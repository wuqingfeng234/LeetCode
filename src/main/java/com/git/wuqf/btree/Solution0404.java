package com.git.wuqf.btree;

public class Solution0404 {
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

        Solution0404 solution0404=new Solution0404();
        boolean balanced = solution0404.isBalanced(t3);
        System.out.println(balanced);
    }
    public boolean isBalanced(TreeNode root) {
        return process(root).balance;
    }

    Info process(TreeNode treeNode) {
        if (treeNode == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(treeNode.left);
        Info rightInfo = process(treeNode.right);
        int height = Math.max(leftInfo.hight, rightInfo.hight) + 1;
        boolean balance = leftInfo.balance && rightInfo.balance && (Math.abs(leftInfo.hight - rightInfo.hight) <= 1);
        return new Info(balance, height);
    }

    class Info {
        boolean balance;
        int hight;

        public Info(boolean balance, int hight) {
            this.balance = balance;
            this.hight = hight;
        }
    }
}

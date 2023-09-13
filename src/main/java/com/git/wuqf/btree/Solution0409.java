package com.git.wuqf.btree;

public class Solution0409 {
    public static void main(String[] args) {
        //3,5,1,6,2,0,8,null,null,7,4
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t0 = new TreeNode(0);
        TreeNode t8 = new TreeNode(8);
        TreeNode t7 = new TreeNode(7);
        TreeNode t4 = new TreeNode(4);
        t3.left = t5;
        t3.right = t1;
        t5.left = t6;
        t5.right = t2;
        t1.left = t0;
        t1.right = t8;
        t2.left = t7;
        t2.right = t4;
        Solution0409 solution0409 = new Solution0409();
        Info process = solution0409.process(t3, t5, t4);
        System.out.println("x");
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return process(root, p, q).ancestor;
    }

    private class Info {
        boolean findA;
        boolean findB;
        TreeNode ancestor;

        public Info(boolean findA, boolean findB, TreeNode ancestor) {
            this.findA = findA;
            this.findB = findB;
            this.ancestor = ancestor;

        }
    }

    private Info process(TreeNode cur, TreeNode a, TreeNode b) {
        if (cur == null) {
            return new Info(false, false, null);
        }
        Info leftInfo = process(cur.left, a, b);
        Info rightInfo = process(cur.right, a, b);
        boolean findA = (cur.val == a.val) || leftInfo.findA || rightInfo.findA;
        boolean findB = (cur.val == b.val) || leftInfo.findB || rightInfo.findB;
        TreeNode ancestor = null;
        if (leftInfo.ancestor != null) {
            ancestor = leftInfo.ancestor;
        } else if (rightInfo.ancestor != null) {
            ancestor = rightInfo.ancestor;
        } else if (findA && findB) {
            ancestor = cur;
        }
        return new Info(findA, findB, ancestor);
    }
}

package com.git.wuqf.btree;


public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return process(root).bst;
    }

    class Info {
        int max;
        int min;
        boolean bst;

        public Info(int max, int min, boolean bst) {
            this.max = max;
            this.min = min;
            this.bst = bst;
        }
    }

    private Info process(TreeNode cur) {
        if (cur == null) {
            return null;
        }
        Info leftInfo = process(cur.left);
        Info rightInfo = process(cur.right);
        int max = cur.val;
        int min = cur.val;
        boolean bst = true;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
            bst = bst && leftInfo.bst && (cur.val > leftInfo.max);
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
            bst = bst && rightInfo.bst && (cur.val < rightInfo.min);
        }
        return new Info(max, min, bst);
    }
}

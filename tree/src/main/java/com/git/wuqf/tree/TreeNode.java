package com.git.wuqf.tree;

import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    int sum = 0;


    TreeNode(int x,TreeNode parent) {
        val = x;
        this.parent=parent;
    }

    public boolean isLeaf() {

        if (this.left != null || this.right != null) {
            return false;
        }
        return true;
    }

    public boolean isLeftLeaf() {
        if (!this.isLeaf()) {
            return false;
        }
        if (this.parent.left == this) {
            return true;
        }
        return false;
    }

    void sumLeft(TreeNode node) {
        if (!node.isLeaf()) {
            sumLeft(node.left);
            sumLeft(node.right);
        } else if(node.isLeftLeaf()){
            sum = node.val + sum;
        }
    }

}

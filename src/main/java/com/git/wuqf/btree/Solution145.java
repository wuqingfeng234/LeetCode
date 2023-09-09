package com.git.wuqf.btree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> help = new Stack();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            help.push(pop);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        while (!help.isEmpty()) {
            ans.add(help.pop().val);
        }
        return ans;
    }
}

package com.git.wuqf.btree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution144 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            ans.add(pop.val);
            if (pop.right != null) {
                stack.add(pop.right);
            }
            if (pop.left != null) {
                stack.add(pop.left);
            }
        }
        return ans;
    }
}

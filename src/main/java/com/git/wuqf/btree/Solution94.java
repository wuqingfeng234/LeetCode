package com.git.wuqf.btree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = null;
        t1.right = t2;
        t2.left = t3;
        Solution94 solution94 = new Solution94();
        List<Integer> integers = solution94.inorderTraversal(t3);
        System.out.println("x");
    }


    public List<Integer> inorderTraversal(TreeNode cur) {
        List<Integer> ans = new ArrayList<>();
        if (cur != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    ans.add(cur.val);
                    cur=cur.right;
                }
            }
        }
        return ans;
    }
}

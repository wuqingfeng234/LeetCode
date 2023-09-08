package com.git.wuqf.btree;

import java.util.ArrayList;
import java.util.List;

public class Solution94 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = null;
        t1.right = t2;
        t2.left = t3;
        Solution94 solution94=new Solution94();
        List<Integer> integers = solution94.inorderTraversal(t3);
        System.out.println("x");
    }

    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return ans;
        }
        inorderTraversal(root.left);
        ans.add(root.val);
        inorderTraversal(root.right);
        return ans;
    }
}

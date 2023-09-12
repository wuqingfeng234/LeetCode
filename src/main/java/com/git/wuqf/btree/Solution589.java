package com.git.wuqf.btree;

import java.util.ArrayList;
import java.util.List;

public class Solution589 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        if (root.children == null) {
            return ans;
        }
        for (int i = 0; i < root.children.size(); i++) {
            preorder(root.children.get(i));
        }
        return ans;
    }
}

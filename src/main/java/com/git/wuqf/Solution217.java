package com.git.wuqf;

import java.util.*;

class Solution217 {
    public static void main(String[] args) {
        Solution217 solution217 = new Solution217();
        int[] x = {1, 2, 3, 1};
        boolean b = solution217.containsDuplicate(x);
        System.out.println(b);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);

        }
        return false;
    }
}

package com.git.wuqf;

import java.util.HashMap;

public class Solution219 {
    public static void main(String[] args) {
        Solution219 s = new Solution219();
        int[] x = {1, 2, 3, 1};
        boolean b = s.containsNearbyDuplicate(x, 2);
        System.out.println(b);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - k > 0) {
                map.remove(nums[i - k - 1]);
            }
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}

package com.git.wuqf;

import java.util.TreeSet;

public class Solution220 {
    public static void main(String[] args) {
        Solution220 solution220 = new Solution220();
        int[] x = {1, 2, 5, 1, 45};
        int indexDiff = 3;
        int valueDiff = 0;
        boolean b = solution220.containsNearbyAlmostDuplicate(x, indexDiff, valueDiff);
        System.out.println(b);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.isEmpty()) {
                Integer ceiling = set.ceiling(nums[i] - valueDiff);
                if ((ceiling != null) && (ceiling <= nums[i] + valueDiff)) {
                    return true;
                }
            }
            set.add(nums[i]);
            if (i >= indexDiff) {
                set.remove(nums[i - indexDiff]);
            }
        }
        return false;
    }
}

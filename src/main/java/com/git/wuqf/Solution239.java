package com.git.wuqf;

public class Solution239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Solution239 s=new Solution239();
        int[] ints = s.maxSlidingWindow(nums, k);
        System.out.println(ints);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = left + k-1;
        int[] ms = new int[nums.length - k + 1];
        for (int i = 0; right < nums.length; left++, right++, i++) {
            ms[i] = findMax(nums, left, right);
        }
        return ms;
    }

    private int findMax(int[] nums, int left, int right) {
        int max = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}

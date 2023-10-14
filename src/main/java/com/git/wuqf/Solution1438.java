package com.git.wuqf;

import java.util.LinkedList;

public class Solution1438 {
    public static void main(String[] args) {
        int[] x = {4, 2, 2, 2, 4, 4, 2, 2};
        int limit = 0;
        Solution1438 s = new Solution1438();
        int i = s.longestSubarray(x, limit);
        System.out.println(i);
    }

    public int longestSubarray(int[] nums, int limit) {
        int maxLength = 0;
        LinkedList<Integer> maxDeque = new LinkedList<>();
        LinkedList<Integer> minDeque = new LinkedList<>();
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            addMaxDeque(nums, right, maxDeque);
            addMinDeque(nums, right, minDeque);
            while (nums[maxDeque.peek()] - nums[right] > limit) {
                left = maxDeque.poll() + 1;
            }
            while (nums[right] - nums[minDeque.peek()] > limit) {
                left = minDeque.poll() + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    private void addMaxDeque(int[] nums, int index, LinkedList<Integer> maxDeque) {
        while (!maxDeque.isEmpty() && maxDeque.peekLast() != null && nums[maxDeque.peekLast()] <= nums[index]) {
            maxDeque.pollLast();
        }
        maxDeque.offer(index);
    }

    private void addMinDeque(int[] nums, int index, LinkedList<Integer> minDeque) {
        while (!minDeque.isEmpty() && minDeque.peekLast() != null && nums[minDeque.peekLast()] >= nums[index]) {
            minDeque.pollLast();
        }
        minDeque.offer(index);
    }
}
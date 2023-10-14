package com.git.wuqf;

import java.util.Deque;
import java.util.LinkedList;

public class Solution239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Solution239 s = new Solution239();
        int[] ints = s.maxSlidingWindow(nums, k);
        System.out.println(ints);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] max = new int[nums.length - k + 1];
        Deque<Integer> window = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            addWindow(window, nums, i, k);
        }

        for (int i = 0; i < nums.length - k + 1; i++) {
            addWindow(window, nums, i + k - 1, k);
            max[i] = nums[window.peek()];
        }
        return max;
    }

    private void addWindow(Deque<Integer> window, int[] nums, int index, int limit) {
        while (!window.isEmpty() && nums[window.peekLast()] <= nums[index]) {
            window.pollLast();
        }
        window.offer(index);
        while ((index - window.peek() + 1) > limit) {
            window.poll();
        }
    }
}

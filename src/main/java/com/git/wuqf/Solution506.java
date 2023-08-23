package com.git.wuqf;

import java.util.Arrays;
import java.util.Comparator;

public class Solution506 {
    public static void main(String[] args) {
        int[] score = {10, 3, 8, 9, 4};
        Solution506 s = new Solution506();
        String[] relativeRanks = s.findRelativeRanks(score);
        Arrays.stream(relativeRanks).forEach(System.out::println);
    }

    public String[] findRelativeRanks(int[] score) {
        String[] modalArr = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int length = score.length;
        int[][] arr = new int[length][2];
        for (int i = 0; i < length; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> -o[0]));
        String[] ans = new String[length];
        for (int i = 0; i < length; i++) {
            if (i < 3) {
                ans[arr[i][1]] = modalArr[i];
            } else {
                ans[arr[i][1]] = String.valueOf(i + 1);
            }
        }
        return ans;
    }
}

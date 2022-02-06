package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest228.q1;


import java.util.Arrays;

class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);

        int fromIndex = 0;
        int toIndex = nums.length;
        int index;
        while ((index = Arrays.binarySearch(nums, fromIndex, toIndex, original)) >= fromIndex) {
            fromIndex = index + 1;
            original = original << 1;
        }
        return original;
    }
}
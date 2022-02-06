package ir.home.tutorial.algorithm.leetcode.contest.biweekly.biweeklycontest71.p1;

import java.util.Arrays;

class Solution {
    public int minimumSum(int num) {
        final int[] nums = new int[4];
        nums[0] = num / 1000;
        num = (num % 1000);
        nums[1] = num / 100;
        num = (num % 100);
        nums[2] = num / 10;
        nums[3] = (num % 10);
        Arrays.sort(nums);

        return (nums[0] * 10 + nums[2]) + (nums[1] * 10 + nums[3]);

    }
}
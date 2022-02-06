package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest279.p1;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] sortEvenOdd(int[] nums) {
        final Integer[] odds = new Integer[(int) Math.floor(nums.length / 2d)];
        final Integer[] evens = new Integer[(int) Math.ceil(nums.length / 2d)];

        if (nums.length <= 2)
            return nums;

        int i;
        for (i = 0; i < nums.length / 2; i++) {
            evens[i] = nums[2 * i];
            odds[i] = nums[2 * i + 1];
        }

        if (nums.length % 2 == 1)
            evens[i] = nums[nums.length - 1];

        Arrays.sort(odds, Comparator.reverseOrder());
        Arrays.sort(evens, Comparator.naturalOrder());

        for (i = 0; i < nums.length / 2; i++) {
            nums[2 * i] = evens[i];
            nums[2 * i + 1] = odds[i];
        }

        if (nums.length % 2 == 1)
            nums[2 * i] = evens[evens.length - 1];

        return nums;
    }
}
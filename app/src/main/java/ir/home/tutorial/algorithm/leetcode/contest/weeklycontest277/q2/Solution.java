package ir.home.tutorial.algorithm.leetcode.contest.weeklycontest277.q2;

import java.util.LinkedList;

public class Solution {
    public int[] rearrangeArray(int[] nums) {
        final var positives = new LinkedList<Integer>();
        final var negatives = new LinkedList<Integer>();
        for (int num : nums)
            if (num < 0)
                negatives.add(num);
            else
                positives.add(num);
        for (int i = 0; i < (nums.length / 2); i++) {
            nums[2 * i] = positives.remove();
            nums[2 * i + 1] = negatives.remove();
        }
        return nums;
    }
}

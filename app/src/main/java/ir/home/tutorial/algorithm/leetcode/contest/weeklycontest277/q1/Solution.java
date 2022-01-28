package ir.home.tutorial.algorithm.leetcode.contest.weeklycontest277.q1;

public class Solution {
    public int countElements(int[] nums) {
        if (nums == null || nums.length <= 2)
            return 0;
        int min = nums[0];
        int max = nums[0];
        short maxRepetitionCount = 0;
        short minRepetitionCount = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minRepetitionCount = 0;
            } else if (nums[i] > max) {
                max = nums[i];
                maxRepetitionCount = 0;
            } else {
                if (min == nums[i]) minRepetitionCount++;
                else if (max == nums[i]) maxRepetitionCount++;
            }
        }

        int arrayBoundaries = min == max ? 1 : 2;
        return nums.length - arrayBoundaries - minRepetitionCount - maxRepetitionCount;
    }
}

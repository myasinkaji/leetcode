package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest228.q2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        final List<Integer> highestScores = new ArrayList<>();
        int lastSum = 0;
        int leftSum = 0;
        int rightSum = 0;


        for (int num : nums)
            if (num == 1)
                rightSum++;

        lastSum = rightSum;
        highestScores.add(0);

        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                leftSum++;
            } else {
                rightSum--;
            }

            t = leftSum + rightSum;
            if (t > lastSum) {
                lastSum = t;
                highestScores.clear();
                highestScores.add(i + 1);
            } else if (t == lastSum)
                highestScores.add(i + 1);
        }
        return highestScores;
    }
}
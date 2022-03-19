package ir.home.tutorial.algorithm.leetcode.contest.biweekly.biweeklycontest74.p1;

class Solution {
    public boolean divideArray(int[] nums) {
        final var map = new int[501];
        int remain = 0;
        for (int i : nums) {
            if (map[i] == 1) {
                map[i]= 0;
                remain--;
            } else {
                map[i]++;
                remain++;
            }
        }
        return remain == 0;
    }
}
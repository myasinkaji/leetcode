package ir.home.tutorial.algorithm.leetcode.contest.biweekly.biweeklycontest74.p1;

import java.util.HashSet;

class Solution {
    public boolean divideArray(int[] nums) {
        final var map = new HashSet<>();
        int remain = 0;
        int counter = 0;
        for (int i : nums) {
            if (map.contains(i)) {
                map.remove(i);
                remain--;
                counter++;
            } else {
                map.add(i);
                remain++;
            }
        }
        return remain == 0 && (counter == (nums.length / 2));
    }
}
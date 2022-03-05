package ir.home.tutorial.algorithm.leetcode.contest.biweekly.biweeklycontest73.p1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int mostFrequent(int[] nums, int key) {
        final var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] == key)
                map.compute(nums[i + 1], (k, v) -> v == null ? 1 : ++v);

        int max = 0;
        int k = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                k = entry.getKey();
            }
        }
        return k;
    }
}
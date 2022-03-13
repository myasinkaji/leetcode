package ir.home.tutorial.algorithm.leetcode.questions.p6031;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        final var keys = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == key)
                keys.add(i);

        int min = 0, max = -1;
        final var kDistances = new ArrayList<Integer>();
        for (int i = 0; i < keys.size(); i++) {
            min = Math.max(Math.max(keys.get(i) - k, 0), max + 1);
            max = Math.min(keys.get(i) + k, nums.length - 1);
            for (int j = min; j <= max; j++) {
                kDistances.add(j);
            }
        }
        return kDistances;
    }
}
package ir.home.tutorial.algorithm.leetcode.questions.p1;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        if (nums.length == 2)
            return new int[]{0, 1};
        else if (nums[nums.length - 1] + nums[nums.length - 2] == target)
            return new int[]{nums.length - 1, nums.length - 2};
        else {
            final var map = new HashMap<Integer, Integer>();
            if (target % 2 == 0) {
                int h1 = 0;
                boolean foundHalf = false;
                int half = target >> 1;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == half) {
                        if (foundHalf) {
                            return new int[]{h1, i};
                        } else {
                            foundHalf = true;
                            h1 = i;
                        }
                    } else {
                        map.put(nums[i], i);
                    }
                }

                if (foundHalf) {

                    for (int i = 0; i < h1; i++) {
                        if (map.get(target - nums[i]) != null)
                            return new int[]{i, map.get(target - nums[i])};
                    }
                    for (int i = h1 + 1; i < nums.length; i++) {
                        if (map.get(target - nums[i]) != null)
                            return new int[]{i, map.get(target - nums[i])};
                    }
                } else {
                    for (int i = 0; i < nums.length; i++) {
                        if (map.get(target - nums[i]) != null)
                            return new int[]{i, map.get(target - nums[i])};
                    }
                }
            } else {
                for (int i = 0; i < nums.length; i++)
                    map.put(nums[i], i);

                for (int i = 0; i < nums.length; i++) {
                    if (map.get(target - nums[i]) != null)
                        return new int[]{i, map.get(target - nums[i])};
                }
            }
        }
        return new int[0];
    }
}

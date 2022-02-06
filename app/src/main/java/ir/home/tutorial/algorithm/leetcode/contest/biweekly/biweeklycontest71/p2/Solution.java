package ir.home.tutorial.algorithm.leetcode.contest.biweekly.biweeklycontest71.p2;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int pivotCount = 0;
        final int[] rearranged = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                rearranged[index] = nums[i];
                index++;
            } else if (nums[i] == pivot) {
                pivotCount++;
            }
        }
        for (int i = 0; i < pivotCount; i++) {
            rearranged[index] = pivot;
            index++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                rearranged[index] = nums[i];
                index++;
            }
        }

        return rearranged;
    }
}
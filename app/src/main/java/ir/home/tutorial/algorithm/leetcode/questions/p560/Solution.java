package ir.home.tutorial.algorithm.leetcode.questions.p560;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}
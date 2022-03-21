package ir.home.tutorial.algorithm.leetcode.contest.biweekly.biweeklycontest74.p1;

class Solution {
    static final int[] arr = new int[501];
    static int testCaseNumber = 0;

    public boolean divideArray(int[] nums) {
        testCaseNumber++;
        int remain = 0;
        for (int i : nums) {
            if (arr[i] == testCaseNumber) {
                arr[i] = 0;
                remain--;
            } else {
                arr[i] = testCaseNumber;
                remain++;
            }
        }
        return remain == 0;
    }
}
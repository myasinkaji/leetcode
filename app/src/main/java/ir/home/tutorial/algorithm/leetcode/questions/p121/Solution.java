package ir.home.tutorial.algorithm.leetcode.questions.p121;

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < min) {
                profit = Math.max(max - min, profit);
                min = prices[i];
                max = prices[i + 1];
                continue;
            }
            if (prices[i + 1] > max) {
                max = prices[i + 1];
            }
        }
        return Math.max(max - min, profit);
    }
}
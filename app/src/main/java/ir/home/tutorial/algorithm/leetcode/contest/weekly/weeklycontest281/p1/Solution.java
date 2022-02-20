 package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest281.p1;

class Solution {
    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            final var s = String.valueOf(i);
            int sum = 0;
            for (int j = 0; j < s.length(); j++) {
                sum += s.charAt(j);
            }
            if (sum % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}
package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest280.p1;

class Solution {
    public int countOperations(int num1, int num2) {
        if (num1 == 0 || num2 == 0)
            return 0;
        return count(num1, num2, 0);
    }

    private int count(int num1, int num2, int count) {
        if (num1 == 0 || num2 == 0)
            return count;

        if (num1 >= num2)
            num1 -= num2;
        else num2 -= num1;

        return count(num1, num2, ++count);
    }
}
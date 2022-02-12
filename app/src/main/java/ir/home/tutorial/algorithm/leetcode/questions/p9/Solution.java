package ir.home.tutorial.algorithm.leetcode.questions.p9;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int reverse = 0;
        int x2 = x;
        do {
            int mod = x2 % 10;
            x2 /= 10;
            reverse = reverse * 10 + mod;
        } while(x2 != 0);

        return reverse == x;
    }
}
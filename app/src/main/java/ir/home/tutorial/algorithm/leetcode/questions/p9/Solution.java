package ir.home.tutorial.algorithm.leetcode.questions.p9;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int reverse = 0;
        do {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        } while (reverse < x);

        return reverse == x || reverse / 10 == x;
    }
}
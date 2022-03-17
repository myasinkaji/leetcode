package ir.home.tutorial.algorithm.leetcode.questions.p856;

class Solution {
    public int scoreOfParentheses(String s) {
        int temp = 0;
        int sum = 0;
        int stack = 0;
        int valuelessParentheses = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack++;
                temp = (int) Math.pow(2, stack - 1);
            } else {
                if (stack > valuelessParentheses)
                    sum += temp;
                stack--;
                valuelessParentheses = stack;
            }
        }
        return sum;
    }
}
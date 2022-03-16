package ir.home.tutorial.algorithm.leetcode.questions.p946;

import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        final var stack = new Stack<Integer>();
        for (int i = 0, popIndex = 0; i < pushed.length; i++) {
            if (pushed[i] == popped[popIndex]) {
                ++popIndex;
                while (stack.size() > 0 && popped[popIndex] == stack.peek()) {
                    stack.pop();
                    popIndex++;
                }
            } else stack.push(pushed[i]);
        }

        return stack.isEmpty();
    }
}
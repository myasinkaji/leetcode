package ir.home.tutorial.algorithm.leetcode.questions.p946;

class Solution {
    private static int[] stack = new int[10];
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (stack.length < pushed.length)
            stack = new int[pushed.length];
        int index = -1;
        for (int i = 0, popIndex = 0; i < pushed.length; i++) {
            if (pushed[i] == popped[popIndex]) {
                ++popIndex;
                while (index > -1 && popped[popIndex] == stack[index]) {
                    index--;
                    popIndex++;
                }
            } else stack[++index] = pushed[i];
        }

        return index == -1;
    }
}
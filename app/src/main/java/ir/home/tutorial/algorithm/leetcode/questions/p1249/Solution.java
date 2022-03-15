package ir.home.tutorial.algorithm.leetcode.questions.p1249;

class Solution {
    public String minRemoveToMakeValid(String s) {
        final var stack = new int[s.length() % 2 == 0 ? s.length() : s.length() - 1];
        int index = -1;
        final StringBuilder sb = new StringBuilder();
        int deleted = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 97 && s.charAt(i) <= 132) {
                sb.append(s.charAt(i));
            } else {
                if ((s.charAt(i) == '(')) {
                    if ((index + 1 < stack.length)) {
                        stack[++index] = i;
                        stack[++index] = deleted;
                    }
                } else {
                    if (index > -1) {
                        final var del = stack[index--];
                        final var idx = stack[index--];
                        sb.append(')');
                        sb.insert(idx - ((index - 1) / 2 + 1 + del), '(');
                    } else deleted++;
                }
            }
        }
        return sb.toString();
    }
}
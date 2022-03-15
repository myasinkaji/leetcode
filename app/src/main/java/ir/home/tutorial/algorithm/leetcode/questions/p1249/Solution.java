package ir.home.tutorial.algorithm.leetcode.questions.p1249;

import java.util.Stack;

record Pair(char ch, int index, int deleted) {
}

class Solution {
    public String minRemoveToMakeValid(String s) {
        final var stack = new Stack<Pair>();
        final StringBuilder sb = new StringBuilder();
        int deleted = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                sb.append(s.charAt(i));
            } else {
                if (s.charAt(i) == '(') {
                    stack.push(new Pair('(', i, deleted));
                } else {
                    if (stack.size() > 0) {
                        final var entry = stack.pop();
                        sb.append(')');
                        sb.insert(entry.index() - (stack.size() + entry.deleted()), entry.ch());
                    } else deleted++;
                }
            }
        }
        return sb.toString();
    }
}
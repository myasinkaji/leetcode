package ir.home.tutorial.algorithm.leetcode.questions.p1249;

import java.util.Stack;

record Pair(char ch, int index, int deleted) {
}

class Solution {
    public String minRemoveToMakeValid(String s) {
        final var stack = new Stack<Pair>();
        int openParentheses = 0;
        int deleted = 0;
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                sb.append(s.charAt(i));
            } else {
                if (s.charAt(i) == '(') {
                    openParentheses++;
                    stack.push(new Pair('(', i, deleted));
                } else {
                    if (openParentheses > stack.size() - openParentheses)
                        stack.push(new Pair(')', i, deleted));
                    else deleted++;
                }
            }
        }
        while (stack.size() > 0 && stack.peek().ch() == '(') stack.pop();
        int closeParentheses = 0;
        while (stack.size() > 0) {
            final var entry = stack.pop();
            if (entry.ch() == ')') {
                sb.insert(entry.index() - (stack.size() + entry.deleted()), entry.ch());
                closeParentheses++;
            } else if (closeParentheses > 0) {
                sb.insert(entry.index() - (stack.size() + entry.deleted()), entry.ch());
                closeParentheses--;
            }
        }
        return sb.toString();
    }
}
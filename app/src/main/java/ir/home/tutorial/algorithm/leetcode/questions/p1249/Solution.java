package ir.home.tutorial.algorithm.leetcode.questions.p1249;

record Pair(int index, int deleted) {
}

class Solution {
    public String minRemoveToMakeValid(String s) {
//        final var stack = new Stack<Pair>();
        final var stack = new Pair[s.length() / 2];
        int index = -1;
        final StringBuilder sb = new StringBuilder();
        int deleted = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 97 && s.charAt(i) <= 132) {
                sb.append(s.charAt(i));
            } else {
                if ((s.charAt(i) == '(')) {
                    if ((index + 1 < stack.length))
                        stack[++index] = new Pair(i, deleted);
                } else {
                    if (index > -1) {
                        final var entry = stack[index--];
                        sb.append(')');
                        sb.insert(entry.index() - (index + 1 + entry.deleted()), '(');
                    } else deleted++;
                }
            }
        }
        return sb.toString();
    }
}
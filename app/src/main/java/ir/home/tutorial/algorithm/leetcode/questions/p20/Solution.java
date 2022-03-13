package ir.home.tutorial.algorithm.leetcode.questions.p20;

class Solution {
    public static final char OPEN_PARENTHESES = '(';
    public static final char CLOSE_PARENTHESES = ')';
    public static final char OPEN_BRACKET = '[';
    public static final char CLOSE_BRACKET = ']';
    public static final char OPEN_CURLY_BRACES = '{';
    public static final char CLOSE_CURLY_BRACES = '}';
    public static char[] stack = new char[1];

    public boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;
        if (stack.length < s.length() / 2)
            stack = new char[s.length() / 2];
        short top = -1;
        for (short i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case OPEN_CURLY_BRACES:
                case OPEN_PARENTHESES:
                case OPEN_BRACKET:
                    if (top == s.length() / 2 - 1)
                        return false;
                    stack[++top] = s.charAt(i);
                    break;
                case CLOSE_CURLY_BRACES:
                    if (top == -1 || stack[top--] != OPEN_CURLY_BRACES)
                        return false;
                    break;
                case CLOSE_PARENTHESES:
                    if (top == -1 || stack[top--] != OPEN_PARENTHESES)
                        return false;
                    break;
                case CLOSE_BRACKET:
                    if (top == -1 || stack[top--] != OPEN_BRACKET)
                        return false;
            }
        }
        return top == -1;
    }
}
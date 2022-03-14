package ir.home.tutorial.algorithm.leetcode.questions.p20;


class MyStack {
    private final Node head = new Node('\n');
    private Node tail = head;
    private short size = 0;

    public void push(char val) {
        if (tail.next == null) {
            tail.next = new Node(val);
            tail.next.prev = tail;
        } else {
            tail.next.val = val;
        }
        tail = tail.next;
        size++;
    }

    public char pop() {
        final char ch = tail.val;
        tail = tail.prev;
        size--;
        return ch;
    }

    public short size() {
        return size;
    }

    public void clear() {
        tail = head;
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    class Node {
        private char val;
        private Node next;
        private Node prev;

        public Node(char val) {
            this.val = val;
        }
    }
}

class Solution {
    public static final char OPEN_PARENTHESES = '(';
    public static final char CLOSE_PARENTHESES = ')';
    public static final char OPEN_BRACKET = '[';
    public static final char CLOSE_BRACKET = ']';
    public static final char OPEN_CURLY_BRACES = '{';
    public static final char CLOSE_CURLY_BRACES = '}';
    public final static MyStack stack = new MyStack();


    public boolean isValid(String s) {
        stack.clear();
        if (s.length() % 2 == 1)
            return false;

        for (short i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case OPEN_CURLY_BRACES:
                case OPEN_PARENTHESES:
                case OPEN_BRACKET:
                    if (stack.size() == s.length() / 2)
                        return false;
                    stack.push(s.charAt(i));
                    break;
                case CLOSE_CURLY_BRACES:
                    if (stack.isEmpty() || stack.pop() != OPEN_CURLY_BRACES)
                        return false;
                    break;
                case CLOSE_PARENTHESES:
                    if (stack.isEmpty() || stack.pop() != OPEN_PARENTHESES)
                        return false;
                    break;
                case CLOSE_BRACKET:
                    if (stack.isEmpty() || stack.pop() != OPEN_BRACKET)
                        return false;
            }
        }
        return stack.isEmpty();
    }
}
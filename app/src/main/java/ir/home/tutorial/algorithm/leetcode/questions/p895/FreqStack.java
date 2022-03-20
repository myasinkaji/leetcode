package ir.home.tutorial.algorithm.leetcode.questions.p895;

import java.util.HashMap;
import java.util.Map;

class Node {
    final int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class FreqStack {
    private final Map<Integer, Node> pointers = new HashMap<>();
    private final Map<Integer, Integer> counter = new HashMap<>();
    private static final Node top = new Node(0); // fake start node

    public FreqStack() {
    }

    public void push(int x) {
        int count = counter.getOrDefault(x, 0) + 1;
        counter.put(x, count);
        final var pointer = pointers.get(count);
        final var node = new Node(x);
        if (pointer != null) {
            node.next = pointer.next;
            pointer.next = node;
        } else {
            node.next = top.next;
            top.next = node;
            pointers.put(count - 1, top.next);
            pointers.put(count, top);
        }
    }

    public int pop() {
        final var x = top.next.val;
        final var count = counter.put(x, counter.get(x) - 1);
        if (pointers.get(count - 1) == top.next) {
            pointers.remove(count);
            pointers.put(count - 1, top);
        }
        top.next = top.next.next;
        return x;
    }
}
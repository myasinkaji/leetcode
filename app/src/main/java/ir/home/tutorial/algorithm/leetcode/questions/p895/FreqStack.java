package ir.home.tutorial.algorithm.leetcode.questions.p895;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    final int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class FreqStack {
    private final List<Node> pointers = new ArrayList<>();
    private final Map<Integer, Integer> counter = new HashMap<>();
    private static final Node top = new Node(0); // fake start node

    public FreqStack() {
        pointers.add(top);
    }

    public void push(int x) {
        int count = counter.getOrDefault(x, 0);
        final var node = new Node(x);
        if (pointers.size() == count) {
            node.next = top.next;
            top.next = node;
            pointers.set(count - 1, top.next);
            pointers.add(count, top);
        } else {
            final var pointer = pointers.get(count);
            node.next = pointer.next;
            pointer.next = node;
        }
        counter.put(x, count + 1);
    }

    public int pop() {
        final var x = top.next.val;
        final var count = counter.put(x, counter.get(x) - 1);
        if (pointers.size() > 1 && pointers.get(count - 2) == top.next) {
            pointers.set(count - 2, top);
            pointers.remove(count - 1);
        }
        top.next = top.next.next;
        return x;
    }
}
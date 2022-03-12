package ir.home.tutorial.algorithm.leetcode.questions.p138;

class Solution {
    public Node copyRandomList(final Node head) {
        if (head == null)
            return null;

        var tail = head;
        while (tail != null) {
            final var node = new Node(tail.val);
            node.next = tail.next;
            tail.next = node;
            tail = node.next;
        }

        tail = head;
        while (tail != null) {
            tail.next.random = tail.random == null ? null : tail.random.next;
            tail = tail.next.next;
        }
        tail = head;
        final var h = head.next;
        Node tmp;
        while (tail != null) {
            tmp = tail.next.next;
            tail.next.next = tail.next.next == null ? null : tail.next.next.next;
            tail.next = tmp;
            tail = tail.next;
        }

        return h;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

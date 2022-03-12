package ir.home.tutorial.algorithm.leetcode.questions.p138;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public Node copyRandomList(final Node head) {
        final var nodeToIndex = new HashMap<Node, Integer>();
        final var indexToNode = new ArrayList<Node>();
        var tail = head;
        final var copyHead = new Node(0);
        var copyTail = copyHead;
        int count;
        for (count = 0; tail != null; count++) {
            copyTail.next = new Node(tail.val);
            copyTail = copyTail.next;
            indexToNode.add(copyTail);
            nodeToIndex.put(tail, count);
            tail = tail.next;
        }

        copyTail = copyHead.next;
        tail = head;
        while (tail != null) {
            if (tail.random != null)
                copyTail.random = indexToNode.get(nodeToIndex.get(tail.random));
            copyTail = copyTail.next;
            tail = tail.next;
        }

        return copyHead.next;
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

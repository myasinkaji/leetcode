package ir.home.tutorial.algorithm.leetcode.questions.p2;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val;this.next = next;}
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final var head = new ListNode();
        var tail = head;
        boolean overflow = false;
        while (l1.next != null && l2.next != null) {
            tail.val = (l1.val + l2.val + (overflow ? 1 : 0)) % 10;
            overflow = 10 - (l1.val + l2.val + (overflow ? 1 : 0)) <= 0;
            l1 = l1.next;
            l2 = l2.next;
            tail.next = new ListNode();
            tail = tail.next;
        }
        tail.val = (l1.val + l2.val + (overflow ? 1 : 0)) % 10;
        overflow = 10 - (l1.val + l2.val + (overflow ? 1 : 0)) <= 0;

        while (l1.next != null) {
            l1 = l1.next;
            tail.next = new ListNode();
            tail = tail.next;
            tail.val = (l1.val + (overflow ? 1 : 0)) % 10;
            overflow = 10 - (l1.val + (overflow ? 1 : 0)) == 0;
        }

        while (l2.next != null) {
            l2 = l2.next;
            tail.next = new ListNode();
            tail = tail.next;
            tail.val = (l2.val + (overflow ? 1 : 0)) % 10;
            overflow = 10 - (l2.val + (overflow ? 1 : 0)) == 0;
        }

        if (overflow) {
            tail.next = new ListNode();
            tail = tail.next;
            tail.val = 1;
        }

        return head;
    }
}
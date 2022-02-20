package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest281.p2;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode();
        ListNode resHead = result;
        int sum = 0;
        head = head.next;
        while (head != null) {
            if (head.val == 0) {
                result.next = new ListNode();
                result = result.next;
                result.val = sum;
                sum = 0;
            } else {
                sum += head.val;
            }
            head = head.next;
        }
        return resHead.next;
    }
}
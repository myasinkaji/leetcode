package ir.home.tutorial.algorithm.leetcode.questions.p141;


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
     public static ListNode head(int val) {
         return new ListNode(val);
     }

    public void next(ListNode node) {
        next = node;
    }

    public ListNode next(int val) {
        next = new ListNode(val);
        return next;
    }
}

public class Solution {
    public boolean hasCycle(final ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode hare = head;
        ListNode tortoise = head;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if (hare == tortoise)
                return true;
        }

        return false;
    }
}
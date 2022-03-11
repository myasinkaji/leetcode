package ir.home.tutorial.algorithm.leetcode.questions.p141;


import java.util.HashSet;
import java.util.Set;

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
    public boolean hasCycle(ListNode head) {
        final Set<ListNode> visitedNodes = new HashSet<>();
        while (head != null) {
            if (visitedNodes.contains(head))
                return true;
            visitedNodes.add(head);
            head = head.next;
        }
        return false;
    }
}
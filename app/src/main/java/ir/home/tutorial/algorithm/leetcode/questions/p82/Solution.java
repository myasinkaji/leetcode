package ir.home.tutorial.algorithm.leetcode.questions.p82;


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        final var head2 = new ListNode(0);
        if (head != null) {
            final int[] nums = new int[201];
            while (head != null) {
                int index = head.val >= 0 ? 100 + head.val : 100 - (-head.val);
                nums[index]++;
                head = head.next;
            }
            var tail = head2;
            for (int i = 0; i < 100; i++) {
                if (nums[i] == 1) {
                    tail.next = new ListNode(i - 100);
                    tail = tail.next;
                }
            }
            for (int i = 100; i < 201; i++) {
                if (nums[i] == 1) {
                    tail.next = new ListNode(i - 100);
                    tail = tail.next;
                }
            }
        }
        return head2.next;
    }
}
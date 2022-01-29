package ir.home.tutorial.algorithm.leetcode.contest.weeklycontest277.q2;


public class Solution {
    private class IntLinkedList {
        private IntNode head;
        private IntNode tail;
        private int count = 0;
        private int remove() {
            int value = head.value;
            head = head.next;
            count--;
            return value;
        }

        private void add(int value) {
            if (head == null)
                head = tail = new IntNode(value, null);
            else {
                tail.next = new IntNode(value, null);
                tail = tail.next;
            }
            count++;
        }

        public boolean isEmpty() {
            return count == 0;
        }
    }

    private static class IntNode {
        private final int value;
        private IntNode next;

        public IntNode(int value, IntNode next) {
            this.value = value;
            this.next = next;
        }

        public void setNext(IntNode next) {
            this.next = next;
        }
    }


    public int[] rearrangeArray(int[] nums) {
        //Todo: This must not be initialized in best case
        //Todo: Test Linked list
//        final int[] tmp = new int[nums.length >> 1];
//        short last = 0;
//        short head = -1;

        final var tmp = new IntLinkedList();
        int c = 0;
        boolean p = false;
        boolean n = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                if (p) {
                    nums[c] = tmp.remove();
                    nums[c + 1] = nums[i];
                    c += 2;
                    if (tmp.isEmpty()) p = false;
                } else {
                    tmp.add(nums[i]);
                    n = true;
                }
            } else {
                if (n) {
                    nums[c] = nums[i];
                    nums[c + 1] = tmp.remove();
                    c += 2;
                    if (tmp.isEmpty()) n = false;
                } else {
                    tmp.add(nums[i]);
                    p = true;
                }
            }
        }
        return nums;
    }
}

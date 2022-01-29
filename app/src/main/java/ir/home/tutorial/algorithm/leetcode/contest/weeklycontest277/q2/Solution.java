package ir.home.tutorial.algorithm.leetcode.contest.weeklycontest277.q2;


public class Solution {
    private class IntLinkedList {
        private IntNode head;
        private IntNode tail;

        private int remove() {
            int value = head.value;
            head = head.next;
            return value;
        }

        private void add(int value) {
            if (head == null)
                head = tail = new IntNode(value, null);
            else {
                tail.next = new IntNode(value, null);
                tail = tail.next;
            }
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
        short len = (short) (nums.length >> 1);
        final int[] positives = new int[len];
        final int[] negatives = new int[len];
        int posIndex = 0, negIndex = 0;
        for (int i = 0; i <nums.length ; i++) {
            int num = nums[i];
            if (num < 0)
                negatives[negIndex++] = num;
            else
                positives[posIndex++] = num;
        }
        posIndex = negIndex = 0;
        for (int i = 0; i < len; i++) {
            nums[i << 1] = positives[posIndex++];
            nums[(i << 1) + 1] = negatives[negIndex++];
        }
        return nums;
    }
}

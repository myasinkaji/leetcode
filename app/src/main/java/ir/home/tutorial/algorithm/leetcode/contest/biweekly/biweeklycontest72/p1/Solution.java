package ir.home.tutorial.algorithm.leetcode.contest.biweekly.biweeklycontest72.p1;

class Solution {
    class LinkedList {
        final Node head;
        Node tail;

        public LinkedList(int data) {
            head = new Node(data, null);
            tail = head;
        }
        void add(int i) {
            tail.next = new Node(i, null);
            tail = tail.next;
        }
    }

    class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public int countPairs(int[] nums, int k) {
        final var numbers = new LinkedList[100];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (numbers[nums[i] - 1] != null) {
                Node head = numbers[nums[i] - 1].head;
                while (head != null) {
                    if (head.data * i % k == 0)
                        count++;
                    head = head.next;
                }
                numbers[nums[i] - 1].add(i);
            } else {
                numbers[nums[i] - 1] = new LinkedList(i);
            }
        }

        return count;
    }
}
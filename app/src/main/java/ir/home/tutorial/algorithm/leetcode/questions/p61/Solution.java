package ir.home.tutorial.algorithm.leetcode.questions.p61;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class DoublyListNode {
    int val;
    DoublyListNode next;
    DoublyListNode prev;

    DoublyListNode() {
    }

    DoublyListNode(int val) {
        this.val = val;
    }

    DoublyListNode(int val, DoublyListNode next, DoublyListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class Solution {
    public ListNode rotateRight(final ListNode head, int k) {
        if (k > 0 && head != null) {
            var h = new DoublyListNode(head.val);
            var t = h;
            var tail = head.next;
            int count = 1;
            while (tail != null) {
                count++;
                t.next = new DoublyListNode(tail.val, null, t);
                t = t.next;
                tail = tail.next;
            }
            k = k % count;
            if (k == 0)
                return head;
            while (k > 0) {
                var tmp = t.prev;
                t.prev.next = null;
                t.prev = null;
                t.next = h;
                h.prev = t;
                h = t;
                t = tmp;
                k--;
            }

            final var resultHead = new ListNode(h.val);
            var resultTail = resultHead;
            t = h.next;
            while(t != null) {
                resultTail.next = new ListNode(t.val);
                resultTail = resultTail.next;
                t = t.next;
            }
            return resultHead;
        }
        return head;
    }
}
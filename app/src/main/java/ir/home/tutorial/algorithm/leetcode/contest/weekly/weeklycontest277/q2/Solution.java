package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest277.q2;

public class Solution {

    public int[] rearrangeArray(int[] nums) {
        final int[] tmp = new int[nums.length >> 1];
        int last = 0;
        int head = 0;

        int c = 0;
        boolean p = false;
        boolean n = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                if (p) {
                    nums[c] = tmp[head++];
                    if (head == last) {
                        head = last = 0;
                        p = false;
                    }
                    nums[c + 1] = nums[i];
                    c += 2;
                } else {
                    tmp[last] = nums[i];
                    last++;
                    n = true;
                }
            } else {
                if (n) {
                    nums[c] = nums[i];
                    nums[c + 1] = tmp[head++];
                    if (head == last) {
                        head = last = 0;
                        n = false;
                    }
                    c += 2;
                } else {
                    tmp[last] = nums[i];
                    last++;
                    p = true;
                }
            }
        }
        return nums;
    }
}

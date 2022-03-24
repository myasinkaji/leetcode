package ir.home.tutorial.algorithm.leetcode.questions.p881;


import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        for (int i = 0, j = people.length - 1; i <= j; j--) {
            if (people[i] + people[j] <= limit)
                i++;
            count++;
        }
        return count;
    }
}
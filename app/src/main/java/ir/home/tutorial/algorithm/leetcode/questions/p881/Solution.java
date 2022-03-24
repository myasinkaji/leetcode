package ir.home.tutorial.algorithm.leetcode.questions.p881;


class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        for (int i = people.length - 1; i > -1; i--) {
            if (people[i] != 0) {
                for (int j = i - 1; j > -1; j--) {
                    if (people[j] != 0 && people[j] + people[i] <= limit) {
                        people[j] = 0;
                        break;
                    }
                }
                count++;
                people[i] = 0;
            }
        }

        return count;
    }
}
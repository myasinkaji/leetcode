package ir.home.tutorial.algorithm.leetcode.questions.p1007;

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n1 = tops[0];
        int notN1B = bottoms[0] != n1 ? 1 : 0;
        int notN1T = 0;

        int n2 = bottoms[0];
        int notN2B = 0;
        int notN2T = tops[0] != n2 ? 1 : 0;

        int number = 0;
        int i = 1;

        int notT = 0;
        int notB = 0;
        for (; i < tops.length; i++) {
            if (tops[i] != n1 && bottoms[i] != n1) {
                number = n2;
                notT = notN2T;
                notB = notN2B;
                break;
            }
            if (tops[i] != n2 && bottoms[i] != n2) {
                number = n1;
                notT = notN1T;
                notB = notN1B;
                break;
            }

            if (bottoms[i] != n1) notN1B++;
            if (tops[i] != n1) notN1T++;

            if (bottoms[i] != n2) notN2B++;
            if (tops[i] != n2) notN2T++;

        }

        // if true, then there are two response and both have the same minimum. So we focus on n1
        if (i == tops.length) return Math.min(notN1B, notN1T);

        for (int j = i; j < tops.length; j++) {
            if (tops[j] != number && bottoms[j] != number)
                return -1;
            if (bottoms[j] != number) notB++;
            if (tops[j] != number) notT++;
        }

        return Math.min(notT, notB);
    }
}
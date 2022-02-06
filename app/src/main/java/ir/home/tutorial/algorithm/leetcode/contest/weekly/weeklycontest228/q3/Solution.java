package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest228.q3;


class Solution {
    public String subStrHash4(String s, int power, int modulo, int k, int hashValue) {

        long powerK_1 = 1;
        int p = k - 1;
        while (p > 0) {
            powerK_1 = (powerK_1 * power) % modulo;
            p--;
        }

        int index = 0;
        int end = s.length() - 1;
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int sVal = s.charAt(i) - 'a' + 1;
            hash = (hash * power % modulo + sVal) % modulo;
            if (end - i + 1 == k) {
                if (hash == hashValue) {
                    index = i;
                }
                hash = (hash - (s.charAt(end) - 'a' + 1) * powerK_1 % modulo + modulo) % modulo;
                end--;
            }
        }
        return s.substring(index, index + k);
    }
    public String subStrHash2(String s, int power, int modulo, int k, int hashValue) {
        int i;
        double sum = 0;
        for (i = 0; i < k; i++)
            sum += (s.charAt(i) - 96) * Math.pow(power, i);
        int first = 0;
        while ((sum % modulo != hashValue) && i < s.length()) {
            sum -= s.charAt(first) - 96;
            sum /= power;
            sum += (s.charAt(i) - 96) * Math.pow(power, k - 1);
            i++;
            first++;
        }

        return s.substring(first, i);
    }

    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long hash;
        int j = -1;
        do {
            j++;
            hash = 0;
            for (int i = j; i < k + j; i++)
                hash += (((s.charAt(i) - 96) % modulo) * (modOfPower(power, i - j, modulo)) % modulo);
            hash %= modulo;
        } while (hash != hashValue);
        return s.substring(j, j + k);
    }


    public long modOfPower(int root, int power, int modulo) {
        long result = 1;
        for (int i = 0; i < power; i++)
            result = (result % modulo) * (root % modulo);

        return result % modulo;
    }


    public static long modOfSum(int modulo, int... r) {
        int result = 0;
        for (int i = 0; i < r.length; i++)
            result = (result % modulo) + (r[i] % modulo);

        return result % modulo;
    }
    public static long modOfSum(int a, int b, int modulo) {
        return ((a % modulo) + (a % modulo)) % modulo;
    }
    public static double modV1(int root, int power, int modulo) {
        return (Math.pow((root % modulo), power)) % modulo;
    }
}
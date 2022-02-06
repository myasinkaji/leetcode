package ir.home.tutorial.algorithm.leetcode.questions.p3;

import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(final String s) {
        final var string = s.toCharArray();
        final var seenChars = new HashMap<Character, Integer>();
        final var queue = new ArrayDeque<>(26);
        int start = 0;
        int highestLength = 0;

        int i;
        for (i = 0; i < s.length(); i++) {
            if (seenChars.containsKey(string[i])) {
                highestLength = (i - start) > highestLength ? (i - start): highestLength;
                int occurrence = seenChars.get(string[i]);
                for (int j = start; j <= occurrence; j++) seenChars.remove(queue.remove());
                start = occurrence + 1;
            }
            seenChars.put(string[i], i);
            queue.add(string[i]);
        }
        highestLength = (i - start) > highestLength ? (i - start): highestLength;
        return highestLength;
    }
}
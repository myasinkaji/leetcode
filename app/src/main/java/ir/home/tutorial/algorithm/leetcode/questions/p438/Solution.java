package ir.home.tutorial.algorithm.leetcode.questions.p438;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        final var list = new ArrayList<Integer>();
        final Integer[] anagrams = new Integer[26];
        for (int i = 0; i < p.length(); i++) {
            final var index = p.charAt(i) - 97;
            if (anagrams[index] == null) anagrams[index] = 1;
            else anagrams[index]++;
        }

        int start = 0;
        final int mustFind = p.length();
        int founded = 0;
        var anagramsCopy = new int[26];

        for (int i = 0; i < s.length(); i++) {
            final var index = s.charAt(i) - 97;
            if (anagrams[index] == null) {
                if (founded > 0) {
                    anagramsCopy = new int[26];
                    founded = 0;
                }
                start = i + 1;
            } else {
                if (anagramsCopy[index] == anagrams[index]) {
                    char removedChar;
                    do {
                        removedChar = s.charAt(start);
                        start++;
                        int idx = removedChar - 97;
                        anagramsCopy[idx]--;
                        founded--;
                    } while (removedChar != s.charAt(i));
                }
                anagramsCopy[index]++;
                founded++;
                if (founded == mustFind) {
                    list.add(start);
                    anagramsCopy[s.charAt(start) - 97]--;
                    start++;
                    founded--;
                }
            }
        }

        return list;
    }
}
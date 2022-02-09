package ir.home.tutorial.algorithm.leetcode.questions.p438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        final var map = new HashMap<Character, Integer>((int) (p.length() / 0.75));
        final var queue = new ArrayBlockingQueue<Character>(p.length());
        final var list = new ArrayList<Integer>();

        for (int i = 0; i < p.length(); i++) {
            final var c = p.charAt(i);
            int val = 1;
            if (map.containsKey(c)) {
                val = map.get(c) + 1;
            }
            map.put(c, val);
        }
        for (int i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            if (map.containsKey(c)) {
                if (queue.contains(c) && queue.stream().filter(ch -> ch == c).count() >= map.get(c)) {
                    char cr = queue.remove();
                    while (cr != c) cr = queue.remove();
                }
                queue.add(c);
                if (queue.size() == p.length()) {
                    list.add(i - p.length() + 1);
                    queue.remove();
                }

            } else {
                queue.clear();
            }
        }

        return list;
    }
}
package ir.home.tutorial.algorithm.leetcode.questions.p763;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static final short[] starts = new short[26];
    static final short[] ends = new short[26];

    public List<Integer> partitionLabels(String s) {
        final var list = new ArrayList<Integer>();
        for (short i = 1; i <= s.length(); i++) {
            char ch = s.charAt(i - 1);
            if (starts[ch - 97] == 0)
                starts[ch - 97] = i;
            else ends[ch - 97] = i;
        }

        Arrays.sort(starts);
        short i = 0;
        for (; starts[i] == 0; i++) {
        }

        while (i < 26) {
            final var start = starts[i];
            var end = Math.max(ends[s.charAt(start - 1) - 97], 0);
            starts[i] = 0;
            ends[s.charAt(start - 1) - 97] = 0;
            i++;
            for (; i < 26 && starts[i] < end; i++) {
                final var i1 = ends[s.charAt(starts[i] - 1) - 97];
                if (i1 > end)
                    end = i1;
                ends[s.charAt(starts[i] - 1) - 97] = 0;
                starts[i] = 0;
            }
            list.add(end == 0 ? 1 : end - start + 1);
        }

        return list;
    }
}
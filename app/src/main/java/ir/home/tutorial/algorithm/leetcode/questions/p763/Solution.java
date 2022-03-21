package ir.home.tutorial.algorithm.leetcode.questions.p763;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Boundary {
    final short start;
    short end;

    Boundary(short start) {
        this.start = start;
    }
}
class Solution {
    public List<Integer> partitionLabels(String s) {
        final var list = new ArrayList<Integer>();
        final var boundaries = new Boundary[26];
        for (short i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (boundaries[ch - 97] == null)
                boundaries[ch - 97] = new Boundary(i);
            else boundaries[ch - 97].end = i;
        }
        Arrays.sort(boundaries, Comparator.comparing(b -> b != null ? b.start : Short.MAX_VALUE));
        for (short i = 0; i < 26 && boundaries[i] != null;) {
            final var boundary = boundaries[i];
            i++;
            for (; i < 26 && boundaries[i] != null && boundaries[i].start < boundary.end; i++)
                if (boundaries[i].end > boundary.end)
                    boundary.end = boundaries[i].end;
            list.add(boundary.end == 0 ? 1 :  boundary.end - boundary.start + 1);
        }

        return list;
    }
}
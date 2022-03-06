package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest283.p1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> cellsInRange(String s) {
        List<String> list = new ArrayList<>(300);
        for (int col = s.charAt(0); col <= s.charAt(3); col++)
            for (int row = s.charAt(1); row <= s.charAt(4); row++)
                list.add((char) col + "" + (char) row);

        return list;
    }
}
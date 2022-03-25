package ir.home.tutorial.algorithm.leetcode.questions.p1029;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(o -> (o[1] - o[0])));
        int cost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            cost += costs[i][1] + costs[costs.length - 1 - i][0];
        }
        return cost;
    }
}
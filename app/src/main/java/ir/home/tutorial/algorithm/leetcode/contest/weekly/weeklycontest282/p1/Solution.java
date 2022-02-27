 package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest282.p1;

 class Solution {
     public int prefixCount(String[] words, String pref) {
         int count = 0;
         for (String word : words) {
             if (word.startsWith(pref))
                 count++;
         }
         return count;
     }
 }
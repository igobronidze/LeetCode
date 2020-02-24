package com.leetcode.problems.p338;

class Solution {

    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        if (num == 0) {
            return dp;
        }
        for (int i = 1; i < num + 1; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + 1;
            }
        }
        return dp;
    }
}
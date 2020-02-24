package com.leetcode.problems.p931;

class Solution {

    public int minFallingPathSum(int[][] A) {
        int[][] dp = new int[A.length][A[0].length];
        for (int i = 0; i < A[0].length; i++) {
            dp[0][i] = A[0][i];
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
                if (j != 0) {
                    a = dp[i - 1][j - 1];
                }
                b = dp[i - 1][j];
                if (j != A[i].length - 1) {
                    c = dp[i - 1][j + 1];
                }
                dp[i][j] = Math.min(a, b);
                dp[i][j] = Math.min(dp[i][j], c);
                dp[i][j] += A[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A[0].length; i++) {
            min = Math.min(min, dp[A.length - 1][i]);
        }
        return min;
    }
}

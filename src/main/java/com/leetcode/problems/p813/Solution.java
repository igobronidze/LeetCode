package com.leetcode.problems.p813;

class Solution {

    public double largestSumOfAverages(int[] A, int K) {
        double[][] dp = new double[A.length + 1][K + 1];

        double[] sum = new double[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] = sum[i - 1] + A[i];
        }

        dp[0][1] = A[0];
        for (int i = 1; i < A.length; i++) {
            dp[i][1] = sum[i] / (i + 1);
            for (int j = 2; j <= Math.min(K, i + 1); j++) {
                for (int p = 0; p < i; p++) {
                    if (dp[p][j - 1] != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[p][j - 1] + (sum[i] - sum[p]) / (i - p));
                    }
                }
            }
        }

        return dp[A.length - 1][K];
    }
}
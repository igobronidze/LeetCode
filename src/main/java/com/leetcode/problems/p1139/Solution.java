package com.leetcode.problems.p1139;

class Solution {

    public int largest1BorderedSquare(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] vertical = new int[n][m];
        int[][] horizontal = new int[n][m];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int v = 0, h =0;
                    if (i != 0) {
                        v = vertical[i - 1][j];
                    }
                    if (j != 0) {
                        h = horizontal[i][j - 1];
                    }
                    vertical[i][j] = v + 1;
                    horizontal[i][j] = h + 1;
                }
            }
        }


        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int p = 1; p <= Math.min(i, j) + 1; p++) {
                    if (vertical[i][j] >= p && horizontal[i][j] >= p) {
                        if (horizontal[i - p + 1][j] >= p && vertical[i][j - p + 1] >= p) {
                            max = Math.max(max, p);
                        }
                    }
                }
            }
        }
        return max * max;
    }
}

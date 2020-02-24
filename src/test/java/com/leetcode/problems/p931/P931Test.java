package com.leetcode.problems.p931;

import org.junit.Assert;
import org.junit.Test;

public class P931Test {

    @Test
    public void testCase1() {
        int[][] input = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Solution solution = new Solution();
        Assert.assertEquals(12, solution.minFallingPathSum(input));
    }
}

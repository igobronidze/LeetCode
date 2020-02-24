package com.leetcode.problems.p1139;

import org.junit.Assert;
import org.junit.Test;

public class P1139Test {

    @Test
    public void testCase1() {
        int[][] input = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        Assert.assertEquals(9, new Solution().largest1BorderedSquare(input));
    }

    @Test
    public void testCase2() {
        int[][] input = new int[][]{
                {1, 1, 0, 0}
        };
        Assert.assertEquals(1, new Solution().largest1BorderedSquare(input));
    }

    @Test
    public void testCase3() {
        int[][] input = new int[][]{
                {0}
        };
        Assert.assertEquals(0, new Solution().largest1BorderedSquare(input));
    }
}

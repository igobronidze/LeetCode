package com.leetcode.problems.p785;

import org.junit.Assert;
import org.junit.Test;

public class P785Test {

    @Test
    public void testCase1() {
        Solution solution = new Solution();
        int[][] input = new int[][] {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        Assert.assertTrue(solution.isBipartite(input));
    }

    @Test
    public void testCase2() {
        Solution solution = new Solution();
        int[][] input = new int[][] {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };
        Assert.assertFalse(solution.isBipartite(input));
    }

    @Test
    public void testCase3() {
        Solution solution = new Solution();
        int[][] input = new int[][] {
                {},
                {2,4,6},
                {1,4,8,9},
                {7,8},
                {1,2,8,9},
                {6,9},
                {1,5,7,8,9},
                {3,6,9},
                {2,3,4,6,9},
                {2,4,5,6,7,8}
        };
        Assert.assertFalse(solution.isBipartite(input));
    }

    @Test
    public void testCase4() {
        Solution solution = new Solution();
        int[][] input = new int[][] {
                {1,3,5},
                {0,3,7,8},
                {6,7},
                {0,1,7,8},
                {5,8},
                {0,4,6,7,8},
                {2,5,8},
                {1,2,3,5,8},
                {1,3,4,5,6,7}
        };
        Assert.assertFalse(solution.isBipartite(input));
    }
}

package com.leetcode.problems.p207;

import org.junit.Assert;
import org.junit.Test;

public class P207Test {

    @Test
    public void testCase1() {
        Assert.assertTrue(new Solution().canFinish(2, new int[][] {
                {1, 0}
        }));
    }

    @Test
    public void testCase2() {
        Assert.assertFalse(new Solution().canFinish(2, new int[][] {
                {1, 0},
                {0, 1}
        }));
    }

}

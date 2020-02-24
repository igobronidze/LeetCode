package com.leetcode.problems.p813;

import org.junit.Assert;
import org.junit.Test;

public class P813Test {

    @Test
    public void testCase1() {
        Assert.assertEquals(20, new Solution().largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3), 0.000001);
    }
}

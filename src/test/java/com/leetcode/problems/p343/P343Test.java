package com.leetcode.problems.p343;

import org.junit.Assert;
import org.junit.Test;

public class P343Test {

    @Test
    public void testCase1() {
        Assert.assertEquals(1, new Solution().integerBreak(2));
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(36, new Solution().integerBreak(10));
    }
}

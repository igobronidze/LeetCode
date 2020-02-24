package com.leetcode.problems.p338;

import org.junit.Assert;
import org.junit.Test;

public class P338Test {

    @Test
    public void testCase1() {
        int[] expected = new int[] {0, 1, 1};
        int[] ans = new Solution().countBits(2);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], ans[i]);
        }
    }
}

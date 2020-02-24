package com.leetcode.problems.p215;

import org.junit.Assert;
import org.junit.Test;

public class P215Test {

    @Test
    public void testCase1() {
        Solution solution = new Solution();
        Assert.assertEquals(5, solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    @Test
    public void testCase2() {
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    @Test
    public void testCase3() {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.findKthLargest(new int[]{3, 1, 2, 4}, 2));
    }
}

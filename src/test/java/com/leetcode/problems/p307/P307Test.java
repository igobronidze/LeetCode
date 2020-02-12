package com.leetcode.problems.p307;

import org.junit.Assert;
import org.junit.Test;

public class P307Test {

    @Test
    public void testCase1() {
        NumArray numArray = new NumArray(new int[] {0, 9, 5, 7, 3});
        Assert.assertEquals(3, numArray.sumRange(4, 4));
        Assert.assertEquals(15, numArray.sumRange(2, 4));
        Assert.assertEquals(7, numArray.sumRange(3, 3));
        numArray.update(4,5);
        numArray.update(1,7);
        numArray.update(0,8);
        Assert.assertEquals(12, numArray.sumRange(1, 2));
        numArray.update(1,9);
        Assert.assertEquals(5, numArray.sumRange(4, 4));
        numArray.update(3,4);
    }
}

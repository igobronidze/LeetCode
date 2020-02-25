package com.leetcode.algorithm.bit;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BinaryIndexedTreeTest {

    @Test
    public void testCase1() {
        BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree(Arrays.asList(2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(12, binaryIndexedTree.getSum(5));
        binaryIndexedTree.update(2, 6);
        Assert.assertEquals(18, binaryIndexedTree.getSum(5));
    }
}

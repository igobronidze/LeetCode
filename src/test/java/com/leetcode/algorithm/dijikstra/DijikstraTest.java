package com.leetcode.algorithm.dijikstra;

import com.leetcode.algorithm.graph.dijikstra.Dijikstra;
import org.junit.Assert;
import org.junit.Test;

public class DijikstraTest {

    @Test
    public void testCase1() {
        int[] expected = new int[]{0, 4, 12, 19, 21, 11, 9, 8, 14};
        int[] result = Dijikstra.dijikstra(new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}});

        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], result[i]);
        }
    }
}

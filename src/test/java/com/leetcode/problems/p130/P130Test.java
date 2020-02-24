package com.leetcode.problems.p130;

import org.junit.Assert;
import org.junit.Test;

public class P130Test {

    @Test
    public void testCase1() {
        char[][] input = new char[][] {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        char[][] output = new char[][] {
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        Solution solution = new Solution();
        solution.solve(input);
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                Assert.assertEquals(input[i][j], output[i][j]);
            }
        }
    }
}

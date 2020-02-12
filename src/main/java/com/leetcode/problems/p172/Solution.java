package com.leetcode.problems.p172;

class Solution {

    public int trailingZeroes(int n) {
        int count = 0;
        int x = 5;
        while (x <= Integer.MAX_VALUE / 5) {
            count += n / x;
            x *= 5;
        }
        count += n / x;
        return count;
    }
}
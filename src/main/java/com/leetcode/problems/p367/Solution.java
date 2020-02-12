package com.leetcode.problems.p367;

class Solution {
    public boolean isPerfectSquare(int num) {
        double d = Math.sqrt(num);
        return (int)d * (int)d == num;
    }
}

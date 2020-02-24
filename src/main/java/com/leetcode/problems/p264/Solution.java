package com.leetcode.problems.p264;

class Solution {

    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int nextFromSet2 = 2;
        int nextFromSet3 = 3;
        int nextFromSet5 = 5;
        int index2 = 0, index3 = 0, index5 = 0;

        for (int i = 1; i < n; i++) {
            int nextUglyNumber = Math.min(nextFromSet2, nextFromSet3);
            nextUglyNumber = Math.min(nextUglyNumber, nextFromSet5);
            uglyNumbers[i] = nextUglyNumber;

            if (nextUglyNumber == nextFromSet2) {
                index2++;
                nextFromSet2 = uglyNumbers[index2] * 2;
            }
            if (nextUglyNumber == nextFromSet3) {
                index3++;
                nextFromSet3 = uglyNumbers[index3] * 3;
            }
            if (nextUglyNumber == nextFromSet5) {
                index5++;
                nextFromSet5 = uglyNumbers[index5] * 5;
            }
        }
        return uglyNumbers[n - 1];
    }
}
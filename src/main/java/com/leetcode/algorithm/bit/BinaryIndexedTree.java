package com.leetcode.algorithm.bit;

import java.util.List;

public class BinaryIndexedTree {

    private int[] bit;

    private int n;

    public BinaryIndexedTree(List<Integer> list) {
        this.bit = new int[list.size() + 1];
        this.n = list.size();
        for (int i = 0; i < list.size(); i++) {
            update(i, list.get(i));
        }
    }

    public void update(int index, int delta) {
        index++;
        while (index <= n) {
            bit[index] += delta;
            index += (index & (-index));
        }
    }

    public int getSum(int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index = index - (index & (-index));
        }
        return sum;
    }
}

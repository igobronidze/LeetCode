package com.leetcode.problems.p703;

import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer> priorityQueue;

    private int k;

    public KthLargest(int k, int[] nums) {
        this.priorityQueue = new PriorityQueue<>(k);
        this.k = k;
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        if(priorityQueue.size() == k) {

            val = Math.max(val, priorityQueue.poll());
        }
        priorityQueue.add(val);

        return priorityQueue.peek();
    }
}
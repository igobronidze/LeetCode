package com.leetcode.algorithm.heap;

import java.util.List;

public class Heap {

    private int[] heap = new int[100001];

    private int heapSize = 0;

    public Heap(List<Integer> initialList) {
        for (int x : initialList) {
            addElement(x);
        }
    }

    private void addElement(int x) {
        heap[heapSize++] = x;
        int index = heapSize - 1;
        while (heap[getParentIndex(index)] > heap[index]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private int getMin() {
        return heap[0];
    }

    private void extractMin() {
        swap(0, heapSize - 1);
        minHeapify(0);
    }

    private void minHeapify(int index) {
        if (isLeaf(index)) {
            return;
        }
        if (heap[getLeftChildIndex(index)] < heap[index] || (getRightChildIndex(index) < heapSize && heap[getRightChildIndex(index)] < heap[index])) {
            if (getRightChildIndex(index) >= heapSize || heap[getLeftChildIndex(index)] < heap[getRightChildIndex(index)]) {
                swap(index, getLeftChildIndex(index));
                minHeapify(getLeftChildIndex(index));
            } else {
                swap(index, getRightChildIndex(index));
                minHeapify(getRightChildIndex(index));
            }
        }
    }

    private int getParentIndex(int index) {
        if (index == 0) {
            return 0;
        }
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private void swap(int i, int j) {
        int x = heap[i];
        heap[i] = heap[j];
        heap[j] = x;
    }

    private boolean isLeaf(int index) {
        return index >= heapSize / 2;
    }
}

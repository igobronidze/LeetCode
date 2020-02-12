package com.leetcode.problems.p307;

class NumArray {

    private int[] nums;

    private SegmentTree segmentTree;

    public NumArray(int[] nums) {
        this.segmentTree = new SegmentTree(nums);
        this.nums = nums;
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        Node node = segmentTree.root;
        while (true) {
            node.value += diff;
            if (node.leftNode != null) {
                if (node.leftNode.rightIndex >= i) {
                    node = node.leftNode;
                } else {
                    node = node.rightNode;
                }
            } else {
                break;
            }
        }
    }

    public int sumRange(int i, int j) {
        return segmentTree.root.getSum(i, j);
    }

    public class SegmentTree {

        private Node root;

        public SegmentTree(int[] nums) {
            if (nums.length != 0) {
                root = getNode(nums, 0, nums.length - 1);
            }
        }

        private Node getNode(int[] nums, int l, int r) {
            Node node = new Node();
            node.leftIndex = l;
            node.rightIndex = r;

            if (l == r) {
                node.value = nums[l];
            } else {
                int middle = (l + r) / 2;
                node.leftNode = getNode(nums, l, middle);
                node.rightNode = getNode(nums, middle + 1, r);
                node.value = node.leftNode.value + node.rightNode.value;
            }

            return node;
        }
    }

    public class Node {

        private int leftIndex;

        private int rightIndex;

        private int value;

        private Node leftNode;

        private Node rightNode;

        public int getSum(int l, int r) {
            if (leftIndex >= l && rightIndex <= r) {
                return value;
            }
            if (l > rightIndex || r < leftIndex) {
                return 0;
            }
            return leftNode.getSum(l, r) + rightNode.getSum(l, r);
        }
    }
}
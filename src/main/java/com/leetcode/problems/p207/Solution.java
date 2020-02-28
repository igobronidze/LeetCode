package com.leetcode.problems.p207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses, prerequisites);
        return !graph.isCycle();
    }

    private class Graph {

        private Map<Integer, Node> nodes;

        private Graph(int numberOfNodes, int[][] edges) {
            nodes = new HashMap<>(numberOfNodes);
            for (int i = 0; i < numberOfNodes; i++) {
                nodes.put(i, new Node(i));
            }
            for (int i = 0; i < edges.length; i++) {
                nodes.get(edges[i][1]).addAdjacent(nodes.get(edges[i][0]));
            }
        }

        private boolean isCycle() {
            for (Node node : nodes.values()) {
                if (node.color == 0) {
                    node.color = 1;
                    boolean isCycle = node.isCycle();
                    if (isCycle) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private class Node {

        private int label;

        private List<Node> adjacents;

        private int color;

        private Node(int label) {
            this.label = label;
            this.adjacents = new ArrayList<>();
        }

        private void addAdjacent(Node adjacent) {
            this.adjacents.add(adjacent);
        }

        private boolean isCycle() {
            for (Node adjacent : adjacents) {
                if (adjacent.color == 1) {
                    return true;
                }
                adjacent.color = 1;
                boolean isCycle = adjacent.isCycle();
                if (isCycle) {
                    return true;
                }
            }
            this.color = 2;
            return false;
        }
    }
}
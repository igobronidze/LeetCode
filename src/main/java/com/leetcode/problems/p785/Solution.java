package com.leetcode.problems.p785;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {

    public boolean isBipartite(int[][] graph) {
        Graph realGraph = new Graph(graph);
        return isBipartite(realGraph);
    }

    private boolean isBipartite(Graph graph) {
        for (Node n : graph.nodes.values()) {
            if (!n.visited) {
                LinkedList<Node> toVisit = new LinkedList<>();
                Node srcNode = graph.nodes.get(n.label);
                srcNode.visited = true;
                toVisit.add(srcNode);

                while (!toVisit.isEmpty()) {
                    Node node = toVisit.poll();
                    for (Node adjacent : node.adjacents.values()) {
                        if (adjacent.visited) {
                            if (adjacent.color == node.color) {
                                return false;
                            }
                        } else {
                            adjacent.visited = true;
                            adjacent.color = !node.color;
                            toVisit.add(adjacent);
                        }
                    }
                }
            }
        }

        return true;
    }

    private class Graph {

        private Map<Integer, Node> nodes = new HashMap<>();

        private Graph(int[][] graph) {
            createNodes(graph.length);
            fillGraph(graph);
        }

        private void createNodes(int size) {
            for (int i = 0; i < size; i++) {
                nodes.put(i, new Node(i));
            }
        }

        private void fillGraph(int[][] graph) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    nodes.get(i).addAdjacent(nodes.get(graph[i][j]), true);
                }
            }
        }
    }

    private class Node {

        private int label;

        private boolean visited;

        private boolean color;

        private Node(int label) {
            this.label = label;
        }

        private Map<Integer, Node> adjacents = new HashMap<>();

        private void addAdjacent(Node node, boolean directed) {
            adjacents.put(node.label, node);
            if (directed) {
                node.adjacents.put(this.label, this);
            }
        }
    }
}
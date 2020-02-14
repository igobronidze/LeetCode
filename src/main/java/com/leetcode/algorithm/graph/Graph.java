package com.leetcode.algorithm.graph;

import java.util.HashMap;
import java.util.Map;

public class Graph {

    private boolean undirected;

    private Map<String, Node> nodes = new HashMap<>();

    public Graph() {}

    public Graph(boolean undirected) {
        this.undirected = undirected;
    }

    public Graph(int nodesCount) {
        for (int i = 0; i < nodesCount; i++) {
            addNode(String.valueOf(i));
        }
    }

    public Graph(int nodesCount, boolean undirected) {
        this(nodesCount);
        this.undirected = undirected;
    }

    public Map<String, Node> getNodes() {
        return nodes;
    }

    public void addNode(String label) {
        nodes.put(label, new Node(label));
    }

    public void addNode(int label) {
        addNode(String.valueOf(label));
    }

    public void removeNode(String label) {
        nodes.remove(label);
        for (Node node : nodes.values()) {
            node.removeEdge(label);
        }
    }

    public void removeNode(int label) {
        removeNode(String.valueOf(label));
    }

    public void addEdge(String label1, String label2) {
        if (!nodes.containsKey(label1)) {
            addNode(label1);
        }
        if (!nodes.containsKey(label2)) {
            addNode(label2);
        }
        nodes.get(label1).addEdge(nodes.get(label2));
        if (undirected) {
            nodes.get(label2).addEdge(nodes.get(label1));
        }
    }

    public void addEdge(int label1, int label2) {
        addEdge(String.valueOf(label1), String.valueOf(label2));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Node> entry : nodes.entrySet()) {
            sb.append(entry.getKey()).append(" -> ");
            sb.append(entry.getValue().getEdges().keySet());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

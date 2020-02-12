package com.leetcode.algorythm.graph;

import java.util.HashMap;
import java.util.Map;

public class Graph {

    private boolean undirected;

    private Map<String, Node> nodes = new HashMap<>();

    public Graph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addNode(String label) {
        nodes.put(label, new Node(label));
    }

    public void removeNode(String label) {
        nodes.remove(label);
        for (Node node : nodes.values()) {
            node.removeEdge(label);
        }
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

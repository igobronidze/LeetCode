package com.leetcode.algorythm.graph;

import java.util.HashMap;
import java.util.Map;

public class Node {

    private String label;

    private Map<String, Node> edges = new HashMap<>();

    public Node(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public Map<String, Node> getEdges() {
        return edges;
    }

    public void addEdge(Node node) {
        edges.put(node.getLabel(), node);
    }

    public void removeEdge(String label) {
        edges.remove(label);
    }
}

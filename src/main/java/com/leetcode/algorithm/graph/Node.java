package com.leetcode.algorithm.graph;

import java.util.HashMap;
import java.util.Map;

public class Node {

    private String label;

    private Map<String, Node> edges = new HashMap<>();

    private boolean visited;

    private int level;

    private boolean currStack;

    private int color;

    public Node(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Map<String, Node> getEdges() {
        return edges;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void addEdge(Node node) {
        edges.put(node.getLabel(), node);
    }

    public void removeEdge(String label) {
        edges.remove(label);
    }

    public boolean isCurrStack() {
        return currStack;
    }

    public void setCurrStack(boolean currStack) {
        this.currStack = currStack;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}

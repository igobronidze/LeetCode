package com.leetcode.algorithm.graph.kruskal;

import java.util.*;

public class Kruskal {

    public static List<Edge> kruskal(int n, int[][] edges) {
        Graph graph = new Graph(n);
        for (int i = 0; i < edges.length; i++) {
            graph.addEdge(edges[i][0], edges[i][1], edges[i][2]);
        }

        Collections.sort(graph.edges);

        List<Edge> mst = new ArrayList<>();
        int index = 0;
        while (mst.size() != n - 1) {
            Edge edge = graph.edges.get(index++);

            if (!graph.isCycle(edge.src, edge.dest)) {
                mst.add(edge);
                graph.union(edge.src, edge.dest);
            }
        }

        return mst;
    }

    private static class Node {

        private int label;

        private int parent;

        private int rank;

        private Node(int label) {
            this.label = label;
            this.parent = label;
        }
    }

    public static class Edge implements Comparable<Edge> {

        private int src;

        private int dest;

        private int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(this.weight, edge.weight);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return src == edge.src &&
                    dest == edge.dest &&
                    weight == edge.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(src, dest, weight);
        }
    }

    private static class Graph {

        private Map<Integer, Node> nodes = new HashMap<>();

        private List<Edge> edges = new ArrayList<>();

        private Graph(int n) {
            for (int i = 0; i < n; i++) {
                nodes.put(i, new Node(i));
            }
        }

        private void addEdge(int src, int dest, int weight) {
            edges.add(new Edge(src, dest, weight));
        }

        private int find(int label) {
            Node node = nodes.get(label);
            while (node.parent != node.label) {
                node = nodes.get(node.parent);
            }
            return node.label;
        }

        private boolean isCycle(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            return parentX == parentY;
        }

        private void union(int x, int y) {
            Node nodeX = nodes.get(find(x));
            Node nodeY = nodes.get(find(y));

            if (nodeX.rank > nodeY.rank) {
                nodeX.parent = nodeY.label;
            } else if (nodeX.rank < nodeY.rank) {
                nodeY.parent = nodeX.label;
            } else {
                nodeY.parent = nodeX.label;
                nodeX.rank++;
            }
        }
    }
}

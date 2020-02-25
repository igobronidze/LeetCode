package com.leetcode.algorithm.prim;

import java.util.*;

public class Prim {

    public static List<Edge> primMST(int n, int[][] edges) {
        Prim.Graph graph = new Prim.Graph(n);
        for (int i = 0; i < edges.length; i++) {
            graph.addEdge(edges[i][0], edges[i][1], edges[i][2]);
        }

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        Map<Integer, Edge> map = new HashMap<>();
        Edge firstEdge = new Edge(0, 0, 0);
        priorityQueue.add(firstEdge);
        map.put(0, firstEdge);

        List<Edge> mst = new ArrayList<>();
        while (mst.size() != n - 1) {
            Edge edge = priorityQueue.poll();
            if (edge.src != edge.dest) {
                mst.add(edge);
                map.remove(edge.dest);
            }
        }

        return mst;
    }

    private static class Node {

        private int label;

        private int key;

        private Map<Integer, Integer> adjacents = new HashMap<>();

        private Node(int label) {
            this.label = label;
            this.key = Integer.MAX_VALUE;
        }

        private void addAdjacent(int label, int weight) {
            adjacents.put(label, weight);
        }
    }

    private static class Graph {

        private Map<Integer, Node> nodes = new HashMap<>();

        private Graph(int n) {
            for (int i = 0; i < n; i++) {
                nodes.put(i, new Node(i));
            }
        }

        private void addEdge(int src, int dest, int weight) {
            nodes.get(src).addAdjacent(dest, weight);
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
        public int compareTo(Prim.Edge edge) {
            return Integer.compare(this.weight, edge.weight);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Prim.Edge edge = (Prim.Edge) o;
            return src == edge.src &&
                    dest == edge.dest &&
                    weight == edge.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(src, dest, weight);
        }
    }
}

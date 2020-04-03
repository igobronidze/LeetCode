package com.codeforces.div2.notfinished.round600;

import java.io.*;
import java.util.*;

import static java.util.Comparator.comparingLong;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    private static HashSet<Integer>[] queries;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int q = scanner.nextInt();
        queries = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) {
            queries[i] = new HashSet<>();
        }

        Graph graph = new Graph(n);

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(x, y, w);
        }

        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            queries[x].add(i);
            queries[y].add(i);
        }

        graph.dijikstra(k);

        graph.edges.sort(comparingLong(o -> o.weight));

        Map<Integer, Long> result = new TreeMap<>();
        DSU dsu = new DSU(n);
        for (int i = 0; i < m; i++) {
            Edge edge = graph.edges.get(i);
            result.putAll(dsu.union(edge.src, edge.dest, edge.weight));
        }

        for (long ans : result.values()) {
            out.println(ans);
        }

        out.flush();
    }

    private static class DSU {

        private Map<Integer, DSUNode> nodes;

        private DSU(int n) {
            this.nodes = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new DSUNode(i));
            }
        }

        private DSUNode find(int label) {
            DSUNode node = nodes.get(label);
            while (node.label != node.parent) {
                node = nodes.get(node.parent);
            }
            return node;
        }

        private Map<Integer, Long> union(int x, int y, long w) {
            Map<Integer, Long> result = new HashMap<>();

            DSUNode xRoot = find(x);
            DSUNode yRoot = find(y);
            if (xRoot.label == yRoot.label) {
                return result;
            }
            DSUNode tmp;
            if (yRoot.rank > xRoot.rank) {
                tmp = xRoot;
                xRoot = yRoot;
                yRoot = tmp;
            }
            yRoot.parent = xRoot.label;
            if (xRoot.rank == yRoot.rank) {
                xRoot.rank++;
            }

            for (int i : queries[yRoot.label]) {
                if (queries[xRoot.label].contains(i)) {
                    result.put(i, w);
                    queries[xRoot.label].remove(i);
                } else {
                    queries[xRoot.label].add(i);
                }
            }

            return result;
        }
    }

    private static class DSUNode {

        private int label;

        private int parent;

        private int rank;

        private Set<Integer> nodes;

        private DSUNode(int label) {
            this.label = label;
            this.parent = label;
            this.rank = 1;
            this.nodes = new HashSet<>();
            this.nodes.add(label);
        }
    }

    private static class Graph {

        private Map<Integer, Node> nodes;

        private List<Edge> edges;

        private Graph(int numberOfNodes) {
            this.nodes = new HashMap<>();
            this.edges = new ArrayList<>();
            for (int i = 1; i <= numberOfNodes; i++) {
                nodes.put(i, new Node(i));
            }
        }

        private Node getNode(int label) {
            return this.nodes.get(label);
        }

        private void addEdge(int src, int dest, long weight) {
            nodes.get(src).addEdge(dest, weight);
            nodes.get(dest).addEdge(src, weight);
            edges.add(new Edge(src, dest, weight));
        }

        private void dijikstra(int k) {
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>(comparingLong(o -> o.dist));
            for (int i = 1; i <= k; i++) {
                getNode(i).dist = 0;
                priorityQueue.add(getNode(i));
            }

            while (!priorityQueue.isEmpty()) {
                Node currNode = priorityQueue.poll();
                if (!currNode.visited) {
                    currNode.visited = true;

                    for (Edge edge : currNode.edges) {
                        Node adjacent = getNode(edge.dest);
                        if (!adjacent.visited) {
                            if (adjacent.dist > currNode.dist + edge.weight) {
                                adjacent.dist = currNode.dist + edge.weight;
                                priorityQueue.add(adjacent);
                            }
                        }
                    }
                }
            }

            for (Edge edge : edges) {
                Node src = getNode(edge.src);
                Node dest = getNode(edge.dest);
                edge.weight += src.dist + dest.dist;
            }
        }
    }

    private static class Node {

        private int label;

        private long dist;

        private List<Edge> edges;

        private boolean visited;

        private Node(int label) {
            this.label = label;
            this.dist = Long.MAX_VALUE;
            this.edges = new ArrayList<>();
            this.visited = false;
        }

        private void addEdge(int dest, long weight) {
            this.edges.add(new Edge(label, dest, weight));
        }
    }

    private static class Edge {

        private int src;

        private int dest;

        private long weight;

        private Edge(int src, int dest, long weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    private static class MyScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        private MyScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        private String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        private String nextLine() {
            String str = "";
            try {
                str = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    private static class Pair<F, S> {

        private F first;

        private S second;

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}

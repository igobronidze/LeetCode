package com.codeforces.round529;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] weights = new long[n + 1];
        int minIndex = 1;
        for (int i = 1; i <= n; i++) {
            weights[i] = scanner.nextLong();
            if (weights[i] < weights[minIndex]) {
                minIndex = i;
            }
        }

        Map<Integer, Map<Integer, Long>> edges = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            edges.put(i, new HashMap<>());
        }
        for (int i = 1; i <= n; i++) {
            if (i != minIndex) {
                edges.get(Math.min(minIndex, i)).put(Math.max(minIndex, i), weights[i] + weights[minIndex]);
            }
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int a = Math.min(x, y);
            int b = Math.max(x, y);
            long w = scanner.nextLong();
            if (edges.get(a).get(b) == null || edges.get(a).get(b) > w) {
                edges.get(a).put(b, w);
            }
        }

        Graph graph = new Graph(n);
        for (Map.Entry<Integer, Map<Integer, Long>> entry : edges.entrySet()) {
            for (Map.Entry<Integer, Long> innerEntry : entry.getValue().entrySet()) {
                graph.addEdge(entry.getKey(), innerEntry.getKey(), innerEntry.getValue());
            }
        }

        out.println(graph.getFullCost());



        out.flush();
    }

    private static class Graph {

        private Map<Integer, Node> nodes = new HashMap<>();

        private Graph(int n) {
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node(i));
            }
        }

        private void addEdge(int x, int y, long weight) {
            this.nodes.get(x).adjacents.put(y, weight);
            this.nodes.get(y).adjacents.put(x, weight);
        }

        private long getFullCost() {
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));
            priorityQueue.add(nodes.get(1));
            long ans = 0;
            while (!priorityQueue.isEmpty()) {
                Node node = priorityQueue.poll();
                if (nodes.get(node.label).visited) {
                    continue;
                }
                for (Map.Entry<Integer, Long> entry : node.adjacents.entrySet()) {
                    Node adjacent = nodes.get(entry.getKey());
                    if (!nodes.get(adjacent.label).visited) {
                        Node newNode = new Node(adjacent.label);
                        newNode.cost = entry.getValue();
                        newNode.adjacents = adjacent.adjacents;
                        priorityQueue.add(newNode);
                    }
                }
                ans += node.cost;
                nodes.get(node.label).visited = true;
            }
            return ans;
        }
    }

    private static class Node {

        private int label;

        private Map<Integer, Long> adjacents = new HashMap<>();

        private long cost;

        private boolean visited;

        private Node(int label) {
            this.label = label;
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

        public Pair() {}

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}

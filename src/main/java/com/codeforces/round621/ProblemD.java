package com.codeforces.round621;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> specialNodes = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            specialNodes.add(scanner.nextInt());
        }

        List<Pair<Integer, Integer>> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            edges.add(new Pair<>(scanner.nextInt(), scanner.nextInt()));
        }

        Map<Integer, Pair<Integer, Integer>> distances = new HashMap<>();

        Graph graph = new Graph(n);
        for (Pair<Integer, Integer> pair : edges) {
            graph.addEdge(pair.first, pair.second);
        }
        graph.bfs(1);
        int distToN = graph.nodes.get(n).dist;
        for (int specialNode : specialNodes) {
            distances.put(specialNode, new Pair<>(graph.nodes.get(specialNode).dist, 0));
        }

        graph = new Graph(n);
        for (Pair<Integer, Integer> pair : edges) {
            graph.addEdge(pair.first, pair.second);
        }
        graph.bfs(n);
        for (int specialNode : specialNodes) {
            distances.get(specialNode).second = graph.nodes.get(specialNode).dist;
        }

        List<Pair<Integer, Integer>> distList = new ArrayList<>(distances.values());
        distList.sort((p1, p2) -> Integer.compare(p1.first - p2.first, p1.second - p2.second));

        int[] maxArr = new int[distList.size() + 1];

        maxArr[distList.size() - 1] = distList.get(distList.size() - 1).second;
        for (int i = distList.size() - 2; i >= 0; i--) {
            maxArr[i] = Integer.max(maxArr[i + 1], distList.get(i).second);
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < distList.size() - 1; i++) {
            ans = Math.max(ans, distList.get(i).first + maxArr[i + 1]);
        }

        out.println(Math.min(ans + 1, distToN));


        out.flush();
    }

    private static class Graph {

        private Map<Integer, Node> nodes;

        private Graph(int numberOfNodes) {
            this.nodes = new HashMap<>();
            for (int i = 1; i <= numberOfNodes; i++) {
                nodes.put(i, new Node(i));
            }
        }

        private void addEdge(int x, int y) {
            nodes.get(x).addAdjacent(nodes.get(y));
            nodes.get(y).addAdjacent(nodes.get(x));
        }

        private void bfs(int label) {
            Node root = nodes.get(label);
            root.visited = true;

            LinkedList<Node> linkedList = new LinkedList<>();
            linkedList.add(root);
            while (!linkedList.isEmpty()) {
                Node node = linkedList.poll();
                for (Node adjacent : node.adjacents) {
                    if (!adjacent.visited) {
                        adjacent.visited = true;
                        adjacent.dist = node.dist + 1;
                        linkedList.add(adjacent);
                    }
                }
            }
        }
    }

    private static class Node {

        private int label;

        private int dist;

        private boolean visited;

        private List<Node> adjacents;

        private Node(int label) {
            this.label = label;
            this.dist = 0;
            this.visited = false;
            this.adjacents = new ArrayList<>();
        }

        private void addAdjacent(Node node) {
            this.adjacents.add(node);
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

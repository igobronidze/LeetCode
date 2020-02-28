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

        Graph graph = new Graph(n);
        for (Pair<Integer, Integer> pair : edges) {
            graph.addEdge(pair.first, pair.second);
        }
        graph.bfs(1);
        int distToN = graph.nodes.get(n).dist;
        List<Pair<Integer, Integer>> distancesFrom1 = new ArrayList<>();
        for (int specialNode : specialNodes) {
            distancesFrom1.add(new Pair<>(specialNode,  graph.nodes.get(specialNode).dist));
        }



        graph = new Graph(n);
        for (Pair<Integer, Integer> pair : edges) {
            graph.addEdge(pair.first, pair.second);
        }
        graph.bfs(n);
        List<Pair<Integer, Integer>> distancesFromN = new ArrayList<>();
        for (int specialNode : specialNodes) {
            distancesFromN.add(new Pair<>(specialNode,  graph.nodes.get(specialNode).dist));
        }

        distancesFrom1.sort((t1, t2) -> Integer.compare(t2.second, t1.second));
        distancesFromN.sort((t1, t2) -> Integer.compare(t2.second, t1.second));

        int ans = 0;
        if (!distancesFrom1.get(0).first.equals(distancesFromN.get(0).first)) {
            ans = Math.min(distToN, distancesFrom1.get(0).second + distancesFromN.get(0).second + 1);
        } else {
            int max = Math.max(distancesFrom1.get(0).second + distancesFromN.get(1).second + 1, distancesFrom1.get(1).second + distancesFromN.get(0).second + 1);
            ans = Math.min(max, distToN);
        }

        out.println(ans);


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

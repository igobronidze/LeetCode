package com.codeforces.div2.round625;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class ProblemD_2 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Graph graph = new Graph(n);
        Graph realGraph = new Graph(n);

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.addEdge(y, x);
            realGraph.addEdge(x, y);
        }

        int k = scanner.nextInt();
        List<Integer> pList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            pList.add(scanner.nextInt());
        }

        int dest = pList.get(pList.size() - 1);

        graph.bfs(dest);

        int min = 0, max = 0;

        for (int i = 1; i < k; i++) {
            int count = 0;
            int minDist = Integer.MAX_VALUE;
            for (Node adjacent : realGraph.nodes.get(pList.get(i - 1)).adjacents) {
                minDist = Math.min(minDist, graph.nodes.get(adjacent.label).dist);
            }
            if (minDist == graph.nodes.get(pList.get(i)).dist) {
                for (Node adjacent : realGraph.nodes.get(pList.get(i - 1)).adjacents) {
                    if (graph.nodes.get(adjacent.label).dist == minDist) {
                        count++;
                    }
                }
                if (count > 1) {
                    max++;
                }
            } else {
                min++;
                max++;
            }
        }

        out.println(min + " " + max);


        out.flush();
    }

    private static class Graph {

        private Map<Integer, Node> nodes;

        private Graph(int n) {
            nodes = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node(i));
            }
        }

        private void addEdge(int x, int y) {
            nodes.get(x).addAdjacent(nodes.get(y));
        }

        private void bfs(int src) {
            Node srcNode = nodes.get(src);
            srcNode.dist = 1;
            srcNode.currVisited = true;
            LinkedList<Node> toVisit = new LinkedList<>();
            toVisit.add(srcNode);
            while (!toVisit.isEmpty()) {
                Node node = toVisit.poll();
                for (Node adjacent : node.adjacents) {
                    if (!adjacent.currVisited) {
                        adjacent.dist = node.dist + 1;
                        adjacent.currVisited = true;
                        toVisit.add(adjacent);
                    }
                }
            }
        }
    }

    private static class Node {

        private int label;

        private int dist;

        private boolean currVisited;

        private List<Node> adjacents;

        private Node(int label) {
            this.adjacents = new ArrayList<>();
            this.label = label;
        }

        private void addAdjacent(Node node) {
            this.adjacents.add(node);
        }
    }
}

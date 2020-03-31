package com.codeforces.div2.round625;

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

        Graph graph = new Graph(n);

        for (int i = 0; i < m; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt());
        }

        int k = scanner.nextInt();
        List<Integer> pList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            pList.add(scanner.nextInt());
        }

        int src = pList.get(0);
        int dest = pList.get(pList.size() - 1);

        graph.dfs(src, dest);

        int min = 0, max = 0;

        for (int i = 1; i < k; i++) {
            Node node = graph.nodes.get(pList.get(i));
            int count = 0;
            int minDist = Integer.MAX_VALUE;
            for (Node adjacent : graph.nodes.get(pList.get(i - 1)).adjacents) {
                minDist = Math.min(minDist, adjacent.dist);
            }
            if (minDist == node.dist) {
                for (Node adjacent : graph.nodes.get(pList.get(i - 1)).adjacents) {
                    if (adjacent.dist == minDist) {
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

        private void dfs(int src, int dest) {
            Node srcNode = nodes.get(src);
            srcNode.dist = srcNode.dfs(dest);
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

        private int dfs(int dest) {
            if (label == dest) {
                return 1;
            }
            this.currVisited = true;

            int min = Integer.MAX_VALUE;
            for (Node adjacent : adjacents) {
                if (adjacent.currVisited) {
                    continue;
                }
                if (adjacent.dist > 0) {
                    min = Math.min(min, adjacent.dist + 1);
                } else {
                    min = Math.min(min, adjacent.dfs(dest) + 1);
                }
            }
            this.currVisited = false;
            this.dist = min;
            return min;
        }
    }
}

package com.codeforces.round600;

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
        Graph graph = new Graph(n);

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt(), true);
        }

        int maxVisitedNode = 0;
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (!graph.nodes[i].visited) {
                int innerMaxVisitedNode = graph.bfs(i);
                if (i < maxVisitedNode) {
                    ans++;
                }
                maxVisitedNode = Math.max(maxVisitedNode, innerMaxVisitedNode);
            }
        }

        out.print(ans);


        out.flush();
    }

    private static class Graph {

        private Node[] nodes;

        private Graph(int numberOfNodes) {
            nodes = new Node[numberOfNodes + 1];
            for (int i = 1; i <= numberOfNodes; i++) {
                nodes[i] = new Node(i);
            }
        }

        private void addEdge(int x, int y, boolean undirected) {
            nodes[x].adjacents.add(nodes[y]);
            if (undirected) {
                nodes[y].adjacents.add(nodes[x]);
            }
        }

        private int bfs(int label) {
            int maxVisitedNode = 0;
            Node fitsNode = nodes[label];
            fitsNode.visited = true;
            LinkedList<Node> toVisit = new LinkedList<>();
            toVisit.add(fitsNode);
            while (!toVisit.isEmpty()) {
                Node node = toVisit.poll();
                maxVisitedNode = Math.max(maxVisitedNode, node.label);
                for (Node adjacent : node.adjacents) {
                    if (!adjacent.visited) {
                        adjacent.visited = true;
                        toVisit.add(adjacent);
                    }
                }
            }
            return maxVisitedNode;
        }
    }

    private static class Node {

        private int label;

        private List<Node> adjacents = new ArrayList<>();

        private boolean visited;

        private Node(int label) {
            this.label = label;
        }
    }
}

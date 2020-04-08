package com.codeforces.div3.finished.round544;

import java.io.*;
import java.util.*;

public class ProblemF_1 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Graph graph = new Graph(n);
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.addEdge(x, y);
        }

        int rootLabel = 1;
        for (int i = 1; i <= n; i++) {
            if (graph.nodes.get(i).adjacents.size() > graph.nodes.get(rootLabel).adjacents.size()) {
                rootLabel = i;
            }
        }

        List<Pair<Integer, Integer>> ans = graph.bfs(rootLabel);
        for (Pair<Integer, Integer> pair : ans) {
            out.println(pair.first + " " + pair.second);
        }



        out.flush();
    }

    private static class Graph {

        private Map<Integer, Node> nodes = new HashMap<>();

        private Graph(int n) {
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node(i));
            }
        }

        private void addEdge(int x, int y) {
            nodes.get(x).adjacents.add(nodes.get(y));
            nodes.get(y).adjacents.add(nodes.get(x));
        }

        private List<Pair<Integer, Integer>> bfs(int rootLabel) {
            List<Pair<Integer, Integer>> ansEdges =new ArrayList<>();
            LinkedList<Node> toVisit = new LinkedList<>();
            Node root = nodes.get(rootLabel);
            root.visited = true;
            toVisit.add(root);
            while (!toVisit.isEmpty()) {
                Node node = toVisit.poll();
                for (Node adjacent : node.adjacents) {
                    if (!adjacent.visited) {
                        adjacent.visited = true;
                        toVisit.add(adjacent);
                        ansEdges.add(new Pair<>(node.label, adjacent.label));
                    }
                }
            }

            return ansEdges;
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

    private static class Triple<F, S, T> {

        private F first;

        private S second;

        private T third;

        public Triple() {
        }

        public Triple(F first, S second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}

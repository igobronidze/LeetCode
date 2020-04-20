package com.codeforces.div3.finished.round498;

import java.io.*;
import java.util.*;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        Graph graph = new Graph(n);
        for (int i = 2; i <= n; i++) {
            graph.addEdge(scanner.nextInt(), i);
        }

        List<Integer> path = graph.dfs(1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(path.get(i), i);
        }

        for (int i = 0; i < q; i++) {
            int u = scanner.nextInt();
            int k = scanner.nextInt();
            if (graph.nodes.get(u).value < k) {
                out.println(-1);
            } else {
                out.println(path.get(map.get(u) + k - 1));
            }
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
            nodes.get(x).children.add(nodes.get(y));
        }

        private List<Integer> dfs(int rootLabel) {
            return nodes.get(rootLabel).dfs(new ArrayList<>());
        }
    }

    private static class Node {

        private int label;

        private boolean visited;

        private int value;

        private List<Node> children = new ArrayList<>();

        private Node(int label) {
            this.label = label;
        }

        private List<Integer> dfs(List<Integer> path) {
            value = 1;
            path.add(label);
            for (Node child : children) {
                if (!child.visited) {
                    child.dfs(path);
                    value += child.value;
                }
            }
            return path;
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

    private static class Triple<F, S, T> {

        private F first;

        private S second;

        private T third;

        public Triple() {}

        public Triple(F first, S second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}

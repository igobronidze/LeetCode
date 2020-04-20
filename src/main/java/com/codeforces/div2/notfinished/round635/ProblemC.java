package com.codeforces.div2.notfinished.round635;

import java.io.*;
import java.util.*;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Graph graph = new Graph(n);
        for (int i = 0; i < n -1; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt());
        }

        graph.dfs();

        List<Node> nodes = new ArrayList<>(graph.nodes.values());
        Collections.sort(nodes, (a, b) -> Integer.compare(b.path - b.childrenNumber, a.path - a.childrenNumber));

        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += nodes.get(i).path - nodes.get(i).childrenNumber;
        }

        out.println(ans);


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
            nodes.get(y).children.add(nodes.get(x));
        }

        private void dfs() {
            nodes.get(1).path = -1;
            nodes.get(1).dfs(nodes.get(1));
        }
    }

    private static class Node {

        private int label;

        private int path;

        private int childrenNumber;

        private List<Node> children = new ArrayList<>();

        private Node(int label) {
            this.label = label;
        }

        private void dfs(Node parent) {
            this.path = parent.path + 1;
            for (Node child : children) {
                if (child.label != parent.label) {
                    child.dfs(this);
                    this.childrenNumber += child.childrenNumber + 1;
                }
            }
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

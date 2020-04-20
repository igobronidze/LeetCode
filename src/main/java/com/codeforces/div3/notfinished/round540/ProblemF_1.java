package com.codeforces.div3.notfinished.round540;

import java.io.*;
import java.util.*;

public class ProblemF_1 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Integer> colors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            colors.add(scanner.nextInt());
        }
        Graph graph = new Graph(n, colors);
        for (int i = 0; i < n - 1; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt());
        }

        graph.dfs();

        out.println(graph.countGoodEdges());




        out.flush();
    }

    private static class Graph {

        private Map<Integer, Node> nodes = new HashMap<>();

        private Graph(int n, List<Integer> colors) {
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node(i, colors.get(i - 1)));
            }
        }

        private void addEdge(int x, int y) {
            nodes.get(x).children.add(nodes.get(y));
            nodes.get(y).children.add(nodes.get(x));
        }

        private void dfs() {
            nodes.get(1).dfs(nodes.get(1));
        }

        private int countGoodEdges() {
            return nodes.get(1).countGoodEdges(nodes.get(1), nodes.get(1).redsAmount, nodes.get(1).bluesAmount);
        }
    }

    private static class Node {

        private int label;

        private int color;

        private int redsAmount;

        private int bluesAmount;

        private List<Node> children = new ArrayList<>();

        private Node(int label, int color) {
            this.label = label;
            this.color = color;
        }

        private void dfs(Node parent) {
            for (Node child : children) {
                if (child.label != parent.label) {
                    child.dfs(this);
                    redsAmount += child.redsAmount;
                    bluesAmount += child.bluesAmount;
                }
            }
            if (color == 1) {
                redsAmount++;
            } else if (color == 2) {
                bluesAmount++;
            }
        }

        private int countGoodEdges(Node parent, int allRed, int allBlue) {
            int count = 0;
            for (Node child : children) {
                if (parent.label != child.label) {
                    count += child.countGoodEdges(this, allRed, allBlue);
                    if ((child.redsAmount == 0 || child.bluesAmount == 0) && (allRed == child.redsAmount || allBlue == child.bluesAmount)) {
                        count++;
                    }
                }
            }
            return count;
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

package com.codeforces.div2.notfinished.round633;

import java.io.*;
import java.util.*;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        Graph graph = new Graph(n);
        for (int i = 0; i < n - 1; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt());
        }
        graph.dfs();

        int x = n - 1;
        for (Node node : graph.nodes.values()) {
            if (node.childLeaves > 1) {
                x = x - node.childLeaves + 1;
            }
        }

        Node root = graph.nodes.get(1);
        if (root.children.size() == 1) {
            if (root.children.get(0).childLeaves != 0) {
                x--;
            }
        }

        boolean canOne = true;
        if (root.children.size() == 1) {
            for (Node node : graph.nodes.values()) {
                if (node.leaf && node.level % 2 == 1) {
                    canOne = false;
                }
            }
        } else {
            boolean odd = false;
            boolean even = false;
            for (Node node : graph.nodes.values()) {
                if (node.leaf && node.level % 2 == 1) {
                    odd = true;
                }
                if (node.leaf && node.level % 2 == 0) {
                    even = true;
                }
            }
            if (even && odd) {
                canOne = false;
            }
        }

        if (canOne) {
            out.print("1 " + x);
        } else {
            out.print("3 " + x);
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
            nodes.get(y).children.add(nodes.get(x));
        }

        private void dfs() {
            Node root = nodes.get(1);
            root.dfs(root);
        }
    }

    private static class Node {

        private int label;

        private int level;

        private boolean leaf;

        private int childLeaves;

        private List<Node> children = new ArrayList<>();

        private Node(int label) {
            this.label = label;
        }

        private void dfs(Node parent) {
            boolean hasChild = false;
            for (Node child : children) {
                if (child.label != parent.label) {
                    hasChild = true;
                    child.level = level + 1;
                    child.dfs(this);
                    if (child.leaf) {
                        childLeaves++;
                    }
                }
            }
            leaf = !hasChild;
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
